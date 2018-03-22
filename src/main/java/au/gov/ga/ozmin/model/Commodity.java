package au.gov.ga.ozmin.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.*;

import au.gov.ga.ozmin.resources.CommodityConvertor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "MGD", name = "COMMODTYPES")
public class Commodity {

	@Id
	@Column(name = "COMMODID")
	private String id;

	@Column(name = "commodname")
	private String name;

	@ManyToOne
	@JoinColumn(name = "convertedcommod")
	private Commodity convertedCommodity;

	@Column(name = "conversionfactor")
	private BigDecimal conversionFactor;

	@ManyToOne
	@JoinColumn(name = "displayunit")
	private MineralUnit mineralUnit;

	@ManyToOne
	@JoinColumn(name = "oreunit")
	private MineralUnit oreUnit;

	@ManyToOne
	@JoinColumn(name = "gradeunit")
	private MineralUnit gradeUnit;

	@ManyToOne
	@JoinColumn(name = "priceunit")
	private MineralUnit priceUnit;

	@ManyToMany
	@JsonIgnore
	@JoinTable(schema = "MGD", name = "COMMODS", joinColumns = {
			@JoinColumn(name = "COMMODID") }, inverseJoinColumns = { @JoinColumn(name = "ENO") })
	private Set<MineralDeposit> mineralDeposits;


	@Transient
    private CommodityConvertor commodityConvertor;

	@PostLoad
    private void mapConvertedCommodities(){
	    if (this.equals(convertedCommodity)){
            this.commodityConvertor = new CommodityConvertor(id, name, mineralUnit.getUnits(), oreUnit.getUnits(), gradeUnit.getUnits());
        }
	    this.commodityConvertor = new CommodityConvertor(id, name, mineralUnit.getUnits(),oreUnit.getUnits(),gradeUnit.getUnits(), convertedCommodity.getCommodityConvertor(), conversionFactor);
    }

    public CommodityConvertor getCommodityConvertor() {
        return this.commodityConvertor;
    }

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

	public Commodity getConvertedCommodity() {
		return convertedCommodity;
	}

	public void setConvertedCommodity(Commodity convertedCommodity) {
		this.convertedCommodity = convertedCommodity;
	}

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public MineralUnit getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(MineralUnit priceUnit) {
		this.priceUnit = priceUnit;
	}

	public MineralUnit getMineralUnit() {
		return mineralUnit;
	}

	public void setMineralUnit(MineralUnit mineralUnit) {
		this.mineralUnit = mineralUnit;
	}

	public MineralUnit getOreUnit() {
		return oreUnit;
	}

	public void setOreUnit(MineralUnit oreUnit) {
		this.oreUnit = oreUnit;
	}

	public MineralUnit getGradeUnit() {
		return gradeUnit;
	}

	public void setGradeUnit(MineralUnit gradeUnit) {
		this.gradeUnit = gradeUnit;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name;
	}
}
