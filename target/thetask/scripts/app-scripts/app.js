'use strict';

angular.module('thetaskApp', [
  'thetaskApp.services',
  'thetaskApp.controllers',
  'ngRoute'
  ])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/musician-list', {templateUrl: 'views/musician-list.html', controller: 'MusicianListCtrl'});
  $routeProvider.when('/musician-detail/:id', {templateUrl: 'views/musician-detail.html', controller: 'MusicianDetailCtrl'});
  $routeProvider.when('/musician-creation', {templateUrl: 'views/musician-creation.html', controller: 'MusicianCreationCtrl'});
  $routeProvider.otherwise({redirectTo: '/musician-list'});

  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});