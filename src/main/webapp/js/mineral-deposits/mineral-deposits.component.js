angular.
  module('mineralDeposits').
  component('mineralDeposits', {
	templateUrl: 'js/mineral-deposits/mineral-deposits.template.html',
    controller: function MineralDepositsController($scope,$http) {
    	var self = this;
   
    	$scope.mineralDepositList ={
    			columnDefs: [
    			             { name: 'name', enableFiltering: false },
    			             { name: 'state' },
    			             { name: 'operatingStatus', enableFiltering: false}
    			           ]
    	}
    	
    	$http.get('mineralDeposits.json?operatingStatus=&state=NSW').then(function(response) {
    		$scope.mineralDepositList.data = response.data.content;
    	});
    }
  });