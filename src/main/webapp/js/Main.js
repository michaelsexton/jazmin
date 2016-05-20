Ext.Loader.setPath('ozmin', 'js/ozmin');
Ext.application({
	name : 'Ozmin',
	theme : "theme-triton",
	autoCreateViewport : 'ozmin.view.main.Main',
	views : [ 'ozmin.view.main.Main' ],

	launch : function() {
		// Let's add a CSS class to body if flex box wrap is not implemented or
		// broken
		// http://flexboxlayouts.com/flexboxlayout_tricks.html
		if (Ext.browser.is.Gecko && Ext.browser.version.major < 28) {
			Ext.getBody().addCls('x-flex-wrap-broken');
		}
	}
});