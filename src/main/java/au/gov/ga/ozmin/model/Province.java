package au.gov.ga.ozmin.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DiscriminatorValue("PROVINCE")
@SecondaryTable(schema="PROVS",name = "PROVINCES", pkJoinColumns = @PrimaryKeyJoinColumn(name="ENO"))
public class Province extends SpatialEntity {
	
	// TODO: Investigate Attribute override
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "PROVS", name = "PROVDEPOS", joinColumns = {
			@JoinColumn(name = "ENO", referencedColumnName = "ENO") }, inverseJoinColumns = {
					@JoinColumn(name = "DEPOSNO", referencedColumnName = "ENO") })
	private Set<MineralDeposit> mineralDeposits;
}
