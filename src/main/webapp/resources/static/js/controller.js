/**
 * Created by Paul on 19/08/2016.
 */


//'use strict';

App.controller('ContactCon', ['$scope', 'AllContacts', function ($scope, AllContacts) {

    $.getScript('https://code.jquery.com/jquery-1.11.3.min.js', function () {
        $.getScript('//cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js', function () {
            //
            $(document).ready(function () {
                $('#table').DataTable({
                    "language": {
                        "lengthMenu": "Display _MENU_ records per page",
                        "zeroRecords": "No school events recorded",
                        "info": "Showing page _PAGE_ of _PAGES_",
                        "infoEmpty": "Showing 0 to 0 of 0 entries",
                        "infoFiltered": "(filtered from _MAX_ total records)"
                    },
                    "bFilter": false,
                    "bPaginate": true,
                    "iDisplayLength": 5,
                    "aLengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
                    "bLengthChange": false,
                    "bDestroy": true
                });
            });
        });
    });
    $scope.contacts = [];
    AllContacts.get({},
        function success(response) {
            console.log("Success:");
            $scope.contacts = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller("navigation", function ($scope, sessionService, $location, userService) {

    $scope.login = function () {
        userService.userExists($scope.user, function (user) {
                sessionService.login($scope.user).then(function () {
                    $location.path('/')
                });
            },
            function () {
                alert('Error logging in user');
            });
    }
})
//
App.controller('ItemControllerCon', ['ItemEventsGallery', '$scope', function ItemControllerCon(ItemEventsGallery,
                                                                                               $scope) {
    $scope.item = [];
    var eventId = $scope.$parent.x.id;
    //alert(eventId);
    ItemEventsGallery.get({id: eventId},

        function success(response) {
            //alert($scope.challenge.question);
            console.log("Success:" + JSON.stringify(response));
            $scope.item = response;
            //alert('Testing helloworld');
        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    )

}]);


App.controller('GalleryControllerCon', ['PreviousEventsGallery', '$scope', function GalleryControllerCon(PreviousEventsGallery,
                                                                                                         $scope) {

    $.getScript('https://code.jquery.com/jquery-1.11.3.min.js', function () {
        $(document).ready(function () {
            $.getScript('/resources/js/other/lightbox.min.js', function () {

            });
        });
    });


    $scope.range = function (min, max, step) {
        step = step || 1;
        var input = [];
        for (var i = min; i <= max; i += step) {
            input.push(i);
        }
        return input;
    };

    $scope.event = [];
    PreviousEventsGallery.get({},
        function success(response) {
            console.log("Success:");
            $scope.event = response;
        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    )

}]);

App.controller('UpdateHome', ['$scope', '$window', '$http',
    function UpdateHome($scope, $window, $http) {

        var eventId = 1;

        $scope.submit = function () {
            $scope.text = $scope.index.text;
            alert($scope.text);

            var file = $scope.myFile;
            var file2 = $scope.myFile2;
            var file3 = $scope.myFile3;
            var fd = new FormData();
            fd.append('text', $scope.text);
            fd.append('file', file);
            fd.append('file2', file2);
            fd.append('file3', file3);

            $http.post('/updateHome/' + eventId, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
                .success(function (response) {
                    console.log("Success:");
                    $window.location.reload();

                })
                .error(function () {
                });
        }

    }]);

App.controller('homeController', function ($scope, $http, sessionService) {

    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.logout = sessionService.logout;
    $http.get('/resource/').then(function (responce) {
        $scope.index = responce.data;
        $scope.text = $scope.index.text;
    });
});


App.controller('contactForm', function ($scope, $http) {
    $scope.submit = function () {
        //var text = angular.toJson($scope.text, true);
        var formName = $scope.name;
        var surname = $scope.surname;
        var email = $scope.email;
        var phone = $scope.phone;
        var message = $scope.message;

        alert(message);

        var fd = new FormData();
        fd.append('name', formName);
        fd.append('surname', surname);
        fd.append('email', email);
        fd.append('phone', phone);
        fd.append('message', message);

        $http.post('/contactUs/', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function (response) {
                console.log('Success test');
                console.log("Success:" + JSON.stringify(response));
                //$route.reload();
                $window.location.reload();

            })
            .error(function () {

            });
    }
});


App.controller('conUs', function () {
    $.getScript('//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js', function () {
        $('#registerationForm').validate({
            rules: {
                name: {
                    required: true,
                    email: true,
                    minlength: 2,
                    maxlength: 30
                },
                surname: {
                    required: true,
                    email: true,
                    minlength: 2,
                    maxlength: 30
                },
                email: {
                    required: true,
                    email: true,
                    minlength: 5,
                    maxlength: 30
                },
                phone: {
                    required: true,
                    number: true,
                    minlength: 5,
                    maxlength: 30
                },
                message: {
                    required: true,
                    minlength: 10,
                    maxlength: 250
                }
            }
        });
    });

});

App.controller('calendarCon', function () {
    $.getScript('https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
        $.getScript('/resources/js/responsiveSlide.js', function () {
            $("#slider").responsiveSlides({
                auto: false,             // Boolean: Animate automatically, true or false
                pager: false,           // Boolean: Show pager, true or false
                nav: true,
                speed: 0,
                maxwidth: 800,
                namespace: "centered-btns",
            });
        });
    });
});

App.controller('calendarMonthCon', ['$scope', 'CalendarMonthService', '$routeParams', function calendarMonthCon($scope, CalendarMonthService, $routeParams) {

    $.getScript('https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js', function () {
        $.getScript('/resources/js/other/jquery.e-calendar.js', function () {
            $.getScript('//code.jquery.com/ui/1.11.3/jquery-ui.js', function () {
                $.getScript('/resources/js/schoolCalendar/getMonth.js', function () {


                    $(document).ready(function () {

                        var element = document.createElement("script");
                        element.src = "/resources/js/schoolCalendar/schoolMonthCalendar.js";
                        document.body.appendChild(element);
                        today2 = month($routeParams.id);

                        var date = getMonth($routeParams.id)

                        $('#calendar').eCalendar({
                            events: [
                                {
                                    title: 'test', description: 'test description ',
                                    datetime: new Date(2017, 00, 03)
                                }, {
                                    title: 'test',
                                    description: 'test description ',
                                    datetime: new Date(2017, 00, 04)
                                }, {
                                    title: 'test ', description: 'Midterm break ',
                                    datetime: new Date(2017, 01, 07)
                                }, {
                                    title: 'test ',
                                    description: 'Midterm break ',
                                    datetime: new Date(2017, 01, 08)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 20)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 21)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 22)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 23)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 24)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 25)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 26)
                                }, {
                                    title: 'Summer Holidays ',
                                    description: 'school closed ',
                                    datetime: new Date(2016, 08, 27)
                                }
                            ],
                            date: date

                        });
                    });

                    // Check for browser support of event handling capability
                    //if (window.addEventListener)
                    //    window.addEventListener("load", downloadJSAtOnload, false);
                    //else if (window.attachEvent)
                    //    window.attachEvent("onload", downloadJSAtOnload);
                    //else window.onload = downloadJSAtOnload;

                    //});
                });
            });
        });
    });

    var calendarId = $routeParams.id;
    CalendarMonthService.get({id: calendarId},

        function success(response) {
            //alert($scope.challenge.question);
            console.log("Success:" + JSON.stringify(response));
            $scope.calendar = response;
            //alert('Testing helloworld');
        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    )


}
])
;

App.controller('locationCon', function () {

    $.getScript('http://maps.google.com/maps/api/js?sensor=false', function () {

        var mapOptions = {

            center: new google.maps.LatLng(52.238105, -9.614666),
            zoom: 11,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);

        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(52.238105, -9.614666),
            map: map
        });

    });
});

