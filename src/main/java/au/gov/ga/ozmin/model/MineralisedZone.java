package au.gov.ga.ozmin.model;


import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERALISED ZONE")
public class MineralisedZone extends SpatialEntity {

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "PARENT")
    private MineralDeposit mineralDeposit;
    

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralisedZone")
    private Set<MineralResource> mineralResources;


	public MineralDeposit getMineralDeposit() {
		return mineralDeposit;
	}


	public void setMineralDeposit(MineralDeposit mineralDeposit) {
		this.mineralDeposit = mineralDeposit;
	}


	public Set<MineralResource> getMineralResources() {
		return mineralResources;
	}


	public void setMineralResources(Set<MineralResource> mineralResources) {
		this.mineralResources = mineralResources;
	}
    
    
}
