package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.dto.ClienteDTO;
import org.concesionaria.concesionaria.entity.Cliente;
import org.concesionaria.concesionaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /*Método que recibe un cliente y lo guarda en la base de datos*/
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = mapToEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);

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


    /*Método convierte un clienteDTO en un cliente Entity*/
    private Cliente mapToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getApellido(), clienteDTO.getNumeroIdentidad(),
                clienteDTO.getTipoIdentidad(), clienteDTO.getTelefono(), clienteDTO.getEmail());
        return cliente;
    }

    /*Método convierte un cliente de la base de dato (Entidad) a un cliente DTO*/
    private ClienteDTO mapToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getNombre(), cliente.getApellido(),
                cliente.getNumeroIdentidad(), cliente.getTipoIdentidad(), cliente.getTelefono(), cliente.getEmail());
        return clienteDTO;
    }


}
