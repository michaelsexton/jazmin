package au.gov.ga.ozmin.resources;

import tec.uom.se.AbstractQuantity;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

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
        return Quantities.getQuantity(0, Units.GRAM);
    }

    @Override
    public Quantity<Dimensionless> getGrade() {
        return AbstractQuantity.NONE;
    }

    @Override
    public Quantity<Mass> getContainedCommodity() {
        return Quantities.getQuantity(0, Units.GRAM);
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
}
