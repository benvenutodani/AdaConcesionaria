package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.dto.VendedorDTO;

import org.concesionaria.concesionaria.entity.Cliente;
import org.concesionaria.concesionaria.entity.Vendedor;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class VendedorService {
    private VendedorRepository vendedorRepository;

    /*Método para agregar un nuevo vendedor a la base de datos*/
    public VendedorDTO create(VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapToEntity(vendedorDTO);
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
        if (vendedor.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(vendedor.get());

    }


    private Vendedor mapToEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor(vendedorDTO.getCuil(), vendedorDTO.getNombre(), vendedorDTO.getApellido(), vendedorDTO.getNumeroIdentidad(),
                vendedorDTO.getTipoIdentidad(), vendedorDTO.getTelefono(), vendedorDTO.getEmail());
        return vendedor;
    }

    private VendedorDTO mapToDTO(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO(vendedor.getCuil(), vendedor.getNombre(), vendedor.getApellido(),
                vendedor.getNumeroIdentidad(), vendedor.getTipoIdentidad(), vendedor.getTelefono(), vendedor.getEmail());
        return vendedorDTO;
    }

}

