angular.module('ozminApp').config(['$locationProvider', '$routeProvider',
                                   function config($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix('!');
	$routeProvider.when('/mineralDeposits',{
		template: '<mineral-deposits></mineral-deposits>'
	}).when('/mineralDeposits/:id', {
		template: '<mineral-deposit></mineral-deposit>'
	} ).when('/mineralResources', {
		template: '<mineral-resources></mineral-resources>'
	}).when('/mineralProjects', {
		template: '<mineral-projects></mineral-projects>'
	}).when('/references', {
		template: '<references></references>'
	}).otherwise('/mineralDeposits');
}])