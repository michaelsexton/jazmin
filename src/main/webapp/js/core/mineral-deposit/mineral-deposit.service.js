'use strict';

angular.module('core.mineralDeposit').factory('MineralDeposit',
		[ '$resource', function($resource) {
			return $resource('mineralDeposits.json', {}, {
				query : {
					method : 'GET',
					params : {
						operatingStatus: 'operating mine',
						state: 'WA'
					},
					isArray : true,
					transformResponse: function(data) {
						return angular.fromJson(data).content;
					}
				}
			});
		} ]);