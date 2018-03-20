package au.gov.ga.ozmin.model;

import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import au.gov.ga.ozmin.util.GAUnit;

import javax.measure.Unit;
import javax.persistence.*;

@Entity
@Table(schema="MGD",name="UNIT_CODES")
public class MineralUnit {

    @Id
    @Column(name="UNITCODE")
    private String code;

    @Column(name="UNITVALUE")
    private Double value;

    @Column(name="DOMAIN")
    private String domain;

    @Column(name="UNITMEANING")
    private String name;

    public String getCode() {
        return code;
    }

    @Transient
    private Unit units;

    @PostLoad
    private  void loadUnits() throws IdentifiedResourceException {
        this.units = GAUnit.getUnitBySymbol(code);
    }

    public Unit getUnits() {
        return units;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "code="+code+", name="+name ;
    }
}
