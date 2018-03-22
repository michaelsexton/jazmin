package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.util.GAUnit;
import tec.uom.se.AbstractQuantity;
import tec.uom.se.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.math.BigDecimal;

public class ZeroCommodityMeasure implements CommodityMeasure {

    private static ZeroCommodityMeasure INSTANCE = null;

    private ZeroCommodityMeasure() {

    }

    public static ZeroCommodityMeasure getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZeroCommodityMeasure();
        }
        return INSTANCE;
    }

    @Override
    public Quantity<Mass> getOre() {
        return Quantities.getQuantity(0, GAUnit.MEGATONNE);
    }

    @Override
    public Quantity<Dimensionless> getGrade() {
        return AbstractQuantity.NONE;
    }

    @Override
    public Quantity<Mass> getContainedCommodity() {
        return Quantities.getQuantity(0, GAUnit.KILOTONNE);
    }

    @Override
    public String getCommodity() {
        return null;
    }

    @Override
    public CommodityMeasure add(CommodityMeasure measure) {
        return measure;
    }

    @Override
    public CommodityMeasure subtract(CommodityMeasure measure) {
        return measure.multiply(new BigDecimal(-1));
    }

    @Override
    public CommodityMeasure multiply(BigDecimal number) {
        return INSTANCE;
    }

    @Override
    public CommodityMeasure convert() {
        return this;
    }

    @Override
    public int compareTo(CommodityMeasure c) {
        if (c instanceof CommodityMeasure) {
            BigDecimal thisValue =  (BigDecimal) getContainedCommodity().getValue();
            BigDecimal thatValue = (BigDecimal) c.getContainedCommodity().getValue();
            return thisValue.compareTo(thatValue);
        }
        return 0;
    }
}
