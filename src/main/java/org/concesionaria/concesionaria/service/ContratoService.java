package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.ContratoDTO;
import org.concesionaria.concesionaria.entity.*;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final ContratoRepository contratoRepository;
    public final ClienteRepository clienteRepository;
    public final VendedorRepository vendedorRepository;
    public final MetodoPagoRepository metodoPagoRepository;
    public final AutoRepository autoRepository;


    public ContratoService(ContratoRepository contratoRepository, ClienteRepository clienteRepository,
                           VendedorRepository vendedorRepository, MetodoPagoRepository metodoPagoRepository, AutoRepository autoRepository) {
        this.contratoRepository = contratoRepository;
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
        this.metodoPagoRepository = metodoPagoRepository;
        this.autoRepository = autoRepository;
    }

    /*creacion de un contrato*/
    public ContratoDTO create(ContratoDTO contratoDTO)
    {
        Optional<Cliente> cliente = clienteRepository.findById(contratoDTO.getCliente());
        Optional<Vendedor> vendedor = vendedorRepository.findById(contratoDTO.getVendedor());
        Optional<Auto> auto= autoRepository.findById(contratoDTO.getAuto());
        Optional<MetodoPago> metodoPago= metodoPagoRepository.findById(contratoDTO.getMetodoPago());

        if (!cliente.isPresent()|| !vendedor.isPresent()||!auto.isPresent()|| !metodoPago.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Contrato contrato = mapToEntity(contratoDTO,cliente.get(),auto.get(),vendedor.get(),metodoPago.get());

        contrato.setPrecio(calcularPrecioFinal(contrato));

        contrato = contratoRepository.save(contrato);

        contratoDTO.setId(contrato.getId());
        contratoDTO.setPrecio(contrato.getPrecio());

        return contratoDTO;
    }



    /*mostrar todos los contrartos*/
    public List<ContratoDTO> retrieveAll() {

        List<Contrato> contratos = contratoRepository.findAll();

        return contratos.stream()
                .map(cliente -> mapToDTO(cliente))
                .collect(Collectors.toList());
    }

    /*mostrar un contrato por id */
    public ContratoDTO retrieveById(Integer contratoId) {
        Optional<Contrato> contrato = contratoRepository.findById(contratoId);
        if (contrato.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(contrato.get());
    }

    /*borrar un contrato por id*/
    public void delete(Integer contratoId) {
        try {
            contratoRepository.deleteById(contratoId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void replace(Integer contratoId, ContratoDTO contratoDto) {

        Optional<Contrato> contrato = contratoRepository.findById(contratoId);
        if (!contrato.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Optional<Cliente> cliente = clienteRepository.findById(contratoDto.getCliente());

        Optional<Vendedor> vendedor = vendedorRepository.findById(contratoDto.getVendedor());

        Optional<Auto> auto = autoRepository.findById(contratoDto.getAuto());

        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(contratoDto.getMetodoPago());

        if (!cliente.isPresent() || !vendedor.isPresent() || !auto.isPresent() || !metodoPago.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Contrato contratoToReplace = contrato.get();

        contratoToReplace.setCliente(cliente.get());
        contratoToReplace.setAuto(auto.get());
        contratoToReplace.setVendedor(vendedor.get());
        contratoToReplace.setFecha(LocalDate.parse(contratoDto.getFecha(), DATE_TIME_FORMATTER));
        contratoToReplace.setMetodoPago(metodoPago.get());
        contratoToReplace.setPrecio(contratoDto.getPrecio());
        contratoToReplace.setCuotas(contratoDto.getCuotas());
        contratoToReplace.setPrecio(calcularPrecioFinal(contratoToReplace));

        contratoDto.setId(contratoToReplace.getId());
        contratoDto.setPrecio(contratoToReplace.getPrecio());

    }

    public void modify(Integer contratoId, Map<String, Object> fieldsToModify) {

        Optional<Contrato> contrato = contratoRepository.findById(contratoId);
        if (!contrato.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Contrato contratoToModify = contrato.get();
        fieldsToModify.forEach((key, value) -> contratoToModify.modifyAttributeValue(key, value));

        contratoRepository.save(contratoToModify);
    }




    //----------------------------------------------------------------------------------------------------------------
    /*cambiar los get*/
    private ContratoDTO mapToDTO(Contrato contrato) {

        ContratoDTO contratoDTO = new ContratoDTO(contrato.getCliente().getId(),
                contrato.getVendedor().getNumeroIdentidad(),
                contrato.getAuto().getNumeroChasis(), contrato.getMetodoPago().getId(),
                contrato.getFecha().toString(),contrato.getCuotas());

        contratoDTO.setId(contrato.getId());
        contratoDTO.setPrecio(contrato.getPrecio());
        return  contratoDTO;

    }
    /*cambiar los get*/
    private static Contrato mapToEntity(ContratoDTO contratoDto, Cliente cliente,
                                        Auto auto, Vendedor vendedor, MetodoPago metodoPago) {

        Contrato contrato= new Contrato(cliente, vendedor,auto,
                metodoPago,LocalDate.parse(contratoDto.getFecha(), DATE_TIME_FORMATTER),
                contratoDto.getCuotas());


        return contrato;
    }

    // LocalDate.parse(contratoDto.getFecha(), DATE_TIME_FORMATTER)
    public Double calcularPrecioFinal(Contrato contrato) {

        Double precioFinal;

        Auto auto= contrato.getAuto();

        if(contrato.getMetodoPago().getId() == 1){

            precioFinal= auto.getPrecio() * 0.05;

        }else if(contrato.getMetodoPago().getId() == 2 || contrato.getMetodoPago().getId()==3){

            precioFinal= auto.getPrecio()/0.10;

        }else{

            precioFinal= auto.getPrecio()*0.15;

        }

        return precioFinal;
    }


}