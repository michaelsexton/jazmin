package au.gov.ga.ozmin.model;


import javax.persistence.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERAL DEPOSIT")
@SecondaryTable(schema="MGD",name = "DEPOSITS", pkJoinColumns = @PrimaryKeyJoinColumn(name="ENO"))
public class MineralDeposit extends SpatialEntity {

    @ManyToOne
    @JoinColumn(name = "PARENT")
    private MineralProject mineralProject;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralDeposit")
    private List<MineralisedZone> mineralisedZones;

    @Column(name="OPERATING_STATUS",table="DEPOSITS")
    private String operatingStatus;
    
    @Column(name="STATE",table="DEPOSITS")
    private String state;
    
    @Column(name="SYNONYMS",table="DEPOSITS")
    private String synonyms;
    
//    @ManyToMany
//    @JoinTable(schema="MGD",name="COMMODS",
//    	joinColumns={@JoinColumn(name="ENO",referencedColumnName="ENO")},
//    	inverseJoinColumns={@JoinColumn(name="COMMODID", referencedColumnName="COMMODID")})
//    private List<Commodity> commodities;
    
    
    @OneToMany(mappedBy="id.mineralDeposit")
    List<MineralDepositCommodityOrder> mineralDepositCommodityOrder;
    
    public List<MineralDepositCommodityOrder> getMineralDepositCommodityOrder() {
		return mineralDepositCommodityOrder;
	}

	public void setMineralDepositCommodityOrder(List<MineralDepositCommodityOrder> mineralDepositCommodityOrder) {
		this.mineralDepositCommodityOrder = mineralDepositCommodityOrder;
	}

	@ManyToMany
    @JoinTable(schema="PROVS",name="PROVDEPOS",
    	joinColumns={@JoinColumn(name="DEPOSNO",referencedColumnName="ENO")},
        inverseJoinColumns={@JoinColumn(name="ENO", referencedColumnName="ENO")})
    private List<Province> provinces;
    
    
    
//    @ManyToMany
//    @JoinTable(schema="MGD",name="REFLINKS")
//    private List<Reference> references;
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public MineralProject getMineralProject() {
        return mineralProject;
    }

    public void setMineralProject(MineralProject mineralProject) {
        this.mineralProject = mineralProject;
    }

    public List<MineralisedZone> getMineralisedZones() {
        return mineralisedZones;
    }

    public void setMineralisedZones(List<MineralisedZone> mineralisedZones) {
        this.mineralisedZones = mineralisedZones;
    }

	public String getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(String operatingStatus) {
		this.operatingStatus = operatingStatus;
	}

//	public List<Commodity> getCommodities() {
//		return commodities;
//	}
//
//	public void setCommodities(List<Commodity> commodities) {
//		this.commodities = commodities;
//	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}
	
	public LinkedHashMap<Integer, Commodity> getOrderedCommodities() {
		LinkedHashMap<Integer, Commodity> orderedCommodities = new LinkedHashMap<Integer, Commodity>();
		for (MineralDepositCommodityOrder mdco : getMineralDepositCommodityOrder()) {
			orderedCommodities.put(mdco.getCommodityOrder(), mdco.getCommodity());
		}
		return orderedCommodities;
	}
}
