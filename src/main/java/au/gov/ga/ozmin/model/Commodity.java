package au.gov.ga.ozmin.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "MGD", name = "COMMODTYPES")
public class Commodity {

	@Id
	@Column(name = "COMMODID")
	private String id;

	@Column(name = "commodname")
	private String name;

	@Column(name = "convertedcommod")
	private String convertedCommodity;

	@Column(name = "conversionfactor")
	private double conversionFactor;

	@ManyToOne
	@JoinColumn(name = "displayunit")
	private Unit mineralUnit;

	@ManyToOne
	@JoinColumn(name = "oreunit")
	private Unit oreUnit;

	@ManyToOne
	@JoinColumn(name = "gradeunit")
	private Unit gradeUnit;

	@ManyToOne
	@JoinColumn(name = "priceunit")
	private Unit priceUnit;

	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "MGD", name = "COMMODS", joinColumns = {
			@JoinColumn(name = "COMMODID") }, inverseJoinColumns = { @JoinColumn(name = "ENO") })
	private Set<MineralDeposit> mineralDeposits;

	// @OneToMany(mappedBy="id.commodity")
	// List<MineralDepositCommodityOrder> mineralDepositCommodityOrder;

	protected Commodity() {
	}

	public Commodity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getConvertedCommodity() {
		return convertedCommodity;
	}

	public void setConvertedCommodity(String convertedCommodity) {
		this.convertedCommodity = convertedCommodity;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public Unit getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Unit priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Unit getMineralUnit() {
		return mineralUnit;
	}

	public void setMineralUnit(Unit mineralUnit) {
		this.mineralUnit = mineralUnit;
	}

	public Unit getOreUnit() {
		return oreUnit;
	}

	public void setOreUnit(Unit oreUnit) {
		this.oreUnit = oreUnit;
	}

	public Unit getGradeUnit() {
		return gradeUnit;
	}

	public void setGradeUnit(Unit gradeUnit) {
		this.gradeUnit = gradeUnit;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name;
	}
}
