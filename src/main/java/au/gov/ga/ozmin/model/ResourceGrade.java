package au.gov.ga.ozmin.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "MGD", name = "RESOURCE_GRADES")
public class ResourceGrade {

	@Id
	@Column(name = "RESCOMMNO")
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

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "PVR_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "PVR_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "PVR_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "PVR_PCNT2") ) })
	private GaClassification provenClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "PBR_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "PBR_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "PBR_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "PBR_PCNT2") ) })
	private GaClassification probableClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "PPR_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "PPR_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "PPR_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "PPR_PCNT2") ) })
	private GaClassification provenAndProbableClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "MRS_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "MRS_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "MRS_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "MRS_PCNT2") ) })
	private GaClassification measuredClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "IDR_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "IDR_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "IDR_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "IDR_PCNT2") ) })
	private GaClassification indicatedClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "MID_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "MID_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "MID_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "MID_PCNT2") ) })
	private GaClassification measuredAndIndicatedClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "IFR_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "IFR_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "IFR_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "IFR_PCNT2") ) })
	private GaClassification inferredClassification;

	@AttributeOverrides({ @AttributeOverride(name = "mainClassification", column = @Column(name = "OTHER_CLASS1") ),
			@AttributeOverride(name = "secondClassification", column = @Column(name = "OTHER_CLASS2") ),
			@AttributeOverride(name = "mainPercentage", column = @Column(name = "OTHER_PCNT1") ),
			@AttributeOverride(name = "secondPercentage", column = @Column(name = "OTHER_PCNT2") ) })
	private GaClassification otherClassification;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
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

	public GaClassification getProvenClassification() {
		return provenClassification;
	}

	public void setProvenClassification(GaClassification provenClassification) {
		this.provenClassification = provenClassification;
	}

	public GaClassification getProbableClassification() {
		return probableClassification;
	}

	public void setProbableClassification(GaClassification probableClassification) {
		this.probableClassification = probableClassification;
	}

	public GaClassification getProvenAndProbableClassification() {
		return provenAndProbableClassification;
	}

	public void setProvenAndProbableClassification(GaClassification provenAndProbableClassification) {
		this.provenAndProbableClassification = provenAndProbableClassification;
	}

	public GaClassification getMeasuredClassification() {
		return measuredClassification;
	}

	public void setMeasuredClassification(GaClassification measuredClassification) {
		this.measuredClassification = measuredClassification;
	}

	public GaClassification getIndicatedClassification() {
		return indicatedClassification;
	}

	public void setIndicatedClassification(GaClassification indicatedClassification) {
		this.indicatedClassification = indicatedClassification;
	}

	public GaClassification getMeasuredAndIndicatedClassification() {
		return measuredAndIndicatedClassification;
	}

	public void setMeasuredAndIndicatedClassification(GaClassification measuredAndIndicatedClassification) {
		this.measuredAndIndicatedClassification = measuredAndIndicatedClassification;
	}

	public GaClassification getInferredClassification() {
		return inferredClassification;
	}

	public void setInferredClassification(GaClassification inferredClassification) {
		this.inferredClassification = inferredClassification;
	}

	public GaClassification getOtherClassification() {
		return otherClassification;
	}

	public void setOtherClassification(GaClassification otherClassification) {
		this.otherClassification = otherClassification;
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
