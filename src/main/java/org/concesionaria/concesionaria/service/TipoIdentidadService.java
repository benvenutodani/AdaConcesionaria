package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.DTO.MetodoPagoDTO;
import org.concesionaria.concesionaria.DTO.TipoIdentidadDTO;
import org.concesionaria.concesionaria.entity.MetodoPago;
import org.concesionaria.concesionaria.entity.TipoIdentidad;
import org.concesionaria.concesionaria.repository.TipoIdentidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoIdentidadService {

    private final TipoIdentidadRepository tipoIdentidadRepository;

    public TipoIdentidadService(TipoIdentidadRepository tipoIdentidadRepository) {
        this.tipoIdentidadRepository = tipoIdentidadRepository;
    }

    public TipoIdentidadDTO create(TipoIdentidadDTO tipoIdentidadDTO){
        TipoIdentidad tipoIdentidad = mapToEntity(tipoIdentidadDTO);
        tipoIdentidadRepository.save(tipoIdentidad);
        return tipoIdentidadDTO;
    }

    public List<TipoIdentidadDTO> retrieveAll(){
        List<TipoIdentidad> tiposIdentidad = tipoIdentidadRepository.findAll();

        return  tiposIdentidad.stream().map(tipoIdentidad -> mapToDto(tipoIdentidad)).collect(Collectors.toList());
    }

    private TipoIdentidadDTO mapToDto(TipoIdentidad tipoIdentidad) {
        TipoIdentidadDTO tipoIdentidadDTO = new TipoIdentidadDTO(tipoIdentidad.getTipo());
        return  tipoIdentidadDTO;

    }

    private TipoIdentidad mapToEntity(TipoIdentidadDTO tipoIdentidadDTO) {
        TipoIdentidad tipoIdentidad = new TipoIdentidad(tipoIdentidadDTO.getId(), tipoIdentidadDTO.getTipo());
        return tipoIdentidad;
    }
}
