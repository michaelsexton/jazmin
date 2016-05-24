/**
 * This example demonstrates using a paging display.
 */
Ext.define('Ozmin.views.grid.Paging', {
  extend : 'Ext.grid.Panel',
  title : 'Mineral Deposits',
  initComponent : function() {
    this.store = Ozmin.stores.MineralDeposits;
    this.columns = this._buildColumns();
    this.callParent();
  },

  height : 300,
  width : 600,

  _buildColumns : function() {
    return [ {
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
    } ]

  }
});