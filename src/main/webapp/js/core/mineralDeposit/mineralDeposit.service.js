'use strict';

angular.module('core.mineralDeposit').factory('MineralDeposit',
		[ '$resource', function($resource) {
			return $resource('mineralDeposits.json', {}, {
				query : {
					method : 'GET',
				/*	params : {
						mineralDepositId : 'mineralDeposits'
					},*/
					isArray : true
				}
			});
		} ]);