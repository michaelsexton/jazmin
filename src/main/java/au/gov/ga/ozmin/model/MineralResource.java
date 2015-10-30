package au.gov.ga.ozmin.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(schema = "MGD", name = "RESOURCES")
public class MineralResource {

	@Id
	@Column(name = "RESOURCENO")
	private Long id;

	@Column(name = "RECORDDATE")
	private Date recordDate;

	@ManyToOne
	@JoinColumn(name = "UNIT_QUANTITY")
	private Unit oreUnit;

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

	// CDM Admin fields

	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "QA_STATUS_CODE")
	private String qaStatus;

	@Column(name = "QABY")
	private String qaBy;

	@Column(name = "QADATE")
	private Date qaDate;

	@Column(name = "ENTEREDBY")
	private String enteredBy;

	@Column(name = "ENTRYDATE")
	private Date entryDate;

	// Related models
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "ENO")
	private MineralisedZone mineralisedZone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralResource")
	private List<ResourceGrade> resourceGrades;

	public List<ResourceGrade> getResourceGrades() {
		return resourceGrades;
	}

	public void setResourceGrades(List<ResourceGrade> resourceGrades) {
		this.resourceGrades = resourceGrades;
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

	public Unit getOreUnit() {
		return oreUnit;
	}

	public void setOreUnit(Unit oreUnit) {
		this.oreUnit = oreUnit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public MineralisedZone getMineralisedZone() {
		return mineralisedZone;
	}

	public void setMineralisedZone(MineralisedZone mineralisedZone) {
		this.mineralisedZone = mineralisedZone;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public String getQaStatus() {
		return qaStatus;
	}

	public String getQaBy() {
		return qaBy;
	}

	public Date getQaDate() {
		return qaDate;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public void setQaStatus(String qaStatus) {
		this.qaStatus = qaStatus;
	}

	public void setQaBy(String qaBy) {
		this.qaBy = qaBy;
	}

	public void setQaDate(Date qaDate) {
		this.qaDate = qaDate;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

}
