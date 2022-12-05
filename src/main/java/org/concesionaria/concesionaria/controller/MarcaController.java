package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/marca")
public class MarcaController {

    private final MarcaService marcaService;


    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MarcaDTO marcaDTO){
        MarcaDTO createMarcaDTO = marcaService.create(marcaDTO);

        return new ResponseEntity(marcaDTO, HttpStatus.CREATED);
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
    @DeleteMapping("/{marcaId}")
    public ResponseEntity delete(@PathVariable Integer marcaId){
        marcaService.delete(marcaId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{marcaId}")
    public ResponseEntity replace(@PathVariable Integer marcaId,
                                  @RequestBody MarcaDTO marcaDTO){
        marcaService.replace(marcaId,marcaDTO);
        return new ResponseEntity(marcaDTO,HttpStatus.OK);
    }
    @PatchMapping("/{marcaId}")
    public ResponseEntity modify(@PathVariable Integer marcaId,
                                 @RequestBody Map<String,Object> fieldsToModify){
        marcaService.modify(marcaId,fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }

}
