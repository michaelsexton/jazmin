package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.model.MineralUnit;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.MetricPrefix;
import tec.uom.se.unit.Units;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.math.BigDecimal;

public class JorcCategoryMeasure implements CommodityMeasure {

    private Quantity<Mass> ore;

    private Quantity<Dimensionless> grade;

    private String commodity;

    JorcCategoryMeasure(BigDecimal oreValue, MineralUnit oreUnits, BigDecimal gradeValue, MineralUnit gradeUnits, String commodity) {
        Unit<Mass> kg = Units.KILOGRAM;
        Unit<Dimensionless> percent = Units.PERCENT;


        this.ore = Quantities.getQuantity(oreValue != null ? oreValue : BigDecimal.ZERO, kg);

        this.grade = Quantities.getQuantity(gradeValue != null ? gradeValue : BigDecimal.ZERO, percent);

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
        return (Quantity<Mass>) ore.multiply(grade.to(Units.ONE));
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