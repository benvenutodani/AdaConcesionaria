package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/auto")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody AutoDTO autoDto) {
        AutoDTO nuevoAutoDto = autoService.create(autoDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity retrieve() {

        return new ResponseEntity(autoService.retrieveAll(), HttpStatus.OK);
    }


    @GetMapping("/{autoId}")
    public ResponseEntity retrieveById(@PathVariable String autoId) {
        AutoDTO autoDto = autoService.retrieveById(autoId);

        return new ResponseEntity(autoDto, HttpStatus.OK);
    }


    @DeleteMapping("/{autoId}")
    public ResponseEntity delete(@PathVariable String autoId) {
        autoService.delete(autoId);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/{autoId}")
    public ResponseEntity replace(@PathVariable String autoId,
                                  @RequestBody AutoDTO autoDto) {
        autoService.replace(autoId, autoDto);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PatchMapping("/{autoId}")
    public ResponseEntity modify(@PathVariable String autoId,
                                 @RequestBody Map<String, Object> fieldsToModify) {
        autoService.modify(autoId, fieldsToModify);

        return new ResponseEntity(HttpStatus.OK);
    }

}