package org.concesionaria.concesionaria.service;

import org.concesionaria.concesionaria.dto.MetodoPagoDTO;
import org.concesionaria.concesionaria.entity.MetodoPago;
import org.concesionaria.concesionaria.exceptions.ExistingResourceException;
import org.concesionaria.concesionaria.exceptions.ResourceNotFoundException;
import org.concesionaria.concesionaria.repository.MetodoPagoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetodoPagoService {

    public MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    /*crear un metorodo de pago*/
    public MetodoPagoDTO create(MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = mapToEntity(metodoPagoDTO);
        CheckForExistingMetodoPago(metodoPago.getId());
        metodoPagoRepository.save(metodoPago);
        return metodoPagoDTO;
    }



    /*mostrar todos los metodos de pago*/
    public List<MetodoPagoDTO> retrieveAll() {

        List<MetodoPago> metodosPago = metodoPagoRepository.findAll();

        return metodosPago.stream().map(metodoPago -> mapToDTO(metodoPago)).collect(Collectors.toList());
    }

    /*mostrar un metodo de pago por id*/
    public MetodoPagoDTO retrieveById(Integer metodoPagoId) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(metodoPagoId);
        if (metodoPago.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return mapToDTO(metodoPago.get());

    }
    
    public void delete (Integer id){
        try {
            metodoPagoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

    public void replace(Integer id, MetodoPagoDTO metodoPagoDTO) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(Integer.valueOf(id));
        if (metodoPago.isPresent()) {
            throw new ResourceNotFoundException();
        }
        MetodoPago metodoPagoToReplace = metodoPago.get();
        metodoPagoToReplace.setDescripcion(metodoPagoDTO.getDescripcion());
        metodoPagoToReplace.setTipo(metodoPagoDTO.getTipo());
    }

    public void modify(Integer id, Map<Integer, Object> fieldsToModify) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(id);

        if (metodoPago.isPresent()) {
            throw new ResourceNotFoundException();
        }

        MetodoPago metodoPagoToModify = metodoPago.get();

        fieldsToModify.forEach((key, value) -> metodoPagoToModify.modifyAttributeValue(String.valueOf(key),value));
        //duda!!!/
        metodoPagoRepository.save(metodoPagoToModify);
    }

    //------------------------------------------------------------------------------------------------------------------------
        private void CheckForExistingMetodoPago(Integer id){

        if (metodoPagoRepository.existsById(id)) {
            throw new ExistingResourceException();
        }
    }

    private MetodoPagoDTO mapToDTO(MetodoPago metodoPago) {
        MetodoPagoDTO metodoPagoDTO = new MetodoPagoDTO(metodoPago.getTipo(), metodoPago.getDescripcion());
        return metodoPagoDTO;
    }

    private MetodoPago mapToEntity(MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = new MetodoPago(metodoPagoDTO.getId(), metodoPagoDTO.getTipo(), 
                metodoPagoDTO.getDescripcion());
        return metodoPago;
    }


   
}
