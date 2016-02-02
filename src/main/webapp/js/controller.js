var homeCtrls = angular.module('homeCtrls', []);

homeCtrls.factory('shareVariable', function () {
    var data = {Filter_By: ''};

    return {
        getFilter_By: function () {
            return data.Filter_By;
        },
        setFilter_By: function (Filter_value) {
            data.Filter_By = Filter_value;
        }
    };
});

homeCtrls.controller('staticCtrl', ['$scope', 'shareVariable', '$http', function ($scope, shareVariable, $http) {
       
        $http.get('Fixed_Json/type.json').success(function (data) {
            $scope.typ = data;
        });
        $http.get('Fixed_Json/platform.json').success(function (data) {
            $scope.plt = data;
        });

        $scope.filter_bar = function (value) {
            $scope.Filter_value = value;
        };

        $scope.$watch('Filter_value', function (newValue, oldValue) {
            if (newValue !== oldValue)
                shareVariable.setFilter_By(newValue);
        });
        $scope.searching = "Search for devices";
        $scope.search_bar = true;
        $scope.searched = function () {
            $scope.search_bar = !$scope.search_bar;
        };
        $('#wait_moment').fadeOut('slow');
    }]);

homeCtrls.controller('homeCtrl', ['$scope', function ($scope) {

    }]);

homeCtrls.controller('searchCtrl', ['$scope', function ($scope) {
        $http.get('webapi/search').success(function (data) {
            $scope.devices = data;
        });
    }]);

homeCtrls.controller('deviceCtrl', ['$scope', 'shareVariable', '$http', function ($scope, shareVariable, $http) {

        $scope.$watch(function () {
            return shareVariable.getFilter_By();
        }, function (newValue, oldValue) {
            if (newValue !== oldValue)
                $scope.custom_filter2 = newValue;
        });

        $http.get('webapi/devices').success(function (data) {
            $scope.devices = data;
            $('#wait_moment').fadeOut('slow');
        });

        $scope.popup = $(document).ready(function () {
            $('modal1').show();
        });

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
//            $('later_call').click();

        });

        $(document).ready(function () {
            $('.collapsible').collapsible({
                accordion: false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
            });
        });

        $scope.date = new Date();
//          alert($scope.date);


        $scope.SendData = function (now) {

            $scope.n = parseInt(now.to);
//            alert($scope.n);
            $scope.toDate = (new Date((new Date()).setDate((new Date()).getDate() + $scope.n)));
//            alert( $scope.toDate.getFullYear()+'-'+ $scope.toDate.getMonth()+'-'+ $scope.toDate.getDate());
            $scope.y = $scope.toDate.getFullYear();
            $scope.m = $scope.toDate.getMonth() + 1;
            $scope.d = $scope.toDate.getDate();

            var Nowdata = {
                transaction_Mode: "unavailable",
                color: "red",
                transaction_Type: "return",
                username: now.userName,
                device_ID: $("#getdeviceID").text(),
                from_Date: $("#todaydate").text(),
                to_Date: $scope.y + '-' + $scope.m + '-' + $scope.d
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var res = $http.post('webapi/borrowNow', Nowdata, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $scope.msg = "Device is successfully borrowed";
                $(".call_to_modal").click();

            });
            res.error(function (data, status, headers, config) {
                $scope.msg = "Request Unsuccessful";
                alert("failure message: " + JSON.stringify({data: data}));
                $(".call_to_modal").click();
            });

        };

        $('.datepicker').pickadate({
            format: 'yyyy-mm-dd',
            formatSubmit: 'yyyy/mm/dd'
        });

        $scope.SendData2 = function (later) {


            $scope.l = parseInt(later.to);
            $scope.lt = new Date(new Date().setDate((new Date(later.from)).getDate() + $scope.l));

            $scope.yy = $scope.lt.getFullYear();
            $scope.mm = $scope.lt.getMonth() + 1;
            $scope.dd = $scope.lt.getDate();

            var Laterdata = {
                transaction_Mode: "booked",
                color: "orange",
                transaction_Type: "cancel",
                username: later.userName,
                device_ID: $("#getdeviceID").text(),
                from_Date: later.from,
                to_Date: $scope.yy + '-' + ($scope.mm + 1) + '-' + $scope.dd
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var res = $http.post('webapi/borrowNow', Laterdata, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $scope.msg = "Device is booked successfully";
                $(".call_to_modal").click();

            });
            res.error(function (data, status, headers, config) {
                $scope.msg = "Book device later request unsuccessful";
                alert("failure message: " + JSON.stringify({data: data}));
                $(".call_to_modal").click();
            });


        };

        $scope.ShowBooked = function () {
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            $scope.deviceID = $("#getdeviceID").text();
            var yy = 'webapi/bookedDates/"' + $("#getdeviceID").text() + '"'; ///webapi/bookedDates/"D002"
            var res = $http.get(yy, config).success
                    (function (data) {

                        $scope.booked = data;
                    });
        };

        $scope.SendData3 = function (returnDevice) {

            $scope.username = $("#getun").text();
            $scope.transactionID = $("#getTransID").text();

            if (returnDevice.userName == $scope.username) {
//                $scope.msg = "Request granted!";
//                $(".call_to_modal").click();
                var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };
                var xx = 'webapi/return/' + $scope.transactionID;
                var res = $http.delete(xx, config);
                res.success(function (data, status, headers, config) {

                    $scope.msg = "Device is successfully returned";
                    $(".call_to_modal").click();

                });
                res.error(function (data, status, headers, config) {
                    $scope.msg = "Return device request Unsuccessful";
//                alert("failure message: " + JSON.stringify({data: data}));
                    $(".call_to_modal").click();
                });
            } else {
                $scope.msg = "Incorrect Username! Return request cannot be granted";
                $(".call_to_modal").click();
            }
        };

        $scope.SendData4 = function (cancel) {

            $scope.username = $("#getun").text();
            $scope.transactionID = $("#getTransID").text();

            if (cancel.userName == $scope.username) {
//                $scope.msg = "Request granted!";
//                $(".call_to_modal").click();
                var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };
                var x = 'webapi/cancel/' + $scope.transactionID;
                var res = $http.delete(x, config);
                res.success(function (data, status, headers, config) {

                    $scope.msg = "Device booking is cancelled";
                    $(".call_to_modal").click();

                });
                res.error(function (data, status, headers, config) {
                    $scope.msg = "Cancelling a booking unsuccessful";
//                alert("failure message: " + JSON.stringify({data: data}));
                    $(".call_to_modal").click();
                });
            } else {
                $scope.msg = "Incorrect Username! Cancel request cannot be granted";
                $(".call_to_modal").click();
            }
        };

        $scope.SendData5 = function (get) {

            $scope.username = $("#getun").text();
            $scope.transactionID = $("#getTransID").text();
            $scope.color = $("#getcolor").text();

            if (get.userName == $scope.username && $scope.color == 'orange') {
//                $scope.msg = "Request granted!";
//                $(".call_to_modal").click();
                var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                };
                var xx = 'webapi/get/' + $scope.transactionID;
                var res = $http.put(xx, config);
                res.success(function (data, status, headers, config) {

                    $scope.msg = "This device is successfully taken now";
                    $(".call_to_modal").click();

                });
                res.error(function (data, status, headers, config) {
                    $scope.msg = "Get now request unsuccessful";
//                alert("failure message: " + JSON.stringify({data: data}));
                    $(".call_to_modal").click();
                });
            } else {
                $scope.msg = "Incorrect username! Get Now request cannot be granted";
                $(".call_to_modal").click();
            }
        };

        $(document).ready(function () {
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
        });

        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15// Creates a dropdown of 15 years to control year
        });

    }]);

homeCtrls.controller('requestCtrl', ['$scope', '$http', function ($scope, $http) {
        $('#wait_moment').fadeOut('slow');
        $http.get('Fixed_Json/location.json').success(function (data) {
            $scope.loc = data;
        });
        $http.get('Fixed_Json/type.json').success(function (data) {
            $scope.typ = data;
        });
        $http.get('Fixed_Json/platform.json').success(function (data) {
            $scope.plt = data;
        });
        $http.get('Fixed_Json/priority.json').success(function (data) {
            $scope.pri = data;
        });

        $scope.some = "Request a device";
        $scope.date = new Date();
        $scope.SendData = function (request) {
            $('#wait_moment').fadeIn('slow');

            var data = {
                device_name: request.device_name,
                type: request.type,
                platform: request.platform,
                OS: request.OS,
                priority: request.priority,
                size: request.size,
                resolution: request.resolution,
                location: request.location,
                PA: request.PA,
                SPA: request.SPA,
                project: request.project,
                request_Status: "Requested",
                URL: request.URL,
                userName: request.userName,
                comment: request.comment,
                date: $("#getdate").text()
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var res = $http.post('webapi/request', data, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $('#wait_moment').fadeOut('slow');
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Request Successfully !!!', 2000));
            });
            res.error(function (data, status, headers, config) {
                $('#wait_moment').fadeOut('slow');
                alert("failure message: " + JSON.stringify({data: data}));
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Error, Try again...', 2000));
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
        $scope.changed = 'Not';
        $scope.www = false;
        $http.get('Fixed_Json/location.json').success(function (data) {
            $scope.loc = data;
        });
        $http.get('Fixed_Json/status.json').success(function (data) {
            $scope.status = data;
        });
        $http.get('Fixed_Json/type.json').success(function (data) {
            $scope.typ = data;
        });
        $http.get('Fixed_Json/platform.json').success(function (data) {
            $scope.plt = data;
        });
        $http.get('Fixed_Json/priority.json').success(function (data) {
            $scope.pri = data;
        });
        $http.get('Fixed_Json/orderBy.json').success(function (data) {
            $scope.order = data;
        });
        $http.get('webapi/request').success(function (data) {
            $scope.request = data;
            $('#wait_moment').fadeOut('slow');
        });

        $('#toast_holder').hide();
        $scope.show = function (reqs) {
            $scope.req = reqs;
            $('#toast_holder').show();
        };
        $scope.set = function () {
            $('#toast_holder').hide();
        };

        $scope.some = "Requsted Devices";
        $(document).ready(function () {
            $('ul.tabs').tabs();
        });

        $(document).ready(function () {
            $('.modal-trigger').leanModal();
        });

        $scope.bb = function (changed) {
            if (changed === 'Rejected') {
                $(".ssss").show();
                $scope.www = true;
            } else {
                $(".ssss").hide();
                $scope.www = false;
            }
        };

        $scope.update = function (request, changed) {
            $('#toast_holder').hide();
            $('#wait_moment').fadeIn('slow');
            if (changed === 'Not') {
                $scope.status = request.request_Status;
                request.reject_comment = "Rejected Since :";
            } else {
                $scope.status = changed;
            }
            ;
//            alert($scope.status);
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
                PA:request.PA,
                project: request.project,
                request_Status: $scope.status,
                URL: request.URL,
                userName: request.userName,
                comment: request.comment,
                date: request.date,
                device_ID: request.device_ID,
                reject_comment: request.reject_comment
            };


            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var s = 'webapi/request/' + request.id;
            var res = $http.put(s, data, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Updated Successfully !!!', 2000));

            });
            res.error(function (data, status, headers, config) {
                $('#wait_moment').fadeOut('slow');
                alert("failure message: " + JSON.stringify({data: data}));
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Error, Try again...', 2000));

            });
        };

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

        $('#wait_moment').fadeOut('slow');

        $scope.goBack = function () {
            window.history.back();
        };

        $http.get('webapi/devices').success(function (data) {
            $scope.edit = data;
            $scope.edit_item = $routeParams.itemId;
        });

        $scope.some = "Requsted Devices";
        $scope.changed = 'Not';
        $scope.www = false;

        $http.get('Fixed_Json/location.json').success(function (data) {
            $scope.loc = data;
        });
        $http.get('Fixed_Json/type.json').success(function (data) {
            $scope.typ = data;
        });
        $http.get('Fixed_Json/platform.json').success(function (data) {
            $scope.plt = data;
        });
        $scope.update = function (edit) {
            $('#wait_moment').fadeIn('slow');
            var data = {
                device_ID: edit.device_ID,
                device_Name: edit.device_Name,
                product_Area: edit.product_Area,
                sub_Product_Area: edit.sub_Product_Area,
                resolution: edit.resolution,
                size: edit.size,
                os: edit.os,
                url: edit.url,
                location: edit.location,
                type: edit.type,
                platform: edit.platform
            };
            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var s = 'webapi/request/edit/' + edit.request_ID;
            var res = $http.put(s, data, config);
            res.success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Updated Successfully !!!', 2000));

            });
            res.error(function (data, status, headers, config) {
                $('#wait_moment').fadeOut('slow');
                alert("failure message: " + JSON.stringify({data: data}));
                $('#wait_moment').fadeOut('slow');
                $('.toast_show').click(Materialize.toast('Error, Try again...', 2000));

            });
        };

    }]);
