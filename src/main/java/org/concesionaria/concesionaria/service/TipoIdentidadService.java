package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.TipoIdentidadDTO;
import org.concesionaria.concesionaria.entity.Marca;
import org.concesionaria.concesionaria.entity.TipoIdentidad;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.TipoIdentidadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoIdentidadService {

    private final TipoIdentidadRepository tipoIdentidadRepository;

    public TipoIdentidadService(TipoIdentidadRepository tipoIdentidadRepository) {
        this.tipoIdentidadRepository = tipoIdentidadRepository;
    }

    /*crear un tipo de indentidad*/
    public TipoIdentidadDTO create(TipoIdentidadDTO tipoIdentidadDTO) {
        TipoIdentidad tipoIdentidad = mapToEntity(tipoIdentidadDTO);
        CheckForExistingTipoIdentidad(tipoIdentidad.getId());
        tipoIdentidadRepository.save(tipoIdentidad);
        return tipoIdentidadDTO;
    }

    /*mostrar todos los tipo de identidad*/
    public List<TipoIdentidadDTO> retrieveAll() {
        List<TipoIdentidad> tiposIdentidad = tipoIdentidadRepository.findAll();

        return tiposIdentidad.stream().map(tipoIdentidad -> mapToDto(tipoIdentidad)).collect(Collectors.toList());
    }

    /*mostrar un registro de tipo de identidad por id*/
    public TipoIdentidadDTO retrieveById(Integer tipoIdentidadId) {
        Optional<TipoIdentidad> tipoIdentidad = tipoIdentidadRepository.findById(tipoIdentidadId);
        if (tipoIdentidad.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return mapToDto(tipoIdentidad.get());
    }

    /*borrar un registro por id*/
    public void delete(Integer tipoIdentidadId) {
        try {
            tipoIdentidadRepository.deleteById(tipoIdentidadId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    /*modificar tipo de identidad*/
    public void replace(Integer tipoIdentidadId, TipoIdentidadDTO tipoIdentidadDto) {
        Optional<TipoIdentidad> tipoIdentidad = tipoIdentidadRepository.findById(tipoIdentidadId);

        if (tipoIdentidad.isPresent()) {
            throw new ResourceNotFoundException();
        }
        TipoIdentidad tipoIdentidadToReplace = tipoIdentidad.get();
        tipoIdentidadToReplace.setTipo(tipoIdentidadDto.getTipo());
        tipoIdentidadRepository.save(tipoIdentidadToReplace);
    }

    public void modify(Integer TipoIdentidadId, Map<Integer, Object> fieldsToModify) {
        Optional<TipoIdentidad> tipoIdentidad = tipoIdentidadRepository.findById(Integer.valueOf(TipoIdentidadId));

        if (tipoIdentidad.isPresent()) {
            throw new ResourceNotFoundException();
        }

        TipoIdentidad tipoIdentidadToModify = tipoIdentidad.get();

        fieldsToModify.forEach((key, value) -> tipoIdentidadToModify.modifyAttributeValue(String.valueOf(key), value));
        tipoIdentidadRepository.save(tipoIdentidadToModify);
    }


    //-------------------------------------------------------------------------------------------------------------------

    private void CheckForExistingTipoIdentidad(Integer id) {
        if (tipoIdentidadRepository.existsById(id)) {
            throw new ExistingResourceException();
        }
    }

    private TipoIdentidadDTO mapToDto(TipoIdentidad tipoIdentidad) {
        TipoIdentidadDTO tipoIdentidadDTO = new TipoIdentidadDTO(tipoIdentidad.getTipo());
        return tipoIdentidadDTO;

    }

    private TipoIdentidad mapToEntity(TipoIdentidadDTO tipoIdentidadDTO) {
        TipoIdentidad tipoIdentidad = new TipoIdentidad(tipoIdentidadDTO.getId(), tipoIdentidadDTO.getTipo());
        return tipoIdentidad;
    }


}