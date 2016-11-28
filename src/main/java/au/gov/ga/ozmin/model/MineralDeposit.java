package au.gov.ga.ozmin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERAL DEPOSIT")
//@SecondaryTable(schema = "MGD", name = "DEPOSITS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ENO") )
public class MineralDeposit extends SpatialEntity {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralDeposit")
	@JsonIgnore
	private Set<MineralisedZone> mineralisedZones;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "PARENT")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private MineralProject mineralProject;
	
	/*@Column(name = "OPERATING_STATUS", table = "DEPOSITS")
	private String operatingStatus;

	@Column(name = "STATE", table = "DEPOSITS")
	private String state;

	@Column(name = "SYNONYMS", table = "DEPOSITS")
	private String synonyms;*/

	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "PROVS", name = "PROVDEPOS", joinColumns = {
			@JoinColumn(name = "DEPOSNO", referencedColumnName = "ENO") }, inverseJoinColumns = {
					@JoinColumn(name = "ENO", referencedColumnName = "ENO") })
	private Set<Province> provinces;

	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "MGD", name = "COMMODS", joinColumns = { @JoinColumn(name = "ENO") }, inverseJoinColumns = {
			@JoinColumn(name = "COMMODID") })
	private Set<Commodity> commodities;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "MGD", name = "OWNERSHIP", joinColumns = { @JoinColumn(name = "ENO") }, inverseJoinColumns = {
			@JoinColumn(name = "COMPANYID") })
	private Set<Company> companies;
	
	
	

	/*public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}*/

	public Set<MineralisedZone> getMineralisedZones() {
		return mineralisedZones;
	}

	public void setMineralisedZones(Set<MineralisedZone> mineralisedZones) {
		this.mineralisedZones = mineralisedZones;
	}

	/*public String getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(String operatingStatus) {
		this.operatingStatus = operatingStatus;
	}
*/
	public Set<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}
/*
	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}*/

}
