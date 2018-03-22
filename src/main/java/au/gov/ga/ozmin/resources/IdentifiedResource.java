package au.gov.ga.ozmin.resources;


import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.MineralUnit;
import au.gov.ga.ozmin.model.ResourceGrade;
import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class IdentifiedResource implements Serializable{


    public static final IdentifiedResource ZERO;

    private CommodityMeasure reserve;

    private CommodityMeasure demonstrated;

    private CommodityMeasure total;

    private CommodityMeasure economic;

    private CommodityMeasure paramarginal;

    private CommodityMeasure submarginal;

    private CommodityMeasure inferred;

    private String commodity;

    private CommodityMeasure proven;
    private CommodityMeasure probable;
    private CommodityMeasure provenAndProbable;
    private CommodityMeasure measured;
    private CommodityMeasure indicated;
    private CommodityMeasure measuredAndIndicated;
    private CommodityMeasure jorcInferred;
    private CommodityMeasure other;
    private Boolean inclusive = true;


    public IdentifiedResource() {
        this.proven = ZeroCommodityMeasure.getInstance();
        this.probable = ZeroCommodityMeasure.getInstance();
        this.provenAndProbable = ZeroCommodityMeasure.getInstance();
        this.measured = ZeroCommodityMeasure.getInstance();
        this.indicated = ZeroCommodityMeasure.getInstance();
        this.measuredAndIndicated = ZeroCommodityMeasure.getInstance();
        this.jorcInferred = ZeroCommodityMeasure.getInstance();
        this.other = ZeroCommodityMeasure.getInstance();
        this.commodity = null;
    }

    public IdentifiedResource(CommodityMeasure proven, CommodityMeasure probable, CommodityMeasure provenAndProbable,
                              CommodityMeasure measured, CommodityMeasure indicated, CommodityMeasure measuredAndIndicated,
                              CommodityMeasure inferred, CommodityMeasure other, String commodity, Boolean inclusive) {
        this.proven = proven.convert();
        this.probable = probable.convert();
        this.provenAndProbable = provenAndProbable.convert();
        this.measured = measured.convert();
        this.indicated = indicated.convert();
        this.measuredAndIndicated = measuredAndIndicated.convert();
        this.jorcInferred = inferred.convert();
        this.other = other.convert();
        this.commodity = commodity;

        this.inclusive = inclusive;


        this.reserve = calculateReserve();
        this.demonstrated = calculateDemonstrated();
        this.total = calculateTotal();
    }

    public IdentifiedResource(CommodityMeasure reserve, CommodityMeasure demonstrated, CommodityMeasure total) {
        this.reserve = reserve;
        this.demonstrated = demonstrated;
        this.total = total;
    }



    private CommodityMeasure calculateReserve() {
        return proven.add(probable).add(provenAndProbable);

    }

    private CommodityMeasure  calculateDemonstrated() {
        if (inclusive) {
            return measured.add(indicated).add(measuredAndIndicated);
        }
        return calculateReserve().add(measured).add(indicated).add(measuredAndIndicated);
    }

    private CommodityMeasure calculateTotal() {
        return calculateDemonstrated().add(jorcInferred).add(other);
    }

    @JsonProperty
    public CommodityMeasure getReserve() {
        return reserve;
    }

    @JsonProperty
    public CommodityMeasure getDemonstrated() {
        return demonstrated;
    }

    @JsonProperty
    public CommodityMeasure getTotal() {
        return total;
    }

    public IdentifiedResource add (IdentifiedResource identifiedResource){
        CommodityMeasure calculatedReserve = reserve.add(identifiedResource.getReserve());
        CommodityMeasure calculatedDemonstrated = demonstrated.add(identifiedResource.getDemonstrated());
        CommodityMeasure calculatedTotal = total.add(identifiedResource.getTotal());
        return new IdentifiedResource(calculatedReserve,calculatedDemonstrated,calculatedTotal);
    }

    static {
        ZERO = new IdentifiedResource();
    }
}
