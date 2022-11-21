package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/marcas")
public class MarcaController {

    private final MarcaService marcaService;


    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    public ResponseEntity create(@RequestHeader(value = "client-id") String clientId,
                                 @RequestBody MarcaDTO marcaDTO){
        MarcaDTO createMarcaDTO = marcaService.create(marcaDTO);

        return new ResponseEntity(marcaDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity retrieve(){
        return new ResponseEntity(marcaService.retrieveAll(),HttpStatus.OK);
    }

    @GetMapping("/{marcaId}")
    public ResponseEntity retrieveById(@PathVariable Integer marcaId) {
        MarcaDTO marcaDTO = marcaService.retrieveById(marcaId);

        return new ResponseEntity(marcaDTO, HttpStatus.OK);
    }

}
