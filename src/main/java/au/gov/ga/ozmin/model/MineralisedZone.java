package au.gov.ga.ozmin.model;


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
}
