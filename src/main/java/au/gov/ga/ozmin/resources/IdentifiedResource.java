package au.gov.ga.ozmin.resources;


import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.MineralUnit;
import au.gov.ga.ozmin.model.ResourceGrade;
import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class IdentifiedResource implements Serializable{



    private CommodityMeasure reserve;

    private CommodityMeasure demonstrated;

    private CommodityMeasure total;

    private CommodityMeasure economic;

    private CommodityMeasure paramarginal;

    private CommodityMeasure submarginal;

    private CommodityMeasure inferred;

    private CommodityMeasure proven;
    private CommodityMeasure probable;
    private CommodityMeasure provenAndProbable;
    private CommodityMeasure measured;
    private CommodityMeasure indicated;
    private CommodityMeasure measuredAndIndicated;
    private CommodityMeasure jorcInferred;
    private CommodityMeasure other;
    private Boolean inclusive;


    /* Make a factory */
    public IdentifiedResource(MineralResource mineralResource, ResourceGrade resourceGrade) throws IdentifiedResourceException {
        MineralUnit oreUnit = mineralResource.getOreUnit();
        MineralUnit gradeUnit = resourceGrade.getGradeUnit();
        String commodity = resourceGrade.getCommodity().getId();
        this.proven = new JorcCategoryMeasure(mineralResource.getProven(), oreUnit, resourceGrade.getProven(), gradeUnit, commodity);
        this.probable = new JorcCategoryMeasure(mineralResource.getProbable(), oreUnit, resourceGrade.getProbable(), gradeUnit, commodity);
        this.provenAndProbable = new JorcCategoryMeasure(mineralResource.getProvenAndProbable(), oreUnit, resourceGrade.getProvenAndProbable(), gradeUnit, commodity);
        this.measured = new JorcCategoryMeasure(mineralResource.getMeasured(), oreUnit, resourceGrade.getMeasured(),gradeUnit, commodity);
        this.indicated = new JorcCategoryMeasure(mineralResource.getIndicated(), oreUnit, resourceGrade.getIndicated(), gradeUnit, commodity);
        this.measuredAndIndicated = new JorcCategoryMeasure(mineralResource.getMeasuredAndIndicated(), oreUnit, resourceGrade.getMeasuredAndIndicated(), gradeUnit, commodity);
        this.jorcInferred = new JorcCategoryMeasure(mineralResource.getInferred(), oreUnit, resourceGrade.getInferred(), gradeUnit, commodity);
        this.other = new JorcCategoryMeasure(mineralResource.getOther(), oreUnit, resourceGrade.getOther(), gradeUnit, commodity);

        this.inclusive = mineralResource.getInclusive();


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
}
