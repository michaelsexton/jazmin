package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.model.MineralUnit;
import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import au.gov.ga.ozmin.util.GAUnit;
import tec.uom.se.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.math.BigDecimal;

public class JorcCategoryMeasure implements CommodityMeasure {

    private Quantity<Mass> ore;

    private Quantity<Dimensionless> grade;

    private String commodity;

    JorcCategoryMeasure(BigDecimal oreValue, MineralUnit oreUnits, BigDecimal gradeValue, MineralUnit gradeUnits, String commodity) throws IdentifiedResourceException {


        /**
         * Move below to MineralUnits class
         */
        Unit r_units = GAUnit.getUnitBySymbol(oreUnits.getCode());
        Unit g_units = GAUnit.getUnitBySymbol(gradeUnits.getCode());




        this.ore = Quantities.getQuantity(oreValue != null ? oreValue : BigDecimal.ZERO, r_units);

        this.grade = Quantities.getQuantity(gradeValue != null ? gradeValue : BigDecimal.ZERO, g_units);

        this.commodity = commodity;
    }


    @Override
    public Quantity<Mass> getOre() {
        return ore;
    }

    @Override
    public Quantity<Dimensionless> getGrade() {
        return grade;
    }

    @Override
    public Quantity<Mass> getContainedCommodity() {
        return (Quantity<Mass>) ore.multiply(grade);
    }

    @Override
    public String getCommodity() {
        return commodity;
    }

    @Override
    public CommodityMeasure add(CommodityMeasure measure) {
        if (!this.commodity.equals(measure.getCommodity())) {
            return null;
        }
        Quantity<Mass> calculatedOre = this.ore.add(measure.getOre());
        Quantity<Mass> calculatedContainedCommodity = this.getContainedCommodity().add(measure.getContainedCommodity());
        return new CalculatedCommodityMeasure(calculatedOre,calculatedContainedCommodity, this.commodity);
    }

    @Override
    public CommodityMeasure subtract(CommodityMeasure measure) {
        return null;
    }


}