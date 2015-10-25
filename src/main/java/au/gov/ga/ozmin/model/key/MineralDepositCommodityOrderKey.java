package au.gov.ga.ozmin.model.key;

import java.io.Serializable;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import au.gov.ga.ozmin.model.Commodity;
import au.gov.ga.ozmin.model.MineralDeposit;

@Embeddable
public class MineralDepositCommodityOrderKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="ENO")
	private MineralDeposit mineralDeposit;
	
	@ManyToOne
	@JoinColumn(name="COMMODID")
	private Commodity commodity;
	
	
	public MineralDeposit getMineralDeposit() {
		return mineralDeposit;
	}

	public void setMineralDeposit(MineralDeposit deposit) {
		this.mineralDeposit = deposit;
	}
	
	
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	
	
}
