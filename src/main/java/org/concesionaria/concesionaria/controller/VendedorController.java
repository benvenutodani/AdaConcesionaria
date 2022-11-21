package org.concesionaria.concesionaria.controller;


import org.concesionaria.concesionaria.dto.VendedorDTO;
import org.concesionaria.concesionaria.service.VendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vendedor")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    /*Método crea un vendedor en la base de datos*/
    @PostMapping
    public ResponseEntity create(@RequestBody VendedorDTO vendedorDTO) {

        VendedorDTO nuevoVendedorDTO = vendedorService.create(vendedorDTO);

        return new ResponseEntity(vendedorDTO, HttpStatus.CREATED);
    }

    /*Método que recibe todos los vendedores de la base de datos*/
    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(vendedorService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity retrieveById(@PathVariable String vendedorId) {
        VendedorDTO vendedorDTO = vendedorService.retrieveById(vendedorId);

        return new ResponseEntity(vendedorDTO, HttpStatus.OK);
    }

}
