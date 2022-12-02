package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*Método crea un cliente en la base de datos*/
    @PostMapping
    public ResponseEntity create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoClienteDTO = clienteService.create(clienteDTO);
        return new ResponseEntity(clienteDTO, HttpStatus.CREATED);
    }

    /*Método que recibe todos los clientes de la base de datos*/
    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(clienteService.retrieveAll(), HttpStatus.OK);
    }

    /*Método que recibe una peticion y devuelve de la base de datos un cliente*/
    @GetMapping("/{clienteId}")
    public ResponseEntity retrieveById(@PathVariable Integer clienteId) {
        ClienteDTO clienteDTO = clienteService.retrieveById(clienteId);

        return new ResponseEntity(clienteDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity delete(@PathVariable String clienteId) {
        clienteService.delete(Integer.valueOf(clienteId));

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/{clienteId}")
    public ResponseEntity replace(@PathVariable String clienteId,
                                  @RequestBody ClienteDTO clienteDTO) {
        clienteService.replace(Integer.valueOf(clienteId), clienteDTO);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PatchMapping("/{clienteId}")
    public ResponseEntity modify(@PathVariable Integer clienteId,
                                 @RequestBody Map<Integer, Object> fieldsToModify) {
        clienteService.modify(clienteId, fieldsToModify);

        return new ResponseEntity(HttpStatus.OK);
    }


}
