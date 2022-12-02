package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.AutoDTO;
import org.concesionaria.concesionaria.entity.Auto;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.AutoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoService {
    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public AutoDTO create(AutoDTO autoDto) {
        Auto auto = mapToEntity(autoDto);
        checkForExistingAuto(auto.getNumeroChasis());
        auto = autoRepository.save(auto);
        return autoDto;
    }

    //get todos los registro/
    public List<AutoDTO> retrieveAll() {
        List<Auto> autos = autoRepository.findAll();
        return autos.stream()
                .map(auto -> mapToDto(auto))
                .collect(Collectors.toList());
    }


    //get by id/
    public AutoDTO retrieveById(String autoId) throws ResourceNotFoundException {
        Optional<Auto> auto = autoRepository.findById(autoId);
        if (auto.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return mapToDto(auto.get());
    }


    //delete by id/
    public void delete(String autoId) {
        try {
            autoRepository.deleteById(autoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }


    //reemplazar todos los datos de un auto/
    public void replace(String autoId, AutoDTO autoDto) {
        Optional<Auto> auto = autoRepository.findById(autoId);
        if (auto.isPresent()) {
            throw new ResourceNotFoundException();
        }
        Auto autoToReplace = auto.get();
        autoToReplace.setNumeroChasis(autoDto.getNumeroChasis());
        autoToReplace.setAnioModelo(autoDto.getAnioModelo());
        autoToReplace.setColor(autoDto.getColor());
        autoToReplace.setMarcaId(autoDto.getMarcaId());
        autoToReplace.setPrecio(autoDto.getPrecio());
        autoToReplace.setModelo(autoDto.getModelo());
        autoRepository.save(autoToReplace);
    }


    //modificar campos en un registro/
    public void modify(String autoId, Map<String, Object> fieldsToModify) {
        Optional<Auto> auto = autoRepository.findById(autoId);
        if (auto.isPresent()) {
            throw new ResourceNotFoundException();
        }
        Auto autoToModify = auto.get();
        fieldsToModify.forEach((key, value) -> autoToModify.modifyAttributeValue(key, value));
        autoRepository.save(autoToModify);
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private void checkForExistingAuto(String autoId) {
        if (autoRepository.existsById(autoId)) {
            throw new ExistingResourceException();
        }
    }


    private AutoDTO mapToDto(Auto auto) {
        AutoDTO autoDTO = new AutoDTO(auto.getNumeroChasis(), auto.getModelo(), auto.getMarcaId(),
                auto.getAnioModelo(), auto.getColor(), auto.getPrecio());
        autoDTO.setNumeroChasis(auto.getNumeroChasis());
        return autoDTO;
    }


    private Auto mapToEntity(AutoDTO autoDTO) {
        Auto auto = new Auto(autoDTO.getNumeroChasis(), autoDTO.getModelo(),
                autoDTO.getAnioModelo(), autoDTO.getColor(),
                autoDTO.getPrecio(), autoDTO.getMarcaId());
        return auto;
    }

}
