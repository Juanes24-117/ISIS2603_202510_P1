package co.edu.uniandes.dse.parcial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class EstadioEntity extends BaseEntity {

    private String nombre;
    private Long precioAlquiler;

@PodamExclude
	@OneToOne
    private EstadioEntity estadio;
    private String nombre_ciudad;
	private String description;

    @PodamExclude
    @ManyToOne
    private AforoEstadoEntity organization;
    private int aforo_estadio;

    @ManyToOne
    ConciertoEntity concierto;
}
