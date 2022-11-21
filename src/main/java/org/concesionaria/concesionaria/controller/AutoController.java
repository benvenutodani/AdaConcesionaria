package org.concesionaria.concesionaria.controller;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/autos/{autoNumeroChasis}/autos")
public class AutoController {

}
