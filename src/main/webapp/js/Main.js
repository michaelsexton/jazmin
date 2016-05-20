Ext.Loader.setPath('ozmin', 'js/ozmin');
Ext.application({
  name : 'MineralDeposit',
  theme : "theme-triton",

  launch : function() {

    Ext.define('MineralDeposit', {
      extend : 'Ext.data.Model',
      fields : [ 'id', 'name', 'operatingStatus', 'state', 'synonyms' ],
    });

    Ext.create('Ext.data.Store', {
      storeId: 'mineralDepositsStore',
      model : 'MineralDeposit',
      proxy : {
        type : 'ajax',
        url : '/ozmin/mineralDeposits.json',
        reader : {
          type : 'json'
          //rootProperty : 'users'
        }
      },
      autoLoad : true
    });

    Ext.create('Ext.grid.Panel', {
      title : 'Mineral Deposits',
      store : Ext.data.StoreManager.lookup('mineralDepositsStore'),
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
  }
});