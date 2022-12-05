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

        return new ResponseEntity(metodoPagoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity retrieve(){

        return new ResponseEntity (metodoPagoService.retrieveAll(), HttpStatus.OK);
    }
    @GetMapping("/{metodoPagoId}")
    public  ResponseEntity retrieveById(@PathVariable Integer metodoPagoId){
        MetodoPagoDTO metodoPagoDTO = metodoPagoService.retrieveById(metodoPagoId);
        return new ResponseEntity(metodoPagoDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{metodoPagoId}")
    public ResponseEntity delete(@PathVariable Integer metodoPagoId){
        metodoPagoService.delete(metodoPagoId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{metodoPagoid}")
    public ResponseEntity replace(@PathVariable Integer metodoPagoId,
                                  @RequestBody MetodoPagoDTO metodoPagoDTO){
        metodoPagoService.replace(metodoPagoId,metodoPagoDTO);
        return new ResponseEntity(metodoPagoDTO,HttpStatus.OK);
    }
    @PatchMapping("/{metodoPagoId}")
    public ResponseEntity modify(@PathVariable Integer metodoPagoId,
                                 @RequestBody Map<String,Object> fieldsToModify){
        metodoPagoService.modify(metodoPagoId,fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }


}
