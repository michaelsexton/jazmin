package au.gov.ga.ozmin.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERAL DEPOSIT")
public class MineralDeposit extends SpatialEntity {

    @ManyToOne
    @JoinColumn(name = "PARENT")
    private MineralProject mineralProject;

    @OneToMany
    private List<MineralisedZone> mineralisedZones;

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
}
