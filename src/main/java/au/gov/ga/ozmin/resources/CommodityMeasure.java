package au.gov.ga.ozmin.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.measure.Quantity;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.io.Serializable;

public interface CommodityMeasure extends Serializable {

     Quantity<Mass> getOre();

     Quantity<Dimensionless> getGrade();

     Quantity<Mass> getContainedCommodity();

     @JsonProperty
     String getCommodity();

     CommodityMeasure add(CommodityMeasure measure);

     CommodityMeasure subtract(CommodityMeasure measure);
}
