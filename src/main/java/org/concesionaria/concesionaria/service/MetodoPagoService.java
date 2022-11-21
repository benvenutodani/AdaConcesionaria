package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.DTO.MetodoPagoDTO;
import org.concesionaria.concesionaria.entity.MetodoPago;
import org.concesionaria.concesionaria.repository.MetodoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetodoPagoService {

    private final  MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public MetodoPagoDTO create (MetodoPagoDTO metodoPagoDTO){
        MetodoPago metodoPago = mapToEntity(metodoPagoDTO);
        metodoPagoRepository.save(metodoPago);
        return metodoPagoDTO;
    }
    public List<MetodoPagoDTO> retrieveAll() {

        List<MetodoPago> metodosPago= metodoPagoRepository.findAll();

        return metodosPago.stream().map(metodoPago -> mapToDTO(metodoPago)).collect(Collectors.toList());


    }

  

    private MetodoPagoDTO mapToDTO(MetodoPago metodoPago) {
        MetodoPagoDTO metodoPagoDTO = new MetodoPagoDTO(metodoPago.getTipo(), metodoPago.getDescripcion());
        return  metodoPagoDTO;
    }

    private MetodoPago mapToEntity(MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = new MetodoPago(metodoPagoDTO.getId(), metodoPagoDTO.getTipo(),metodoPagoDTO.getDescripcion());
        return metodoPago;
    }
}
