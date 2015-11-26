package au.gov.ga.ozmin.model;

import javax.persistence.Embeddable;

@Embeddable
public class GaClassification {
	
	public GaClassification() {
		
	};

	public GaClassification(String mainClassification, Double mainPercentage, String secondClassification,
			Double secondPercentage) {
		super();
		this.mainClassification = mainClassification;
		this.mainPercentage = mainPercentage;
		this.secondClassification = secondClassification;
		this.secondPercentage = secondPercentage;
	}

	public GaClassification(String mainClassification, Double mainPercentage) {
		super();
		this.mainClassification = mainClassification;
		this.mainPercentage = mainPercentage;
		this.secondClassification = null;
		this.secondPercentage = null;
	}

	private String mainClassification;
	private Double mainPercentage;

	private String secondClassification;
	private Double secondPercentage;

	public String getMainClassification() {
		return mainClassification;
	}

	public void setMainClassification(String mainClassification) {
		this.mainClassification = mainClassification;
	}

	public Double getMainPercentage() {
		return mainPercentage;
	}

	public void setMainPercentage(Double mainPercentage) {
		this.mainPercentage = mainPercentage;
	}

	public String getSecondClassification() {
		return secondClassification;
	}

	public void setSecondClassification(String secondClassification) {
		this.secondClassification = secondClassification;
	}

	public Double getSecondPercentage() {
		return secondPercentage;
	}

	public void setSecondPercentage(Double secondPercentage) {
		this.secondPercentage = secondPercentage;
	}

	@Override
	public String toString() {
		return "GaClassification [mainClassification=" + mainClassification + ", mainPercentage=" + mainPercentage
				+ ", secondClassification=" + secondClassification + ", secondPercentage=" + secondPercentage + "]";
	}
	
	

}
