Ext.define('Ozmin.store.MineralResources', {
    extend : 'Ext.data.Store',

    storeId : 'mineralResourcesStore',
    model : 'Ozmin.models.grid.MineralResource',

    pageSize : 50,
    remoteSort : true,

    proxy : new Ext.data.proxy.Ajax({
        $configStrict: false,
        url : '/ozmin/mineralResources.json',
        reader : {
            type : 'json',
            rootProperty : 'content'
        },
        encodeSorters : function(sorters) {
            var length = sorters.length, sortStrs = [], sorter, i;

            for (i = 0; i < length; i++) {
                sorter = sorters[i];

                sortStrs[i] = sorter._property + ',' + sorter._direction
            }
            console.log(sortStrs.join(","));
            return sortStrs.join(",");
        }
    }),
    autoLoad : true
    
    
});