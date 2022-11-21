package org.concesionaria.concesionaria.controller;


import org.concesionaria.concesionaria.DTO.MetodoPagoDTO;
import org.concesionaria.concesionaria.service.MetodoPagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

public ResponseEntity retrieve(){
        return new ResponseEntity (metodoPagoService.retrieveAll(), HttpStatus.OK);
}

    }

