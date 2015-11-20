package au.gov.ga.ozmin.model;

import java.util.Date;
import java.util.Set;

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
	
	// TODO: Make a boolean or enum
	@Column(name = "INCLUSIVE")
	private String inclusive;

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

	

	@Column(name = "QA_STATUS_CODE")
	private String qaStatus;

	@Column(name = "QABY")
	private String qaBy;

	@Column(name = "QADATE")
	private Date qaDate;
	
	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "ENTEREDBY")
	private String enteredBy;

	@Column(name = "ENTRYDATE")
	private Date entryDate;

	
	@Column(name = "LASTUPDATE")
	private Date lastUpdate;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;
	
	@Column(name = "ACTIVITY_CODE")
	private String activityCode;
	
	// Related models
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "ENO")
	private MineralisedZone mineralisedZone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mineralResource")
	private Set<ResourceGrade> resourceGrades;

	public String getAccessCode() {
		return accessCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public Long getId() {
		return id;
	}

	public Double getIndicated() {
		return indicated;
	}

	public Double getInferred() {
		return inferred;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public Double getMeasured() {
		return measured;
	}

	public Double getMeasuredAndIndicated() {
		return measuredAndIndicated;
	}

	public MineralisedZone getMineralisedZone() {
		return mineralisedZone;
	}

	public Unit getOreUnit() {
		return oreUnit;
	}

	public Double getOther() {
		return other;
	}

	public Double getProbable() {
		return probable;
	}

	public Double getProven() {
		return proven;
	}

	public Double getProvenAndProbable() {
		return provenAndProbable;
	}

	public String getQaBy() {
		return qaBy;
	}

	public Date getQaDate() {
		return qaDate;
	}

	public String getQaStatus() {
		return qaStatus;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public Set<ResourceGrade> getResourceGrades() {
		return resourceGrades;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIndicated(Double indicated) {
		this.indicated = indicated;
	}

	public void setInferred(Double inferred) {
		this.inferred = inferred;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setMeasured(Double measured) {
		this.measured = measured;
	}

	public void setMeasuredAndIndicated(Double measuredAndIndicated) {
		this.measuredAndIndicated = measuredAndIndicated;
	}

	public void setMineralisedZone(MineralisedZone mineralisedZone) {
		this.mineralisedZone = mineralisedZone;
	}

	public void setOreUnit(Unit oreUnit) {
		this.oreUnit = oreUnit;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	public void setProbable(Double probable) {
		this.probable = probable;
	}

	public void setProven(Double proven) {
		this.proven = proven;
	}

	public void setProvenAndProbable(Double provenAndProbable) {
		this.provenAndProbable = provenAndProbable;
	}

	public void setQaBy(String qaBy) {
		this.qaBy = qaBy;
	}

	public void setQaDate(Date qaDate) {
		this.qaDate = qaDate;
	}

	public void setQaStatus(String qaStatus) {
		this.qaStatus = qaStatus;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public void setResourceGrades(Set<ResourceGrade> resourceGrades) {
		this.resourceGrades = resourceGrades;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
}
