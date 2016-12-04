function parseGeometry(geometry) {
	return this.geometry.coordinates[0];
}

angular.
  module('mineralDeposits').
  component('mineralDeposits', {
	templateUrl: 'js/mineral-deposits/mineral-deposits.template.html',
    controller: ['$scope','MineralDeposit', function MineralDepositsController($scope,MineralDeposit) {
    	var self = this;

    	var deposits = MineralDeposit.query(function() {
    		var i = 0
    	});
    	
    	data = MineralDeposit.query()
    	
    	this.mineralDepositList = { columnDefs : [
    			             { name: 'name', enableFiltering: false },
    			             { name: 'state' },
    			             { name: 'longitude', field: 'geometry.getX()', enableSorting: false},
    			             { name: 'latitude', field: 'geometry.coordinates[1]', enableSorting: false},
    			             { name: 'operatingStatus', enableFiltering: false}
    			           ],
    			           data : data
    	}
    	
    	
    }]
  });

