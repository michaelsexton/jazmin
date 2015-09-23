package au.gov.ga.ozmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="GEOREF",name="REFERENCES")
public class Reference {
	
	@Id
	@Column(name= "REFID")
	private Long id;


}
