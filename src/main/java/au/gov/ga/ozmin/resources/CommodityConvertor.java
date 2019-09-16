package au.gov.ga.ozmin.resources;

import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import java.math.BigDecimal;

public class CommodityConvertor {

    private String commodity;

    private String commodityName;

    private BigDecimal conversionFactor;

    private CommodityConvertor convertedCommodity;

    private Unit mineralUnit;

    private Unit oreUnit;

    private Unit gradeUnit;

    public CommodityConvertor(String commodity, String commodityName, Unit mineralUnit, Unit oreUnit, Unit gradeUnit) {
        this(commodity,commodityName, mineralUnit, oreUnit, gradeUnit, null, null);
    }

    public CommodityConvertor(String commodity, String commodityName, Unit mineralUnit, Unit oreUnit, Unit gradeUnit, CommodityConvertor convertedCommodity, BigDecimal conversionFactor) {
        this.commodity = commodity;
        this.commodityName = commodityName;
        this.conversionFactor = conversionFactor;
        this.mineralUnit = mineralUnit;
        this.oreUnit = oreUnit;
        this.gradeUnit = gradeUnit;
        this.convertedCommodity = convertedCommodity;
        this.conversionFactor = conversionFactor;
    }

    public String getCommodity() {
        return commodity;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public BigDecimal getConverstionFactor() {
        return conversionFactor;
    }

    public Unit getMineralUnit() {
        return mineralUnit;
    }

    public Unit getOreUnit() {
        return oreUnit;
    }

    public Unit getGradeUnit() {
        return gradeUnit;
    }

    public CommodityConvertor getConvertedCommodity() {
        return convertedCommodity;
    }
}
