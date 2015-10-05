'use strict';

var services = angular.module('thetaskApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080/thetask';


services.factory('MusiciansFactory', function ($resource) {
    return $resource(baseUrl + '/api/musicians', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('MusicianFactory', function ($resource) {
    return $resource(baseUrl + '/api/musicians/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});