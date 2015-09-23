package au.gov.ga.ozmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="MGD",name="RESOURCE_GRADES")
public class ResourceGrade {

	@Id
	@Column(name="RESCOMMNO") 
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COMMODID")
	private Commodity commodity;
	
	@ManyToOne
	@JoinColumn(name = "UNIT_GRADE")
	private Unit gradeUnit;
	
	@Column(name = "PVR")
	private Double proven;

	@Column(name = "PBR")
	private Double probable;

	@Column(name = "PPR")
	private Double provenAndProbable;

	@Column(name = "MRS")
	private Double measured;

	@Column(name = "IDR")
	private Double indicated;

	@Column(name = "MID")
	private Double measuredAndIndicated;

	@Column(name = "IFR")
	private Double inferred;

	@Column(name = "OTHER")
	private Double other;
	
	@ManyToOne
	@JoinColumn(name = "RESOURCENO")
	private MineralResource mineralResource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Unit getGradeUnit() {
		return gradeUnit;
	}

	public void setGradeUnit(Unit gradeUnit) {
		this.gradeUnit = gradeUnit;
	}

	public Double getProven() {
		return proven;
	}

	public void setProven(Double proven) {
		this.proven = proven;
	}

	public Double getProbable() {
		return probable;
	}

	public void setProbable(Double probable) {
		this.probable = probable;
	}

	public Double getProvenAndProbable() {
		return provenAndProbable;
	}

	public void setProvenAndProbable(Double provenAndProbable) {
		this.provenAndProbable = provenAndProbable;
	}

	public Double getMeasured() {
		return measured;
	}

	public void setMeasured(Double measured) {
		this.measured = measured;
	}

	public Double getIndicated() {
		return indicated;
	}

	public void setIndicated(Double indicated) {
		this.indicated = indicated;
	}

	public Double getMeasuredAndIndicated() {
		return measuredAndIndicated;
	}

	public void setMeasuredAndIndicated(Double measuredAndIndicated) {
		this.measuredAndIndicated = measuredAndIndicated;
	}

	public Double getInferred() {
		return inferred;
	}

	public void setInferred(Double inferred) {
		this.inferred = inferred;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	public MineralResource getMineralResource() {
		return mineralResource;
	}

	public void setMineralResource(MineralResource mineralResource) {
		this.mineralResource = mineralResource;
	}

	
}
