/**
 * This example demonstrates using a paging display.
 */
Ext.define('ozmin.view.grid.Paging',
        {
          extend : 'Ext.grid.Panel',

          requires : [ 'Ext.data.*', 'Ext.grid.*', 'Ext.util.*',
              'Ext.toolbar.Paging', 
              'ozmin.model.grid.MineralDeposit' ],
          xtype : 'paging-grid',

          height : 500,
          width : 750,
          frame : true,
          title : 'ExtJS.com - Browse Forums',
          disableSelection : true,
          loadMask : true,

          initComponent : function() {
            this.width = 760;

            var pluginExpanded = true;

            // create the Data Store
            var store = Ext.create('ozmin.store.MineralDeposits');

            Ext.apply(this, {
              store : store,
              
              viewConfig : {
                trackOver : false,
                stripeRows : false
              },
              // grid columns
              columns : [ {
                // id assigned so we can apply custom css (e.g.
                // .x-grid-cell-topic b { color:#333 })
                // TODO: This poses an issue in subclasses of Grid now because
                // Headers are now Components
                // therefore the id will be registered in the ComponentManager
                // and conflict. Need a way to
                // add additional CSS classes to the rendered cells.
                id : 'topic',
                text : "Topic",
                dataIndex : 'title',
                flex : 1,
                renderer : this.renderTopic,
                sortable : false
              }, {
                text : "Author",
                dataIndex : 'username',
                width : 100,
                hidden : true,
                sortable : true
              }, {
                text : "Replies",
                dataIndex : 'replycount',
                width : 70,
                align : 'right',
                sortable : true
              }, {
                id : 'last',
                text : "Last Post",
                dataIndex : 'lastpost',
                width : 150,
                renderer : this.renderLast,
                sortable : true
              } ],
              // paging bar on the bottom
              bbar : Ext.create('Ext.PagingToolbar', {
                store : store,
                displayInfo : true,
                displayMsg : 'Displaying topics {0} - {1} of {2}',
                emptyMsg : "No topics to display",
                items : []
              })
            });
            this.callParent();
          },

          afterRender : function() {
            this.callParent(arguments);
            this.getStore().loadPage(1);
          },

          renderTopic : function(value, p, model) {
            return Ext.String
                .format(
                    '<b><a href="http://sencha.com/forum/showthread.php?t={2}" target="_blank">{0}</a></b> <a href="http://sencha.com/forum/forumdisplay.php?f={3}" target="_blank">{1} Forum</a>',
                    value, model.get('forumtitle'), model.getId(), model
                        .get('forumid'));
          },

          renderLast : function(value, p, model) {
            return Ext.String.format('{0}<br/>by {1}', Ext.Date.dateFormat(
                value, 'M j, Y, g:i a'), model.get('lastposter'));
          }
        });