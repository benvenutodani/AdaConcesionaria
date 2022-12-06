package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.dto.VendedorDTO;

import org.concesionaria.concesionaria.entity.Cliente;
import org.concesionaria.concesionaria.entity.Vendedor;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.VendedorRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class VendedorService {
    private final VendedorRepository vendedorRepository;
    private final String MENSAJE= "EL vendedor no existe";
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    /*Método para agregar un nuevo vendedor a la base de datos*/
    public VendedorDTO create(VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapToEntity(vendedorDTO);
        checkForExistingVendedor(vendedor.getCuil());
        vendedor = vendedorRepository.save(vendedor);
        return vendedorDTO;
    }

    /*Método mostrar el listado de los vendedores en la base de datos*/
    public List<VendedorDTO> retrieveAll() {

        List<Vendedor> vendedores = vendedorRepository.findAll();

        return vendedores.stream()
                .map(vendedor -> mapToDTO(vendedor))
                .collect(Collectors.toList());
    }

    /*Método para mostrar un vendedor segun el cuil*/
    public VendedorDTO retrieveById(String vendedorId) {

        Optional<Vendedor> vendedor = vendedorRepository.findById(vendedorId);
        if (!vendedor.isPresent()) {
            throw new ResourceNotFoundException(MENSAJE);
        }
        return mapToDTO(vendedor.get());

    }

    /*delete vendedor por id*/
    public void delete(String vendedorId) {
        try {
            vendedorRepository.deleteById(vendedorId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(MENSAJE);
        }
    }

    /*reemplazar todos los campos de un registro de vendedor*/
    public void replace(String vendedorId, VendedorDTO vendedorDto) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(vendedorId);
        if (!vendedor.isPresent()) {
            throw new ResourceNotFoundException(MENSAJE);
        }
        Vendedor vendedorToReplace = vendedor.get();
        //vendedorToReplace.setCuil(vendedorDto.getCuil());
        vendedorToReplace.setNombre(vendedorDto.getNombre());
        vendedorToReplace.setApellido(vendedorDto.getApellido());
        vendedorToReplace.setNumeroIdentidad(vendedorDto.getNumeroIdentidad());
        vendedorToReplace.setTipoIdentidad(vendedorDto.getTipoIdentidad());
        vendedorToReplace.setTelefono(vendedorDto.getTelefono());
        vendedorToReplace.setEmail(vendedorDto.getEmail());
        vendedorRepository.save(vendedorToReplace);
    }

    /*modificar un  o varios campos de un vendedor*/
    public void modify(String vendedorId, Map<String, Object> fieldsToModify) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(vendedorId);
        if (!vendedor.isPresent()) {
            throw new ResourceNotFoundException(MENSAJE);
        }
        Vendedor vendedorToModify = vendedor.get();

        fieldsToModify.forEach((key, value) -> vendedorToModify.modifyAttributeValue(key, value));
        vendedorRepository.save(vendedorToModify);
    }

    //-----------------------------------------------------------------------------------------------------------------------

    private void checkForExistingVendedor(String vendedorId) {
        if (vendedorRepository.existsById(vendedorId)) {
            throw new ExistingResourceException();
        }
    }

    private Vendedor mapToEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor(vendedorDTO.getCuil(), vendedorDTO.getNombre(), vendedorDTO.getApellido(),
                vendedorDTO.getNumeroIdentidad(), vendedorDTO.getTipoIdentidad(), vendedorDTO.getTelefono(),
                vendedorDTO.getEmail());
        return vendedor;
    }

    private VendedorDTO mapToDTO(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO(vendedor.getCuil(), vendedor.getNombre(), vendedor.getApellido(),
                vendedor.getNumeroIdentidad(), vendedor.getTipoIdentidad(), vendedor.getTelefono(),
                vendedor.getEmail());
        return vendedorDTO;
    }


}
