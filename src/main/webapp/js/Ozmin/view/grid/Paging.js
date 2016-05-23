/**
 * This example demonstrates using a paging display.
 */
Ext.create('Ext.grid.Panel', {
	title : 'Mineral Deposits',
	store : Ext.create('ozmin.store.MineralDeposits', {}),
	columns : [ {
		text : 'ENO',
		dataIndex : 'id'
	}, {
		text : 'Name',
		dataIndex : 'name',
		flex : 1
	}, {
		text : 'Operating Status',
		dataIndex : 'operatingStatus'
	}, {
		text : 'State',
		dataIndex : 'state'
	} ],
	height : 300,
	width : 600,
	renderTo : Ext.getBody()
});