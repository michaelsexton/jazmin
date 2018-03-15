package au.gov.ga.ozmin.resources;

import javax.measure.Quantity;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;

public class JorcCategoryMeasure implements CommodityMeasure {

    private Quantity<Mass> ore;

    private Quantity<Dimensionless> grade;

    private String commodity;

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
        return null;
    }
}
