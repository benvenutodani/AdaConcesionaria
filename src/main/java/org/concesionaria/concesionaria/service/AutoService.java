package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.entity.Auto;
import org.concesionaria.concesionaria.entity.Marca;
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

    public void create(List<AutoDTO> autoDTOS, Marca marca){
        List<Auto>autos= autoDTOS.stream().map(autoDTO -> mapToEntity(autoDTO, marca))
                .collect(Collectors.toList());
        autoRepository.saveAll(autos);
    }
   /* public AutoDTO create(AutoDTO autoDTO){
        Auto auto = mapToEntity(autoDTO);
        autoRepository.save(auto);
        return autoDTO;
    } */

    /*public List<AutoDTO> retrieveAll(){
        List<Auto> autos= autoRepository.findAll();
        return autos.stream().map(auto -> mapToDto(auto)).collect(Collectors.toList());
    }*/

    public List<AutoDTO> autoDTOS (List<Auto> autos){
        return autos.stream().map(auto -> mapToDto(auto)).
                collect(Collectors.toList());
    }

    private AutoDTO mapToDto(Auto auto) {
        AutoDTO autoDTO = new AutoDTO(auto.getModelo(),auto.getAnioModelo(),auto.getColor());
        autoDTO.setNumeroChasis(auto.getNumeroChasis());
        return autoDTO;
    }

    private Auto mapToEntity(AutoDTO autoDTO, Marca marca) {
        Auto auto = new Auto(autoDTO.getModelo(),autoDTO.getAnioModelo(),
                autoDTO.getColor(), marca);
        return auto;
    }

    public List<AutoDTO> mapToDTOS(List<Auto> autos) {
       return autos.stream().map(auto -> mapToDto(auto)).
                collect(Collectors.toList());
    }
}

