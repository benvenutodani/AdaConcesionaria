package org.concesionaria.concesionaria.controller;


import org.concesionaria.concesionaria.DTO.TipoIdentidadDTO;
import org.concesionaria.concesionaria.service.TipoIdentidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public  ResponseEntity retrieve(){
        return new ResponseEntity(tipoIdentidadService.retrieveAll(), HttpStatus.OK);
    }
}
