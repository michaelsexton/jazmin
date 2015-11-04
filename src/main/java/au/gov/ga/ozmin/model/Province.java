package au.gov.ga.ozmin.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;


@Entity
@DiscriminatorValue("PROVINCE")
@SecondaryTable(schema="PROVS",name = "PROVINCES", pkJoinColumns = @PrimaryKeyJoinColumn(name="ENO"))
public class Province extends SpatialEntity {
	
	@AttributeOverride(name="id", column = @Column(name = "PROVNO"))
	Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	
}
