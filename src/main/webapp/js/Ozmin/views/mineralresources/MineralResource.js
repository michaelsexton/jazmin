Ext.define('Ozmin.views.mineralresources.MineralResource', {
    extend : 'Ext.panel.Panel',
    alias : 'widget.mineralresource',

    requires : [ 'Ozmin.views.mineralresources.grid.Paging' ],

    config : {
        activeState : null,
        defaultActiveState : 'clicks'
    },

    items : [ {
        xtype : 'mineralresources'
    }, {
        
    } ]
})