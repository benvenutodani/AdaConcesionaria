package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.entity.Auto;
import org.concesionaria.concesionaria.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoService {

    private static AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public AutoDTO create(AutoDTO autoDTO){
        Auto auto = mapToEntity(autoDTO);
        autoRepository.save(auto);
        return autoDTO;
    }

    public List<AutoDTO> retrieveAll(){
        List<Auto> autos= autoRepository.findAll();
        return autos.stream().map(auto -> mapToDto(auto)).collect(Collectors.toList());
    }

    private AutoDTO mapToDto(Auto auto) {
        AutoDTO autoDTO = new AutoDTO(auto.getNumeroChasis(),auto.getModelo(),auto.getMarcaId(),
                auto.getAnioModelo(),auto.getColor());
        return autoDTO;
    }

    private Auto mapToEntity(AutoDTO autoDTO) {
        Auto auto = new Auto(autoDTO.getNumeroChasis(),autoDTO.getModelo(),autoDTO.getAnioModelo(),
                autoDTO.getColor(),autoDTO.getMarcaId());
        return auto;
    }
}

