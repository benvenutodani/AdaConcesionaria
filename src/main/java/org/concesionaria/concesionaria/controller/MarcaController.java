package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity retrieveById(@PathVariable String marcaId) {
        MarcaDTO marcaDTO = marcaService.retrieveById(Integer.valueOf(marcaId));

        return new ResponseEntity(marcaDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{maracId}")
    public ResponseEntity delete(@PathVariable String marcaId){
        marcaService.delete(Integer.valueOf(marcaId));
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{marcaId}")
    public ResponseEntity replace(@PathVariable String marcaId,
                                  @RequestBody MarcaDTO marcaDTO){
        marcaService.replace(Integer.valueOf(marcaId),marcaDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity modify(@PathVariable String marcaId,
                                 @RequestBody Map<Integer,Object> fieldsToModify){
        marcaService.modify(Integer.valueOf(marcaId),fieldsToModify);
        return new ResponseEntity(HttpStatus.OK);
    }

}
