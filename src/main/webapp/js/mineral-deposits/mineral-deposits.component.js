angular.
  module('mineralDeposits').
  component('mineralDeposits', {
	templateUrl: 'js/mineral-deposits/mineral-deposits.template.html',
    controller: function MineralDepositsController($http) {
    	var self = this;
   
    	$http.get('mineralDeposits.json').then(function(response) {
    		self.deposits = response.data.content;
    	});
    }
  });