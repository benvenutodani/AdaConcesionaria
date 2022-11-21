package org.concesionaria.concesionaria.service;


import org.concesionaria.concesionaria.dto.MarcaDTO;
import org.concesionaria.concesionaria.entity.Marca;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
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

    public MarcaDTO create(MarcaDTO marcaDTO) {
        Marca marca = mapToEntity(marcaDTO);
        CheckForExistingMarca(marca.getId());
        marca = marcaRepository.save(marca);
        if(!CollectionUtils.isEmpty(marcaDTO.getAutoDTOS()));

        return marcaDTO;
    }
    private Marca mapToEntity(MarcaDTO marcaDTO) {
        Marca marca = new Marca (marcaDTO.getId(), marcaDTO.getNombre(),
                marcaDTO.getNacionalidad());

        return marca;
    }

    private void CheckForExistingMarca(Integer id) {
        if (marcaRepository.existsById(id)) {
            throw new ExistingResourceException();
        }
    }

    public List<MarcaDTO> retrieveAll(){
        List<Marca> marcas = marcaRepository.findAll();
        return marcas.stream(). map(marca -> mapToDTO(marca))
                .collect(Collectors.toList());
    }

    private MarcaDTO mapToDTO(Marca marca) {
        MarcaDTO marcaDTO=new MarcaDTO(marca.getId(), marca.getNombre(),
                marca.getNacionalidad(),autoService.mapToDTOS(marca.getAutos()));
        return marcaDTO;
    }

    public MarcaDTO retrieveById(Integer id){
        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent()){
            throw new ResourceNotFoundException();
        }
        return mapToDTO(marca.get());
    }
}