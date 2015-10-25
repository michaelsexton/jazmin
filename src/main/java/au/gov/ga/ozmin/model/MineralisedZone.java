package au.gov.ga.ozmin.model;


import java.util.List;

import javax.persistence.*;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERALISED ZONE")
public class MineralisedZone extends SpatialEntity {

    @ManyToOne
    @JoinColumn(name = "PARENT")
    private MineralDeposit mineralDeposit;
    

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralisedZone")
    private List<MineralResource> mineralResources;


	public MineralDeposit getMineralDeposit() {
		return mineralDeposit;
	}


	public void setMineralDeposit(MineralDeposit mineralDeposit) {
		this.mineralDeposit = mineralDeposit;
	}


	public List<MineralResource> getMineralResources() {
		return mineralResources;
	}


	public void setMineralResources(List<MineralResource> mineralResources) {
		this.mineralResources = mineralResources;
	}
    
    
}
