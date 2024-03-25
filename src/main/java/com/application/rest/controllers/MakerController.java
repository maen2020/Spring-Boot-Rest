package com.application.rest.controllers;

import com.application.rest.controllers.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.service.IMakerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

//
@RestController
@RequestMapping("/api/maker") //URl hacia donde apunta el endpoint
public class MakerController {

    //Inyectar la capa de servicio IMakerService
    @Autowired
    private IMakerService makerService;

    //Metodo para buscar un maker por el id.
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();

            //Extraer los atributos del la entidad y setearlos al DTO.
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();

            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo para buscar todos los fabricantes.
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        //Convertir la entidad a un DTO.
        List<MakerDTO> makerList = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerList);
    }

    //Metodo para guadar un maker(Fabricante)
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        if (makerDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        //Convertir o setear el nombre de la entidad a DTO.
        makerService.save(Maker.builder()
                .name(makerDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    //Metodo pra actualizar un fabricante o maker.
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){

        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()){ //Condicion para saber si existe el maker a actualizar.
            Maker maker = makerOptional.get(); //Recuperando la entidad Maker.
            maker.setName(makerDTO.getName()); //Cambiando el nombre.
            makerService.save(maker); //Guardando el nuevo nombre.
            return ResponseEntity.ok("Registration correctly updated.");
        }

        return ResponseEntity.notFound().build();
    }

    //Metodo para eliminar un maker por su id.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if (id != null){
            makerService.deleteById(id);
            return ResponseEntity.ok("Record successfully deleted.");
        }
        return ResponseEntity.badRequest().build();
    }
}
