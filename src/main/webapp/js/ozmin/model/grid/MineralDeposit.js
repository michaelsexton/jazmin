Ext.define('ozmin.model.grid.MineralDeposit', {
    extend: 'ozmin.model.Base',
    fields: [
        'id', 'name', 'operatingStatus', 'state','synonyms'
    ],
    idProperty: 'threadid',
    proxy: {
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        type: 'jsonp',
        url: '/ozmin/mineralDeposits.json',
        reader: {
            rootProperty: 'topics',
            totalProperty: 'totalCount'
        },
        // sends single sort as multi parameter
        simpleSortMode: true
    }
});