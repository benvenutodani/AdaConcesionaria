package org.concesionaria.concesionaria.service;


import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.entity.Marca;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.MarcaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final AutoService autoService;

    public MarcaService(MarcaRepository marcaRepository,
                        AutoService autoService) {
        this.marcaRepository = marcaRepository;
        this.autoService = autoService;
    }

    //crear una marca/
    public MarcaDTO create(MarcaDTO marcaDTO) {
        Marca marca = mapToEntity(marcaDTO);
        CheckForExistingMarca(marca.getId());

        marca = marcaRepository.save(marca);

        marcaDTO.setId(marca.getId());

        return marcaDTO;
    }

    //mostrar todos las marcas creadas/
    public List<MarcaDTO> retrieveAll(){

        List<Marca> marcas = marcaRepository.findAll();

        return marcas.stream(). map(marca -> mapToDTO(marca))
                .collect(Collectors.toList());
    }

    //mostrar una marca por id/
    public MarcaDTO retrieveById(Integer id){

        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isEmpty()){
            throw new ResourceNotFoundException();
        }

        return mapToDTO(marca.get());
    }

    //eliminar un registro de la tabla marca por id/
    public void delete(Integer marcaId) {

        try {
            marcaRepository.deleteById(marcaId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }

    }

    //reemplaza todos los campos de un registro de marca/
    public void replace(Integer marcaId, MarcaDTO marcaDto) {

        Optional<Marca> marca = marcaRepository.findById(marcaId);

        if (!marca.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Marca marcaToReplace = marca.get();

        marcaToReplace.setNombre(marcaDto.getNombre());
        marcaToReplace.setNacionalidad(marcaDto.getNacionalidad());

        marcaRepository.save(marcaToReplace);

        marcaDto.setId(marcaToReplace.getId());
    }

    //modifica uno o varios campos de un registro de marca/
    public void modify(Integer marcaId, Map<String, Object> fieldsToModify) {
        Optional<Marca> marca = marcaRepository.findById(marcaId);

        if (!marca.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Marca marcaToModify = marca.get();

        fieldsToModify.forEach((key, value) -> marcaToModify.modifyAttributeValue(key, value));

        marcaRepository.save(marcaToModify);
    }

    //----------------------------------------------------------------------------------------------------------------
    private void CheckForExistingMarca(Integer id) {
        if (marcaRepository.existsById(id)) {
            throw new ExistingResourceException();
        }
    }

    private Marca mapToEntity(MarcaDTO marcaDTO) {
        Marca marca = new Marca (marcaDTO.getNombre(),
                        marcaDTO.getNacionalidad());
        marcaDTO.setId(marca.getId());
        return marca;
    }

    private MarcaDTO mapToDTO(Marca marca) {
        MarcaDTO marcaDTO=new MarcaDTO(marca.getNombre(), marca.getNacionalidad());

        marcaDTO.setId(marca.getId());

        return marcaDTO;
    }



}