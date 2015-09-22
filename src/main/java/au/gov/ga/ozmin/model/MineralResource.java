package au.gov.ga.ozmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="MGD",name="RESOURCES")
public class MineralResource {

	@Id
	@Column(name="RESOURCENO") 
	private Long id;
	
	@Column(name="RECORDDATE")
	private Date recordDate;

	@ManyToOne
	@JoinColumn(name = "UNIT_QUANTTY")
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
	private Double identified;

	@Column(name = "MID")
	private Double measuredAndIndicated;

	@Column(name = "IFR")
	private Double inferred;

	@Column(name = "OTHER")
	private Double other;

	@ManyToOne
	@JoinColumn(name = "ENO")
	private MineralisedZone mineralisedZone;

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

	public Double getIdentified() {
		return identified;
	}

	public void setIdentified(Double identified) {
		this.identified = identified;
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
}
