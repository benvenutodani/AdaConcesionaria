package org.concesionaria.concesionaria.controller;

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

    @PostMapping
    public ResponseEntity create(@RequestBody ContratoDTO contratoDTO){
        ContratoDTO createcontratoDTO = contratoService.create(contratoDTO);
        return new ResponseEntity (contratoDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity retrieve(){
        return new ResponseEntity(contratoService.retrieveAll(),HttpStatus.OK);
    }

    @GetMapping("/{contratoId}")
    public ResponseEntity retrieveById(@PathVariable String contratoId){
        ContratoDTO contratoDTO = contratoService.retrieveById(Integer.valueOf((contratoId)));
        return new ResponseEntity(contratoDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{contratoId}")
    public ResponseEntity delete(@PathVariable String contratoId){
        contratoService.delete(Integer.valueOf(contratoId));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{contratoId}")
     public ResponseEntity modify(@PathVariable String contratoId,
                               @RequestBody Map<String,Object> fieldsToModify){
        contratoService.modify(Integer.valueOf(contratoId),fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);

  }
}
