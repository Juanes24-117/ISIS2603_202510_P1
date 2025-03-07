package co.edu.uniandes.dse.parcial1.services;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstadioService {
        @Autowired
	private EstadioRepository estadioRepository;
        @Autowired
	private NombreRepository nombreRepository;


    @Transactional
    public EstadioEntity nombre_ciudad(EstadioEntity estadioEntity) throws IllegalOperationException{
        if (nombreRepository.count() < 3){
            throw new IllegalOperationException("el numero minimo de letras debe ser 3");
        }
		
    }}
