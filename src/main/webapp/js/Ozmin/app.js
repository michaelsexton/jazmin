Ext.Loader.setPath('Ozmin', 'js/Ozmin');

Ext.application({
  name : 'Ozmin',

  appFolder : '/ozmin/js/Ozmin',

  extend : 'Ozmin.app.Application',

  theme : "theme-triton",
  autoCreateViewport : 'Ozmin.views.main.Main',

  requires : [ 'Ozmin.*' ],

  stores: ['MineralDeposits','MineralResources']
});