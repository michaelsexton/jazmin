Ext.define('Ozmin.store.MineralDeposits', {
  extend: 'Ext.data.Store',
	storeId : 'mineralDepositsStore',
	model : 'Ozmin.models.grid.MineralDeposit',
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