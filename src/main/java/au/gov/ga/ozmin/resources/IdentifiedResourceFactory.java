package au.gov.ga.ozmin.resources;

import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.MineralUnit;
import au.gov.ga.ozmin.model.ResourceGrade;
import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;

public class IdentifiedResourceFactory {

    private IdentifiedResourceFactory() {
    }

    public static final IdentifiedResource generateIdentifiedResource(MineralResource mineralResource, ResourceGrade resourceGrade) throws IdentifiedResourceException {
        MineralUnit oreUnit = mineralResource.getOreUnit();
        MineralUnit gradeUnit = resourceGrade.getGradeUnit();
        if (gradeUnit == null || oreUnit == null) {
            return IdentifiedResource.ZERO;
        }

        String commodity = resourceGrade.getCommodity().getId();

        CommodityMeasure proven = new JorcCategoryMeasure(mineralResource.getProven(), oreUnit.getUnits(), resourceGrade.getProven(), gradeUnit.getUnits(), commodity);
        CommodityMeasure probable = new JorcCategoryMeasure(mineralResource.getProbable(), oreUnit.getUnits(), resourceGrade.getProbable(), gradeUnit.getUnits(), commodity);
        CommodityMeasure provenAndProbable = new JorcCategoryMeasure(mineralResource.getProvenAndProbable(), oreUnit.getUnits(), resourceGrade.getProvenAndProbable(), gradeUnit.getUnits(), commodity);
        CommodityMeasure measured = new JorcCategoryMeasure(mineralResource.getMeasured(), oreUnit.getUnits(), resourceGrade.getMeasured(),gradeUnit.getUnits(), commodity);
        CommodityMeasure indicated = new JorcCategoryMeasure(mineralResource.getIndicated(), oreUnit.getUnits(), resourceGrade.getIndicated(), gradeUnit.getUnits(), commodity);
        CommodityMeasure measuredAndIndicated = new JorcCategoryMeasure(mineralResource.getMeasuredAndIndicated(), oreUnit.getUnits(), resourceGrade.getMeasuredAndIndicated(), gradeUnit.getUnits(), commodity);
        CommodityMeasure inferred = new JorcCategoryMeasure(mineralResource.getInferred(), oreUnit.getUnits(), resourceGrade.getInferred(), gradeUnit.getUnits(), commodity);
        CommodityMeasure other = new JorcCategoryMeasure(mineralResource.getOther(), oreUnit.getUnits(), resourceGrade.getOther(), gradeUnit.getUnits(), commodity);

        return new IdentifiedResource(proven, probable, provenAndProbable, measured, indicated, measuredAndIndicated, inferred, other, commodity, mineralResource.getInclusive());
    }
}
