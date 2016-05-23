/**
 * This class is the main view for the application. It is specified in app.js as
 * the "autoCreateViewport" property. That setting automatically applies the
 * "viewport" plugin to promote that instance of this class to the body element.
 */
Ext.define('ozmin.view.main.Main', {
	extend : 'Ext.tab.Panel',
	xtype : 'app-main',

	requires : [ 'ozmin.view.*' ],



	tabBarHeaderPosition : 1,
	titleRotation : 0,
	tabRotation : 0,

	header : {
		layout : {
			align : 'stretchmax'
		},
		iconCls : 'exec-header-icon',
		title : {
			text : 'OZMIN',
			textAlign : 'center',
			flex : 0,
			minWidth : 160
		},
		tools : [ {
			type : 'gear',
			plugins : 'responsive',
			width : 120,
			margin : '0 0 0 0',
			handler : 'onSwitchTool'
		} ]
	},

	tabBar : {
		flex : 1,
		layout : {
			align : 'stretch',
			overflowHandler : 'none'
		}
	},

	responsiveConfig : {
		tall : {
			headerPosition : 'top'
		},
		wide : {
			headerPosition : 'left'
		}
	},

	listeners : {
		tabchange : 'onTabChange'
	},

	defaults : {
		tabConfig : {

		}

	},

	items : [ {
		// This page has a hidden tab so we can only get here during
		// initialization. This
		// allows us to avoid rendering an initial activeTab only to change it
		// immediately
		// by routing
		xtype : 'component',
		tabConfig : {
			hidden : true
		}
	}, {
		//xtype : 'mineral-deposits',
		title : 'Mineral Deposits',
		iconCls : 'exec-kpi-icon'
	}, {
		//xtype : 'mineral-resources',
		title : 'Mineral Resources',
		iconCls : 'exec-quarterly-icon'
	}, {
		//xtype : 'provicnes',
		title : 'Provinces',
		iconCls : 'exec-pl-icon'
	}, {
		//xtype : 'surveys',
		title : 'Surveys',
		iconCls : 'exec-news-icon'
	} ],

	// This object is a config for the popup menu we present on very small form
	// factors.
	// It is used by our controller (MainController).
	assistiveMenu : {
		items : [ {
			text : 'KPI Overview',
			height : 50,
			iconCls : 'exec-kpi-icon'
		}, {
			text : 'Performance',
			height : 50,
			iconCls : 'exec-quarterly-icon'
		}, {
			text : 'Profit & Loss',
			height : 50,
			iconCls : 'exec-pl-icon'
		}, {
			text : 'Company News',
			height : 50,
			iconCls : 'exec-news-icon'
		} ],
		listeners : {
			click : 'onMenuClick'
		}
	}
});