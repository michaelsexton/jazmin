package au.gov.ga.ozmin.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema="MGD",name="COMPANIES")
public class Company {

	@Id
	@Column(name="COMPANYID")
	private Long id;
	
	@Column(name="COMPANY_NAME")
	private String name;
	
	@Column(name="URL")
	private String url;

	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "MGD", name = "OWNERSHIP", joinColumns = { @JoinColumn(name = "COMPANYID") }, inverseJoinColumns = {
			@JoinColumn(name = "ENO") })
	private Set<MineralDeposit> mineralDeposits;
	
	public Long getId() {
		return id;
	}

	public Set<MineralDeposit> getMineralDeposits() {
		return mineralDeposits;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMineralDeposits(Set<MineralDeposit> mineralDeposits) {
		this.mineralDeposits = mineralDeposits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
