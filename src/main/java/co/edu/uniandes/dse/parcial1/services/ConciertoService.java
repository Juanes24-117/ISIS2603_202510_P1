package co.edu.uniandes.dse.parcial1.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoService {

    @Autowired
	private ConciertoRepository conciertoRepository;

	@Autowired
	private PresupuestoRepository presupuestoRepository;

    @Transactional
    public ConciertoEntity createConcierto(ConciertoEntity conciertoEntity) throws IllegalOperationException {
		log.info("Inicia proceso de creación del concierto");

		if (!conciertoRepository.findByFechaAndHora(conciertoEntity.getFecha(), conciertoEntity.getHora()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un test drive en la misma fecha y hora");
		}

		if (conciertoEntity.getDuracion() <= 0) {
			throw new IllegalOperationException("La duración del concierto debe ser un valor positivo");
		}

		log.info("Termina proceso de creación del concierto");
		return conciertoRepository.save(conciertoEntity);
	}

    @Transactional
    public ConciertoEntity capacidadminima(ConciertoEntity conciertoEntity) throws IllegalOperationException{
        if (conciertoRepository.count() < 10){
            throw new IllegalOperationException("La capacidad minima debe ser mayor o igual a 10");
        }
    }

    @Transactional
    public ConciertoEntity presupuesto(ConciertoEntity conciertoEntity) throws IllegalOperationException{
        if (presupuestoRepository.count() <= 1000){
            throw new IllegalOperationException("El presupuesto del concierto debe ser mayor a 1000$");
        }
    }
}
