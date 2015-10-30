package au.gov.ga.ozmin.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import au.gov.ga.ozmin.model.key.MineralDepositCommodityOrderKey;

@Entity
@Table(schema = "MGD", name="COMMODS")
@AssociationOverrides({
	@AssociationOverride(name="id.mineralDeposit",
			joinColumns=@JoinColumn(name="ENO")),
	@AssociationOverride(name="id.commodity",
		joinColumns=@JoinColumn(name="COMMODID"))
	
})
public class MineralDepositCommodityOrder {

	@EmbeddedId
	private MineralDepositCommodityOrderKey id = new MineralDepositCommodityOrderKey();
	
	@Column(name="COMMORDER")
	private Integer commodityOrder;
	
	
	public MineralDepositCommodityOrderKey getId() {
		return id;
	}

	public void setId(MineralDepositCommodityOrderKey id) {
		this.id = id;
	}

	public Integer getCommodityOrder() {
		return commodityOrder;
	}

	public void setCommodityOrder(Integer commodityOrder) {
		this.commodityOrder = commodityOrder;
	}
	
	@Transient
	public MineralDeposit getMineralDeposit() {
		return getId().getMineralDeposit();
	}
	
	public void setMineralDeposit(MineralDeposit mineralDeposit) {
		getId().setMineralDeposit(mineralDeposit);
	}
	
	@Transient
	public Commodity getCommodity() {
		return getId().getCommodity();
	}
	
	public void setCommodity(Commodity commodity) {
		getId().setCommodity(commodity);
	}
}
