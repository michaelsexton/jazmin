Ext.Loader.setPath('Ozmin', 'js/Ozmin');
Ext.application({
	name : 'ozmin',
	theme : "theme-triton",
	autoCreateViewport : 'Ozmin.view.main.Main',
	views : [ 'Ozmin.view.main.Main' ],

	launch : function() {
		// Let's add a CSS class to body if flex box wrap is not implemented or
		// broken
		// http://flexboxlayouts.com/flexboxlayout_tricks.html
		/*if (Ext.browser.is.Gecko && Ext.browser.version.major < 28) {
			Ext.getBody().addCls('x-flex-wrap-broken');
		}*/
	}
});