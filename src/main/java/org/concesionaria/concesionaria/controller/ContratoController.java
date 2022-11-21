package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.ContratoDTO;
import org.concesionaria.concesionaria.service.ContratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/contrato")
public class ContratoController {
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ContratoDTO contratoDto){
        ContratoDTO contratoDTO = ContratoService.create(contratoDto);
        return new ResponseEntity (contratoDto, HttpStatus.CREATED);
    }
}
