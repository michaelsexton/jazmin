package au.gov.ga.ozmin.util;




import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import tec.uom.lib.common.function.Nameable;
import tec.uom.se.AbstractSystemOfUnits;
import tec.uom.se.AbstractUnit;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.unit.MetricPrefix;
import tec.uom.se.unit.Units;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import static tec.uom.se.unit.MetricPrefix.*;

public final class GAUnit extends AbstractSystemOfUnits implements Nameable {

    private static final GAUnit INSTANCE = new GAUnit();

    protected GAUnit() {

    }

    @Override
    public String getName() {
        return null;
    }

    public static Unit getUnitBySymbol(String symbol) throws IdentifiedResourceException {
        switch (symbol)
        {
            case "Kt":
                return KILOTONNE;
            case "%":
                return PERCENTAGE;
            case "Mt":
                return MEGATONNE;
            case "t":
                return TONNE;
            default:
                throw new IdentifiedResourceException(symbol);
        }
    }

    public static final Unit<Volume> CUBIC_METRE = addUnit(Units.CUBIC_METRE);
    public static final Unit<Volume> MEGA_CUBIC_METRE = addUnit(MEGA(Units.CUBIC_METRE));
    public static final Unit<Volume> LITRE = addUnit(Units.LITRE);
    public static final Unit<Volume> GIGALITRE = addUnit(GIGA(Units.LITRE));
    public static final Unit<Volume> BANK_CUBIC_METRE = addUnit(Units.CUBIC_METRE);

    public static final Unit<Mass> GRAM = addUnit(Units.GRAM);
    public static final Unit<Mass> KILOGRAM = addUnit(Units.KILOGRAM);
    public static final Unit<Mass> TONNE = addUnit(GAUnit.KILOGRAM.multiply(1000));
    public static final Unit<Mass> KILOTONNE = addUnit(KILO(GAUnit.TONNE));
    public static final Unit<Mass> MEGATONNE = addUnit(MEGA(GAUnit.TONNE));
    public static final Unit<Mass> GIGATONNE = addUnit(GIGA(GAUnit.TONNE));



    //public static final Unit<Mass> OUNCE = addUnit(Imperial.OUNCE);
    //public static final Unit<Mass> POUND = addUnit(Imperial.);
//    public static final Unit<Mass> TON = addUnit(UCUM.LONG_TON);
//    public static final Unit<Mass> MEGATON = addUnit(MetricPrefix.MEGA(GAUnit.TON));
//    public static final Unit<Mass> KILOTON = addUnit(MetricPrefix.KILO(GAUnit.TON));
//
//    public static final Unit<Mass> CARAT = addUnit(UCUM.CARAT_METRIC);
//    public static final Unit<Mass> MILLION_CARAT = addUnit(new ProductUnit<Mass>(UCUM.MILLIONS.multiply(GAUnit.CARAT)));
//
//    public static final Unit<Energy> JOULE = addUnit(Units.JOULE);
//    public static final Unit<Energy> PETAJOULE = addUnit(MetricPrefix.PETA(Units.JOULE));

    public static final Unit<Dimensionless> PERCENTAGE = addUnit(Units.PERCENT);
//    public static final Unit<Dimensionless> GRAMS_PER_TONNE = addUnit(new ProductUnit<Dimensionless>(GAUnit.GRAM.divide(GAUnit.TONNE)));
//    public static final Unit<Dimensionless> KILOGRAMS_PER_TONNE = addUnit(new ProductUnit<Dimensionless>(GAUnit.KILOGRAM.divide(GAUnit.TONNE)));
//
//
//    //public static final Unit<Dimensionless> OUNCES_PER_TON = addUnit(new ProductUnit<Dimensionless>(GAUnit.OUNCE.divide(GAUnit.TON)));
//
//    public static final Unit<Dimensionless> PARTS_PER_MILLION = addUnit(UCUM.PER_MILLION);
//
//    public static final Unit<Dimensionless> CARATS_PER_TONNE =  addUnit(new ProductUnit<Dimensionless>(GAUnit.CARAT.divide(GAUnit.TONNE)));
//
//    public static final Unit<Density> GRAMS_PER_CUBIC_METRE = addUnit(new ProductUnit<Density>(GAUnit.GRAM.divide(GAUnit.CUBIC_METRE)));
//    public static final Unit<Density> KILOGRAMS_PER_CUBIC_METRE = addUnit(new ProductUnit<Density>(GAUnit.KILOGRAM.divide(GAUnit.CUBIC_METRE)));
//
//    public static final Unit<Density> GRAMS_PER_BANK_CUBIC_METRE = addUnit(new ProductUnit<Density>(GAUnit.GRAM.divide(GAUnit.BANK_CUBIC_METRE)));
//    public static final Unit<Density> KILOGRAMS_PER_BANK_CUBIC_METRE = addUnit(new ProductUnit<Density>(GAUnit.KILOGRAM.divide(GAUnit.BANK_CUBIC_METRE)));
//    public static final Unit<Density> GRAMS_PER_LOOSE_CUBIC_METRE = addUnit(new ProductUnit<Density>(GAUnit.GRAM.divide(GAUnit.BANK_CUBIC_METRE)));




    //public static final Unit<Information> = new AlternateUnit<SpecificVolume>();




    private static <U extends Unit<Q>, Q extends Quantity<Q>> U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }

    /**
     * Adds a new unit and maps it to the specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @param type
     *            the quantity type.
     * @return <code>unit</code>.
     */
    private static <U extends AbstractUnit<?>> U addUnit(U unit, Class<? extends Quantity<?>> type) {
        INSTANCE.units.add(unit);
        INSTANCE.quantityToUnit.put(type, unit);
        return unit;
    }


    private static <U extends Unit<?>> U addUnit(U unit, String name, String text, boolean isLabel) {
        if (isLabel) {
            SimpleUnitFormat.getInstance().label(unit, text);
        }
        if (name != null && unit instanceof AbstractUnit) {
            return Helper.addUnit(INSTANCE.units, unit, name);
        } else {
            INSTANCE.units.add(unit);
        }
        return unit;
    }

    static {
        try {
            SimpleUnitFormat.getInstance().label(TONNE,"t");
            System.out.println("TRYOIN");
        } catch (Throwable t) {
            System.out.println("Blaaaa");
        }

    }
}