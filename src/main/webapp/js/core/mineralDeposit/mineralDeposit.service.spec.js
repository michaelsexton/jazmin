'use strict';

describe('MineralDeposit', function() {
  var $httpBackend;
  var MineralDeposit;
  var mineralDepositsData = [
    {name: 'MineralDeposit X'},
    {name: 'MineralDeposit Y'},
    {name: 'MineralDeposit Z'}
  ];

  // Add a custom equality tester before each test
  beforeEach(function() {
    jasmine.addCustomEqualityTester(angular.equals);
  });

  // Load the module that contains the `Phone` service before each test
  beforeEach(module('core.mineralDeposit'));

  // Instantiate the service and "train" `$httpBackend` before each test
  beforeEach(inject(function(_$httpBackend_, _MineralDeposit_) {
    $httpBackend = _$httpBackend_;
    $httpBackend.expectGET('mineralDeposits.json').respond(mineralDepositsData);

    Phone = _Phone_;
  }));

  // Verify that there are no outstanding expectations or requests after each test
  afterEach(function () {
    $httpBackend.verifyNoOutstandingExpectation();
    $httpBackend.verifyNoOutstandingRequest();
  });

  it('should fetch the phones data from `/phones/phones.json`', function() {
    var mineralDeposits = MineralDeposit.query();

    expect(mineralDeposits).toEqual([]);

    $httpBackend.flush();
    expect(mineralDeposits).toEqual(mineralDepositsData);
  });

});
