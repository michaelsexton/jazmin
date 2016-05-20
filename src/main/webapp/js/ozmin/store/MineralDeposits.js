Ext.define('ozmin.store.MineralDeposits', {
    extend: 'Ext.data.Store',

    alias: 'store.mineraldeposits',
    model: 'ozmin.model.grid.MineralDeposit',

    pageSize: 50,
    remoteSort: true,
    sorters: [{
        property: 'lastpost',
        direction: 'DESC'
    }]
});