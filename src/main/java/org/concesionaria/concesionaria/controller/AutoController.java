package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/autos")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestHeader(value = "client-id", required = false) String clientId,
                                 @RequestBody AutoDTO autoDTO){
            AutoDTO createdAutoDTO = autoService.create(autoDTO);

            return new ResponseEntity(autoDTO.getNumeroChasis(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity retriever(){
        return new ResponseEntity(autoService.retrieveAll(),HttpStatus.CREATED);

    }
}
