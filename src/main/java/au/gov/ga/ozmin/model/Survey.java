package au.gov.ga.ozmin.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("SURVEY")
@SecondaryTable(schema="A", name="SURVEYS",pkJoinColumns=@PrimaryKeyJoinColumn(name="ENO"))
public class Survey extends SpatialEntity {

	// TODO: Investigate Attribute override
}
