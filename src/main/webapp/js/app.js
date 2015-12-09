var app = angular.module('app', ['ngRoute', 'homeCtrls']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
                when('/home', {
                    templateUrl: 'dynamic/home.html',
                    controller: 'homeCtrl'
                }).
                when('/devices', {
                    templateUrl: 'dynamic/devices.html',
                    controller: 'deviceCtrl'
                }).
                when('/thumbnail', {
                    templateUrl: 'dynamic/thumbnail.html',
                    controller: 'thumbnailCtrl'
                }).
                when('/details/:itemId', {
                    templateUrl: 'dynamic/details.html',
                    controller: 'detailsCtrl'
                }).
                when('/details/:itemId/edit_mode', {
                    templateUrl: 'dynamic/edit_mode.html',
                    controller: 'edit_modeCtrl'
                }).                        
                when('/request', {
                    templateUrl: 'dynamic/request.html',
                    controller: 'requestCtrl'
                }).
                when('/settings', {
                    templateUrl: 'dynamic/settings.html',
                    controller: 'settingsCtrl'
                }).                        
                otherwise({
                    redirectTo: '/home'
                });
    }]);

