Ext.define('Ozmin.app.Application', {
  extend : 'Ext.app.Application',

  
  appFolder : '/ozmin/js/Ozmin',
  name : 'Ozmin',

  // defaultToken '!deposits', // '!kpi/clicks'

  views : [ 'Ozmin.views.main.Main' ],

  launch : function() {
    
    // Let's add a CSS class to body if flex box wrap is not implemented or
    // broken
    // http://flexboxlayouts.com/flexboxlayout_tricks.html
    if (Ext.browser.is.Gecko && Ext.browser.version.major < 28) {
      Ext.getBody().addCls('x-flex-wrap-broken');
    }
  }
})
