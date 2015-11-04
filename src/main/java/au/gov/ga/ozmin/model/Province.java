package au.gov.ga.ozmin.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;


@Entity
@DiscriminatorValue("PROVINCE")
@SecondaryTable(schema="PROVS",name = "PROVINCES", pkJoinColumns = @PrimaryKeyJoinColumn(name="ENO"))
public class Province extends SpatialEntity {
	
	// TODO: Investigate Attribute override
	
}
