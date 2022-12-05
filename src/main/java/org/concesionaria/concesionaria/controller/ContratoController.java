package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.dto.ContratoDTO;
import org.concesionaria.concesionaria.service.ContratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(path = "/contrato")
public class ContratoController {
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    /*Crea un registro en la base de datos*/
    @PostMapping
    public ResponseEntity create(@RequestBody ContratoDTO contratoDTO){
        ContratoDTO createcontratoDTO = contratoService.create(contratoDTO);
        return new ResponseEntity (contratoDTO,HttpStatus.CREATED);
    }

    /*Muestra todos los registro */
    @GetMapping
    public ResponseEntity retrieve(){
        return new ResponseEntity(contratoService.retrieveAll(),HttpStatus.OK);
    }

    @GetMapping("/{contratoId}")
    public ResponseEntity retrieveById(@PathVariable Integer contratoId){
        ContratoDTO contratoDTO = contratoService.retrieveById(contratoId);
        return new ResponseEntity(contratoDTO,HttpStatus.OK);
    }

    /*Borra un registro*/
    @DeleteMapping("/{contratoId}")
    public ResponseEntity delete(@PathVariable Integer contratoId){
        contratoService.delete(contratoId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{contratoId}")
    public ResponseEntity replace(@PathVariable Integer contratoId,
                                  @RequestBody ContratoDTO contratoDto) {
        contratoService.replace(contratoId, contratoDto);

        return new ResponseEntity(contratoDto, HttpStatus.OK);
    }

    /*modifica*/
    @PatchMapping("/{contratoId}")
     public ResponseEntity modify(@PathVariable Integer contratoId,
                               @RequestBody Map<String,Object> fieldsToModify){
        contratoService.modify(contratoId,fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);

  }
}
