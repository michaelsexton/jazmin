package au.gov.ga.ozmin.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@DiscriminatorValue("MINERAL PROJECT")
public class MineralProject extends SpatialEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mineralProject")
    private List<MineralDeposit> mineralDeposits;

    public List<MineralDeposit> getMineralDeposits() {
        return mineralDeposits;
    }

    public void setMineralDeposits(List<MineralDeposit> mineralDeposits) {
        this.mineralDeposits = mineralDeposits;
    }
}
