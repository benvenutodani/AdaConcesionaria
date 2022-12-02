package org.concesionaria.concesionaria.controller;


import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.dto.TipoIdentidadDTO;
import org.concesionaria.concesionaria.service.TipoIdentidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path ="/tipoIdentidad")
public class TipoIdentidadController {

    private final TipoIdentidadService tipoIdentidadService;

    public TipoIdentidadController(TipoIdentidadService tipoIdentidadService) {
        this.tipoIdentidadService = tipoIdentidadService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody TipoIdentidadDTO tipoIdentidadDTO){

        TipoIdentidadDTO nuevoTipoIdentidadDTO = tipoIdentidadService.create(tipoIdentidadDTO);

        return new ResponseEntity(tipoIdentidadDTO.getId(), HttpStatus.CREATED);

    }

    @GetMapping
    public  ResponseEntity retrieve(){

        return new ResponseEntity(tipoIdentidadService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping("/{tipoIdentidadId}")
    public ResponseEntity retrieveById(@PathVariable String tipoIdentidadId) {
        TipoIdentidadDTO tipoIdentidadDTO = tipoIdentidadService.retrieveById(Integer.valueOf(tipoIdentidadId));

        return new ResponseEntity(tipoIdentidadDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{tipoIdentidadId}")
    public ResponseEntity delete(@PathVariable String tipoIdentidadId) {
        tipoIdentidadService.delete(Integer.valueOf(tipoIdentidadId));

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/{tipoIdentidadId}")
    public ResponseEntity replace(@PathVariable String tipoIdentidadId,
                                  @RequestBody TipoIdentidadDTO tipoIdentidadDTO) {
        tipoIdentidadService.replace(Integer.valueOf(tipoIdentidadId), tipoIdentidadDTO);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PatchMapping("/{tipoIdentidadId}")
    public ResponseEntity modify(@PathVariable String tipoIdentidadId,
                                 @RequestBody Map<Integer, Object> fieldsToModify) {
        tipoIdentidadService.modify(Integer.valueOf(tipoIdentidadId), fieldsToModify);

        return new ResponseEntity(HttpStatus.OK);
    }



}