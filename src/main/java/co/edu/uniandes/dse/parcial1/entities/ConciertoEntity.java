package co.edu.uniandes.dse.parcial1.entities;

import java.util.Date;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import uk.co.jemos.podam.common.PodamExclude;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ConciertoEntity extends BaseEntity {

    private String nombre;
    private Long presupuesto;

    @PodamExclude
	@OneToOne
    private ArtistaEntity artista;

	private String name;
	private String description;

    @Temporal(TemporalType.DATE)
	private Date conciertoDate;
    LocalDateTime.now();
    
    @PodamExclude
    @ManyToOne
    private AforoEntity organization;
    private int aforo;
    @OneToOne
    EstadioEntity estadio;

}
