package au.gov.ga.ozmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="MGD",name="RESOURCES")
public class MineralResource {

	@Id
	@Column(name="RESOURCENO") 
	private Long id;
	
	@Column(name="RECORDDATE")
	private Date recordDate;
	
	@ManyToOne
    @JoinColumn(name = "ENO")
    private MineralisedZone mineralisedZone;
}
