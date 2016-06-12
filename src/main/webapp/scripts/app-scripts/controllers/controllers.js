'use strict';

var app = angular.module('thetaskApp.controllers', []);


app.run(function ($rootScope, $templateCache) {
  $rootScope.$on('$viewContentLoaded', function () {
    $templateCache.removeAll();
  });
});


app.controller('MusicianListCtrl', ['$scope', 'MusiciansFactory', 'MusicianFactory', '$location',
  function ($scope, MusiciansFactory, MusicianFactory, $location) {

    $scope.editMusician = function (musicianId) {
      $location.path('/musician-detail/' + musicianId);
    };

    $scope.deleteMusician = function (musicianId) {
      MusicianFactory.delete({ id: musicianId }).$promise.then(
	  function(value) {
		 $scope.musicians = MusiciansFactory.query(); 
	  });
    };

    $scope.createNewMusician = function () {
      $location.path('/musician-creation');
    };

    $scope.musicians = MusiciansFactory.query();
  }]);

app.controller('MusicianDetailCtrl', ['$scope', '$routeParams', 'MusicianFactory', '$location',
  function ($scope, $routeParams, MusicianFactory, $location) {

    $scope.updateMusician = function () {
      MusicianFactory.update($scope.musician).$promise.then(
	      function(value) {
		      $location.path('/musician-list');  
		  });
    };

    $scope.cancel = function () {
      $location.path('/musician-list');
    };

    $scope.musician = MusicianFactory.show({id: $routeParams.id});
  }]);

app.controller('MusicianCreationCtrl', ['$scope', 'MusiciansFactory', '$location',
  function ($scope, MusiciansFactory, $location) {

    $scope.createNewMusician = function () {
      MusiciansFactory.create($scope.musician).$promise.then(
	      function(value) {
		      $location.path('/musician-list');  
		  });
    }
  }]);