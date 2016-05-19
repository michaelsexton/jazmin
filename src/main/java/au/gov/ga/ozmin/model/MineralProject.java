package au.gov.ga.ozmin.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERAL PROJECT")
public class MineralProject extends SpatialEntity {
/*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralProject")
    private Set<MineralDeposit> mineralDeposits;

    public Set<MineralDeposit> getMineralDeposits() {
        return mineralDeposits;
    }

    public void setMineralDeposits(Set<MineralDeposit> mineralDeposits) {
        this.mineralDeposits = mineralDeposits;
    }*/
}
