package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.model.MineralUnit;

import java.math.BigDecimal;

public class ClassifiedMeasure extends JorcCategoryMeasure {

    private EconomicClassification primaryClassification;

    private EconomicClassification secondaryClassification;

    public ClassifiedMeasure(BigDecimal oreValue, MineralUnit oreUnits, BigDecimal gradeValue, MineralUnit gradeUnits, String commodity) {
        super(oreValue, oreUnits, gradeValue, gradeUnits, commodity);
    }
}
