package au.gov.ga.ozmin.model;


import javax.persistence.*;

import java.util.LinkedHashMap;
import java.util.Set;

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
    private Set<MineralisedZone> mineralisedZones;

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
    Set<MineralDepositCommodityOrder> mineralDepositCommodityOrders;
    
    public Set<MineralDepositCommodityOrder> getMineralDepositCommodityOrder() {
		return mineralDepositCommodityOrders;
	}

	public void setMineralDepositCommodityOrder(Set<MineralDepositCommodityOrder> mineralDepositCommodityOrder) {
		this.mineralDepositCommodityOrders = mineralDepositCommodityOrder;
	}

	@ManyToMany
    @JoinTable(schema="PROVS",name="PROVDEPOS",
    	joinColumns={@JoinColumn(name="DEPOSNO",referencedColumnName="ENO")},
        inverseJoinColumns={@JoinColumn(name="ENO", referencedColumnName="ENO")})
    private Set<Province> provinces;
    
    
    
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

    public Set<MineralisedZone> getMineralisedZones() {
        return mineralisedZones;
    }

    public void setMineralisedZones(Set<MineralisedZone> mineralisedZones) {
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

	public Set<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}
	
	public LinkedHashMap<Commodity, Integer> getOrderedCommodities() {
		LinkedHashMap<Commodity, Integer> orderedCommodities = new LinkedHashMap<Commodity, Integer>();
		for (MineralDepositCommodityOrder mdco : getMineralDepositCommodityOrder()) {
			orderedCommodities.put(mdco.getCommodity(), mdco.getCommodityOrder());
		}
		return orderedCommodities;
	}
}
