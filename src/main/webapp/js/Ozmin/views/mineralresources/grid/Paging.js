/**
 * This example demonstrates using a paging display.
 */
Ext.define('Ozmin.views.mineralresources.grid.Paging', {
    extend : 'Ext.grid.Panel',
    alias : 'widget.mineralresources',

    title : 'Mineral Resources',
    initComponent : function() {
        this.store = new Ozmin.store.MineralResources;
        this.columns = this._buildColumns();
        this.callParent();
    },

    _buildColumns : function() {
        return [ {
            text : 'Mineral Deposit',
            dataIndex : 'mineralisedZone.mineralDeposit.name',
            renderer : function (value,meta,record) {
                return '<a href="#!'+record.data.mineralisedZone.mineralDeposit.id+'">'+value+'</a>';
            }
        },{
            text : 'Mineralised Zone',
            dataIndex : 'mineralisedZoneName',
            renderer : function (value,meta,record) {
                return '<a href="#!'+record.data.mineralisedZone.id+'">'+value+'</a>';
            }
        }, {
            text : 'Resource number',
            dataIndex : 'id',
            sortable : true,
            renderer : function (value,meta,record) {
                return '<a href="#!'+record.data.id+'">'+value+'</a>';
            }

        },{
            text : 'Record Date',
            dataIndex : 'recordDate',
            sortable : true

        }, {
            text : 'Ore Units',
            dataIndex : 'oreUnit',
            sortable : true,
            flex : 1
        }, {
            text : 'Proven',
            dataIndex : 'proven'
        }, {
            text : 'Probable',
            dataIndex : 'probable'
        } ]

    },
    listeners: {
        cellclick: function(view, td, cellIndex, record, tr, rowIndex, e, eOpts) {
            var el = e.getTarget('a');
            if (el) {
                var href= el.getAttribute('href')
                
                Ext.Msg.alert('Selected Record', 'Name : ' + href.split('!')[0] + ' Bla: ' +href.split('!')[1]);
            }
           
        }
    },
});