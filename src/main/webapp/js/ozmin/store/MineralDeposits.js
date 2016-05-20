Ext.define('ozmin.store.MineralDeposits', {
	storeId : 'mineralDepositsStore',
	model : 'ozmim.mdel.grid.MineralDeposit',
	proxy : {
		type : 'ajax',
		url : '/ozmin/mineralDeposits.json',
		reader : {
			type : 'json'
		// rootProperty : 'users'
		}
	},
	autoLoad : true
});