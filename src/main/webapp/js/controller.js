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
        $http.get('webapi/devices').success(function (data) {
            $scope.devices = data;
        });
        $scope.popup = $(document).ready(function () {
            $('modal1').show();
        });

//        $(document).ready(function () {
//            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
//            $('.modal-trigger').leanModal();
//        });
        $('.modal-trigger').leanModal({
            dismissible: true, // Modal can be dismissed by clicking outside of the modal
            opacity: .5, // Opacity of modal background
            in_duration: 300, // Transition in duration
            out_duration: 200, // Transition out duration
            ready: function () {
                alert('Ready');
            }, // Callback for Modal open
            complete: function () {
                alert('Closed');
            } // Callback for Modal close
        }
        );


        $('#modal1').closeModal();


    }]);

homeCtrls.controller('detailsCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        $http.get('webapi/devices').success(function (data) {
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
        
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });

    }]);

homeCtrls.controller('requestCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.some = "Request a device";
        $scope.SendData = function () {
            // use $.param jQuery function to serialize data from JSON 
            var data = JSON.stringify({
                device_name: request.device_name,
                type: request.type,
                platform: request.platform,
                OS: request.OS,
                priority: request.priority,
                size: request.size,
                resolution: request.resolution,
                location: request.location,
                SPA: request.SPA,
                project: request.project,
                URL: request.URL,
                userName: request.userName,
                comment: request.comment

            });

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            $http.post('webapi/request', data, config)
                    .success(function (data, status, headers, config) {
                        $scope.PostDataResponse = data;
                    })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                                "<hr />status: " + status +
                                "<hr />headers: " + header +
                                "<hr />config: " + config;
                    });
        };
        $scope.sendPost = function () {
            $http.post('webapi/request', request, {headers: {'Content-Type': 'application/json'}})
                    .success(function (response) {
                        $scope.PostDataResponse = response;
                    });
        };

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

        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });
    }]);

homeCtrls.controller('thumbnailCtrl', ['$scope', function ($scope) {
        $scope.some = "This is thumbnail page";

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

homeCtrls.controller('edit_modeCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        $http.get('js/data.json').success(function (data) {
            $scope.edit = data;
            $scope.edit_item = $routeParams.itemId;
        });
        $scope.some = "Requsted Devices";
    }]);
