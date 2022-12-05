package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.entity.Cliente;
import org.concesionaria.concesionaria.repository.ClienteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /*Método que recibe un cliente y lo guarda en la base de datos*/
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = mapToEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        clienteDTO.setId(cliente.getId());

        return clienteDTO;
    }

    /*Método crea una lista con todos los clientes creados/guardados en la base de datos*/
    public List<ClienteDTO> retrieveAll() {

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(cliente -> mapToDTO(cliente))
                .collect(Collectors.toList());


    }

    /*Método para bucar un cliente desde la base de datos con el id del cliente*/
    public ClienteDTO retrieveById(Integer clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(cliente.get());
    }

    /* delete por id*/
    public void delete(Integer clienteId) {
        try {
            clienteRepository.deleteById(clienteId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }


    /*put reemplaza todos los campos de un registro de cliente*/
    public void replace(Integer clienteId, ClienteDTO clienteDto) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Cliente clienteToReplace = cliente.get();

        clienteToReplace.setNombre(clienteDto.getNombre());
        clienteToReplace.setApellido(clienteDto.getApellido());
        clienteToReplace.setNumeroIdentidad(clienteDto.getNumeroIdentidad());
        clienteToReplace.setTipoIdentidad(clienteDto.getTipoIdentidad());
        clienteToReplace.setTelefono(clienteDto.getTelefono());
        clienteToReplace.setEmail(clienteDto.getEmail());

        clienteRepository.save(clienteToReplace);

    }

    /*modifica algun o varios registros de un cliente*/
    public void modify(Integer clienteId, Map<String, Object> fieldsToModify) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Cliente clienteToModify = cliente.get();

        fieldsToModify.forEach((key, value) -> clienteToModify.modifyAttributeValue(key, value));/*duda!!!*/
        clienteRepository.save(clienteToModify);

    }

    //-----------------------------------------------------------------------------------------------------------------------------
    private void checkForExistingCliente(Integer clienteId) {
        if (clienteRepository.existsById(clienteId)) {
            throw new ExistingResourceException();
        }
    }



    /*Método convierte un clienteDTO en un cliente Entity*/
    private Cliente mapToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getApellido(), clienteDTO.getNumeroIdentidad(),
                clienteDTO.getTipoIdentidad(), clienteDTO.getTelefono(), clienteDTO.getEmail());
        clienteDTO.setId(cliente.getId());
        return cliente;
    }

    /*Método convierte un cliente de la base de dato (Entidad) a un cliente DTO*/
    private ClienteDTO mapToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getNombre(), cliente.getApellido(),
                cliente.getNumeroIdentidad(), cliente.getTipoIdentidad(), cliente.getTelefono(), cliente.getEmail());
        clienteDTO.setId(cliente.getId());
        return clienteDTO;
    }


}