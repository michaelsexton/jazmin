package au.gov.ga.ozmin.resources;


import javax.measure.Quantity;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;

public interface CommodityMeasure {


     Quantity<Mass> getOre();

     Quantity<Dimensionless> getGrade();

     Quantity<Mass> getContainedCommodity();

     String getCommodity();
}
