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

    /* Crea un cliente en la base de datos*/
    @PostMapping
    public ResponseEntity create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO nuevoClienteDTO = clienteService.create(clienteDTO);
        return new ResponseEntity(clienteDTO, HttpStatus.CREATED);
    }

    /*Recibe todos los clientes de la base de datos*/
    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(clienteService.retrieveAll(), HttpStatus.OK);
    }

    /*Muestra todos los campos de un registro, recibiendo el Id*/
    @GetMapping("/{clienteId}")
    public ResponseEntity retrieveById(@PathVariable Integer clienteId) {
        ClienteDTO clienteDTO = clienteService.retrieveById(clienteId);

        return new ResponseEntity(clienteDTO, HttpStatus.OK);
    }

    /*Borra un registro de la base de datos*/
    @DeleteMapping("/{clienteId}")
    public ResponseEntity delete(@PathVariable Integer clienteId) {
        clienteService.delete(clienteId);

        return new ResponseEntity(HttpStatus.OK);
    }

    /*Modifica todos lo campos de un registro*/
    @PutMapping("/{clienteId}")
    public ResponseEntity replace(@PathVariable Integer clienteId,
                                  @RequestBody ClienteDTO clienteDTO) {
        clienteService.replace(clienteId, clienteDTO);

        return new ResponseEntity(clienteDTO,HttpStatus.OK);
    }

    /*Modifica uno o varios campos de un registro*/
    @PatchMapping("/{clienteId}")
    public ResponseEntity modify(@PathVariable Integer clienteId,
                                 @RequestBody Map<String, Object> fieldsToModify) {
        clienteService.modify(clienteId, fieldsToModify);

        return new ResponseEntity(HttpStatus.OK);
    }


}
