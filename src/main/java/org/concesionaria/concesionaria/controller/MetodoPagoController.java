package org.concesionaria.concesionaria.controller;


import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.dto.MetodoPagoDTO;
import org.concesionaria.concesionaria.service.MetodoPagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/metodoPago")
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;


    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody MetodoPagoDTO metodoPagoDTO){
        MetodoPagoDTO createdMetodoPago = metodoPagoService.create(metodoPagoDTO);

        return new ResponseEntity(metodoPagoDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity retrieve(){

        return new ResponseEntity (metodoPagoService.retrieveAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity retrieveById(@PathVariable String id){
        MetodoPagoDTO metodoPagoDTO = metodoPagoService.retrieveById(Integer.valueOf(id));
        return new ResponseEntity(metodoPagoDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        metodoPagoService.delete(Integer.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity replace(@PathVariable String id,
                                  @RequestBody MetodoPagoDTO metodoPagoDTO){
        metodoPagoService.replace(Integer.valueOf(id),metodoPagoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity modify(@PathVariable String id,
                                 @RequestBody Map<Integer,Object> fieldsToModify){
        metodoPagoService.modify(Integer.valueOf(id),fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }


}
