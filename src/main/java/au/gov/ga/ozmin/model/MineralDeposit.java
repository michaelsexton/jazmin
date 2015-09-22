package au.gov.ga.ozmin.model;


import javax.persistence.*;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mineralDeposit")
    private List<MineralisedZone> mineralisedZones;

    @Column(name="OPERATING_STATUS",table="DEPOSITS")
    private String operatingStatus;
    
    @Column(name="STATE",table="DEPOSITS")
    private String state;
    
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
}
