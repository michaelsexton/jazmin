/**
 * This example demonstrates using a paging display.
 */
Ext.define('Ozmin.views.mineraldeposit.grid.Paging', {
  extend : 'Ext.grid.Panel',
  alias : 'widget.mineraldeposits',
  
  title : 'Mineral Deposits',
  initComponent : function() {
    this.store = new Ozmin.store.MineralDeposits;
    this.columns = this._buildColumns();
    this.callParent();
  },

  height : 300,
  width : 600,

  _buildColumns : function() {
    return [ {
      text : 'ENO',
      dataIndex : 'id',
      sortable: true
          
    }, {
      text : 'Name',
      dataIndex : 'name',
      sortable: true,
      flex : 1
    }, {
      text : 'Operating Status',
      dataIndex : 'operatingStatus'
    }, {
      text : 'State',
      dataIndex : 'state'
    } ]

  }
});