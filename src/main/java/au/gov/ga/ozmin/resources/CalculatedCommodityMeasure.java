package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.model.Commodity;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

import javax.measure.IncommensurableException;
import javax.measure.Quantity;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.math.BigDecimal;

public class CalculatedCommodityMeasure implements CommodityMeasure {

    private Quantity<Mass> ore;
    private Quantity<Dimensionless> grade;
    private Quantity<Mass> containedCommodity;
    private CommodityConvertor convertor;

    public CalculatedCommodityMeasure(Quantity<Mass> ore, Quantity<Mass> containedCommodity, CommodityConvertor convertor) {
        this.ore = ore;
        this.containedCommodity = containedCommodity;
        this.convertor = convertor;
    };

    @Override
    public Quantity<Mass> getOre() {
        if (convertor.getOreUnit() != null) {
            return ore.to(convertor.getOreUnit());
        }
        return ore;
    }

    @Override
    public Quantity<Mass> getContainedCommodity() {
        if (convertor.getMineralUnit() != null) {
            try {
                return containedCommodity.to(convertor.getMineralUnit());
            } catch (Exception e) {
                return containedCommodity;
            }
        }
        return containedCommodity;
    }

    @Override
    public Quantity<Dimensionless> getGrade() {
        if (ore.getValue().doubleValue() == 0) {
            return Quantities.getQuantity(0, Units.PERCENT);
        }
        Quantity<Dimensionless> newQuantity = (Quantity<Dimensionless>) containedCommodity.divide(ore);
        if (convertor.getGradeUnit() != null) {
            return newQuantity.to(convertor.getGradeUnit());
        }
        //Log dis bad
        return newQuantity.to(Units.PERCENT);
    }



    @Override
    public String getCommodity() {
        return convertor.getCommodity();
    }

    @Override
    public CommodityMeasure add(CommodityMeasure measure){
        if (measure != null && this.convertor != null && this.getCommodity().equals(measure.getCommodity())) {
            Quantity<Mass> calculatedOre = this.ore.add(measure.getOre());
            Quantity<Mass> calculatedContainedCommodity = this.getContainedCommodity().add(measure.getContainedCommodity());
            return new CalculatedCommodityMeasure(calculatedOre, calculatedContainedCommodity, this.convertor);
        }
        return this;
    }

    @Override
    public CommodityMeasure subtract(CommodityMeasure measure) {
        return null;
    }

    @Override
    public CommodityMeasure multiply(BigDecimal number) {
        return new CalculatedCommodityMeasure(this.ore.multiply(number), this.containedCommodity.multiply(number), this.convertor);
    }

    @Override
    public CommodityMeasure convert() {
        if (convertor != null && convertor.getConvertedCommodity() != null) {
            CommodityMeasure measure = new CalculatedCommodityMeasure(this.ore, this.containedCommodity, convertor.getConvertedCommodity());
            return measure.multiply(convertor.getConverstionFactor());
        }
        return this;
    }


    @Override
    public int compareTo(CommodityMeasure c) {
        if (c instanceof CommodityMeasure) {
            BigDecimal thisValue =  (BigDecimal) containedCommodity.getValue();
            BigDecimal thatValue = (BigDecimal) c.getContainedCommodity().getValue();
            return thisValue.compareTo(thatValue);
        }
        return 0;
    }

}
