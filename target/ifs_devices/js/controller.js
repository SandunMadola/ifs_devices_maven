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

//        $scope.mo = true;
//        $scope.popup = function () {
//            if ($scope.mo == false) {
//                $scope.mo = true;
//            } else {
//                $scope.mo = false;
//            }
//        };

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
        $scope.SendData = function (request) {
            var data = {
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
                request_Status: "New",
                URL: request.URL,
                userName: request.userName,
                comment: request.comment
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
            var res = $http.post('webapi/request', data, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $scope.msg = "Request Sent Successfully !!!";
                $scope.waitt = "modal1";
                $(".call_to_modal").click();

            });
            res.error(function (data, status, headers, config) {
                $scope.msg = "Request Unsuccessful ...";
                $scope.waitt = "modal1";
                alert("failure message: " + JSON.stringify({data: data}));
                $(".call_to_modal").click();
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
homeCtrls.controller('requestedCtrl', ['$scope', '$http', function ($scope, $http) {

        $http.get('webapi/request').success(function (data) {
            $scope.request = data;
        });
        $scope.some = "Requsted Devices";
        $(document).ready(function () {
            $('ul.tabs').tabs();
        });

        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });
        $scope.collapsibleElements = [{
                icon: 'mdi-image-filter-drama',
                title: 'First',
                content: 'Sandun Madola'
            }, {
                icon: 'mdi-maps-place',
                title: 'Second',
                content: 'Lorem ipsum dolor sit amet.'
            }, {
                icon: 'mdi-social-whatshot',
                title: 'Third',
                content: 'Lorem ipsum dolor sit amet.'
            }
        ];
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
