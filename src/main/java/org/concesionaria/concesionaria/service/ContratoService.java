package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.dto.ContratoDTO;
import org.concesionaria.concesionaria.entity.Cliente;
import org.concesionaria.concesionaria.entity.Contrato;
import org.concesionaria.concesionaria.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public ContratoDTO create(ContratoDTO contratoDTO) {
        Contrato contrato = mapToEntity(contratoDTO);
        contrato = contratoRepository.save(contrato);

        return contratoDTO;
    }

    public List<ContratoDTO> retrieveAll() {

        List<Contrato> contratos = contratoRepository.findAll();

        return contratos.stream()
                .map(cliente -> mapToDTO(cliente))
                .collect(Collectors.toList());
    }


    /*cambiar los get*/
    private ContratoDTO mapToDTO(Contrato contrato) {

        ContratoDTO contratoDTO = new ContratoDTO(contrato.getCliente(),contrato.getVendedor(), contrato.getAuto(),
                                    contrato.getMetodoPago(), contrato.getFecha().toString(),contrato.getCuotas());

    }
    /*cambiar los get*/
    private static Contrato mapToEntity(ContratoDTO contratoDto) {

        Contrato contrato= new Contrato(contratoDto.getCliente(), contratoDto.getVendedor(), contratoDto.getAuto(), contratoDto.getMetodoPago(),
                                        LocalDate.parse(contratoDto.getFecha(), DATE_TIME_FORMATTER),contratoDto.getPrecio() );

        return contrato;
    }
}
