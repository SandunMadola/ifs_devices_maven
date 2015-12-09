var homeCtrls = angular.module('homeCtrls', []);

homeCtrls.controller('staticCtrl', ['$scope', function ($scope) {
        $scope.searching = "Type Here";
        $scope.search_bar = true;
        $scope.searched = function () {
            $scope.search_bar = !$scope.search_bar;
        };
    }]);

homeCtrls.controller('homeCtrl', ['$scope', function ($scope) {

    }]);

homeCtrls.controller('deviceCtrl', ['$scope', '$http', function ($scope, $http) {
        $http.get('js/data.json').success(function (data) {
            $scope.devices = data;
        });
        $scope.popup = $(document).ready(function () {
            $('modal1').show();
        });

        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });

    }]);

homeCtrls.controller('detailsCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        $http.get('js/data.json').success(function (data) {
            $scope.devices = data;
            $scope.whichItem = $routeParams.itemId;
        });
        $scope.mo = true;
        $scope.popup = function () {
            if ($scope.mo == false) {
                $scope.mo = true;
            } else {
                $scope.mo = false;
            }
        };

        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });


    }]);

homeCtrls.controller('requestCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.some = "Request a device";
        $scope.update = angular.copy.request;
//        $scope.update = angular.copy.later;

        $(document).ready(function () {
            $('select').material_select();
        });
        $(document).ready(function () {
            $('input#input_text,input#un,input#un2,input#icon_prefix, textarea#textarea1').characterCounter();
        });
        $(document).ready(function () {
            $('.collapsible').collapsible({
                accordion: false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
            });
        });
        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });

    }]);
homeCtrls.controller('settingsCtrl', ['$scope', '$http', function ($scope, $http) {
//        $http.get('js/data.json').success(function (data) {
//            $scope.devices = data;
//        });
        $http.get('webapi/employee').success(function (data) {
            $scope.employee = data;            
        });
        $scope.some = "Requsted Devices";
        $(document).ready(function () {
            $('ul.tabs').tabs();
        })
    }]);

homeCtrls.controller('thumbnailCtrl', ['$scope', function ($scope) {
        $scope.some = "This is thumbnail page";
    }]);

homeCtrls.controller('edit_modeCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        $http.get('js/data.json').success(function (data) {
            $scope.edit = data;
            $scope.edit_item = $routeParams.itemId;
        });
        $scope.some = "Requsted Devices";
    }]);