package au.gov.ga.ozmin.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import au.gov.ga.ozmin.resources.IdentifiedResource;
import au.gov.ga.ozmin.resources.IdentifiedResourceFactory;
import au.gov.ga.ozmin.resources.exceptions.IdentifiedResourceException;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;


@Entity
@Table(schema = "MGD", name = "RESOURCES")
public class MineralResource {

	@Id
	@Column(name = "RESOURCENO")
	private Long id;

	@Column(name = "RECORDDATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date recordDate;

	@ManyToOne
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
	@JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "UNIT_QUANTITY")
	private MineralUnit oreUnit;
	
	// TODO: Make a boolean or enum
	@Column(name = "INCLUSIVE")
    @Type(type="yes_no")
	private Boolean inclusive;

	@Column(name = "PVR")
	private BigDecimal proven;

	@Column(name = "PBR")
	private BigDecimal probable;

	@Column(name = "PPR")
	private BigDecimal provenAndProbable;

	@Column(name = "MRS")
	private BigDecimal measured;

	@Column(name = "IDR")
	private BigDecimal indicated;

	@Column(name = "MID")
	private BigDecimal measuredAndIndicated;

	@Column(name = "IFR")
	private BigDecimal inferred;

	@Column(name = "OTHER")
	private BigDecimal other;

	@Column(name = "QA_STATUS_CODE")
	private String qaStatus;

	@Column(name = "QABY")
	private String qaBy;

	@Column(name = "QADATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date qaDate;
	
	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "ENTEREDBY")
	private String enteredBy;

	@Column(name = "ENTRYDATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date entryDate;

	
	@Column(name = "LASTUPDATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date lastUpdate;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;
	
	@Column(name = "ACTIVITY_CODE")
	private String activityCode;

    @Transient
	private List<IdentifiedResource> identifiedResource = new ArrayList<> ();
	// Related models

    @PostLoad
    private void calculateIdentifiedResource() throws IdentifiedResourceException {
        for (ResourceGrade resourceGrade : resourceGrades) {
            identifiedResource.add(IdentifiedResourceFactory.generateIdentifiedResource(this, resourceGrade));
        }
    }

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mineralResource")
	@JsonIgnore
	private Set<ResourceGrade> resourceGrades;
	
	@ManyToOne
	/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)*/
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "ENO")
	private MineralisedZone mineralisedZone;

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

	public BigDecimal getIndicated() {
		return indicated;
	}

	public BigDecimal getInferred() {
		return inferred;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public BigDecimal getMeasured() {
		return measured;
	}

	public BigDecimal getMeasuredAndIndicated() {
		return measuredAndIndicated;
	}

	public MineralisedZone getMineralisedZone() {
		return mineralisedZone;
	}

	public MineralUnit getOreUnit() {
		return oreUnit;
	}

	public BigDecimal getOther() {
		return other;
	}

	public BigDecimal getProbable() {
		return probable;
	}

	public BigDecimal getProven() {
		return proven;
	}

	public BigDecimal getProvenAndProbable() {
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

	public void setIndicated(BigDecimal indicated) {
		this.indicated = indicated;
	}

	public void setInferred(BigDecimal inferred) {
		this.inferred = inferred;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setMeasured(BigDecimal measured) {
		this.measured = measured;
	}

	public void setMeasuredAndIndicated(BigDecimal measuredAndIndicated) {
		this.measuredAndIndicated = measuredAndIndicated;
	}

	public void setMineralisedZone(MineralisedZone mineralisedZone) {
		this.mineralisedZone = mineralisedZone;
	}

	public void setOreUnit(MineralUnit oreUnit) {
		this.oreUnit = oreUnit;
	}

	public void setOther(BigDecimal other) {
		this.other = other;
	}

	public void setProbable(BigDecimal probable) {
		this.probable = probable;
	}

	public void setProven(BigDecimal proven) {
		this.proven = proven;
	}

	public void setProvenAndProbable(BigDecimal provenAndProbable) {
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

	public List<IdentifiedResource> getIdentifiedResource(){
	    return identifiedResource;
    }

    public Boolean getInclusive() {
        return inclusive;
    }

    public void setInclusive(Boolean inclusive) {
        this.inclusive = inclusive;
    }
}
