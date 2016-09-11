/**
 *
 * Created by Paul on 23/08/2016.
 */

App.controller('NotificationEmail', ['$scope', '$window', '$http', '$routeParams', '$filter',
    function ($scope, $window, $http, $routeParams, $filter) {

        $scope.submit = function () {
            $scope.publishedDate = $filter('date')($scope.notification.publishedDate, "dd/MM/yyyy");

            var fd = new FormData();
            fd.append('text', $scope.notification.text);
            fd.append('type', $scope.notification.type);
            fd.append('name', $scope.notification.name);
            fd.append('link', $scope.notification.link);
            fd.append('publishedDate', $scope.publishedDate);

            $http.post('/notificationURL/email', fd, {
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

App.controller('UpcomingEventEmail', ['$scope', '$window', '$http', '$routeParams', '$filter',
    function ($scope, $window, $http, $routeParams, $filter) {

        $scope.submit = function () {
            $scope.publishedDate = $filter('date')($scope.event.publishedDate, "dd/MM/yyyy");

            var fd = new FormData();
            fd.append('text', $scope.event.text);
            fd.append('type', $scope.event.type);
            fd.append('name', $scope.event.name);
            fd.append('location', $scope.event.location);
            fd.append('link', $scope.event.link);
            fd.append('publishedDate', $scope.publishedDate);

            $http.post('/upcomingEventsURL/email', fd, {
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

App.controller('NewSchoolNotificationPost', ['$scope', 'NotificationSave', '$window',
    function ($scope, NotificationSave, $window) {

        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolNotificationValidate.js', function () {
                        });
                    });
                });
            });
        });

        $scope.submit = function () {
            $scope.sub = true;
            if (!!$scope.notificationName && !!$scope.notificationLink && !!$scope.notificationText && !!$scope.notificationPublishedDate) {
                var notification = {
                    "name": $scope.notificationName,
                    "link": $scope.notificationLink,
                    "text": $scope.notificationText,
                    "publishedDate": $scope.notificationPublishedDate,

                };

                NotificationSave.save({}, notification,
                    function success(response) {
                        console.log("Success:");
                        $window.location.reload();

                    },
                    function error(errorResponse) {
                        console.log("Error:" + JSON.stringify(errorResponse));
                    }
                );
            }
        };

    }])
;

App.controller('NewJuniorNotificationPost', ['$scope', 'JuniorNotificationSave', '$window',
    function ($scope, JuniorNotificationSave, $window) {
        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolNotificationValidate.js', function () {
                        });
                    });
                });
            });
        });

        $scope.submit = function () {
            $scope.sub = true;
            if (!!$scope.notificationName && !!$scope.notificationLink && !!$scope.notificationText && !!$scope.notificationPublishedDate) {
                var notification = {
                    "name": $scope.notificationName,
                    "link": $scope.notificationLink,
                    "text": $scope.notificationText,
                    "publishedDate": $scope.notificationPublishedDate,

                };

                JuniorNotificationSave.save({}, notification,
                    function success(response) {
                        console.log("Success:");
                        $window.location.reload();
                    },
                    function error(errorResponse) {
                        console.log("Error:" + JSON.stringify(errorResponse));
                    }
                );
            }

        };

    }]);

App.controller('NewSeniorNotificationPost', ['$scope', 'SenorNotificationSave', '$window',
    function ($scope, SenorNotificationSave, $window) {
        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolNotificationValidate.js', function () {
                        });
                    });
                });
            });
        });

        $scope.submit = function () {
            if (!!$scope.notificationName && !!$scope.notificationLink && !!$scope.notificationText && !!$scope.notificationPublishedDate) {
                var notification = {
                    "name": $scope.notificationName,
                    "link": $scope.notificationLink,
                    "text": $scope.notificationText,
                    "publishedDate": $scope.notificationPublishedDate,

                };

                SenorNotificationSave.save({}, notification,
                    function success(response) {
                        console.log("Success:");
                        $window.location.reload();

                    },
                    function error(errorResponse) {
                        console.log("Error:" + JSON.stringify(errorResponse));
                    }
                );

            }
            ;
        }
    }]);

App.controller('UpdateNotificationEvent', ['$scope', '$window', '$http', '$routeParams', '$filter',
    function ($scope, $window, $http, $routeParams, $filter) {

        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolNotificationValidate.js', function () {
                        });
                    });
                });
            });
        });

        var eventId = $routeParams.id;
        $scope.submit = function () {
            if (!!$scope.notification.name && !!$scope.notification.link && !!$scope.notification.text && !!$scope.notification.publishedDate) {
                $scope.type = $scope.notification.type;
                $scope.name = $scope.notification.name;
                $scope.link = $scope.notification.link;
                $scope.text = $scope.notification.text;
                $scope.publishedDate = $filter('date')($scope.notification.publishedDate, "dd/MM/yyyy");
                var myDate = $scope.publishedDate;

                var fd = new FormData();
                fd.append('type', $scope.type);
                fd.append('name', $scope.name);
                fd.append('link', $scope.link);
                fd.append('text', $scope.text);
                fd.append('publishedDate', myDate);

                $http.post('/updateNotification/' + eventId, fd, {
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
        }

    }]);

App.controller('NotificationURLCon', ['$scope', 'Notification', '$routeParams', 'sessionService', function ($scope, Notification, $routeParams, sessionService) {

    $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
        $.getScript("//code.jquery.com/ui/1.11.3/jquery-ui.js", function () {

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1;
            var yyyy = today.getFullYear();

            if (dd < 10) {
                dd = '0' + dd
            }

            if (mm < 10) {
                mm = '0' + mm
            }

            today = dd + '/' + mm + '/' + yyyy;

            $("#datepicker").datepicker({
                minDate: today,
                startDate: today,
                dateFormat: 'dd/mm/yy'
            });

        });
    });

    $scope.isLoggedIn = sessionService.isLoggedIn;

    var notificationId = $routeParams.id;
    Notification.get({id: notificationId},
        function success(response) {
            console.log("Success:");
            $scope.notification = response;
            $scope.type = $scope.notification.type;
            $scope.name = $scope.notification.name;
            $scope.link = $scope.notification.link;
            $scope.text = $scope.notification.text;
            $scope.publishedDate = $scope.notification.publishedDate;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('juniorNotifyCon', ['$scope', 'JuniorNotifyList', 'sessionService', function ($scope, JuniorNotifyList, sessionService) {
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

    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.notify = [];
    JuniorNotifyList.get({},
        function success(response) {
            console.log("Success:");
            $scope.notify = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('seniorNotifyCon', ['$scope', 'SeniorNotifyList', 'sessionService', function ($scope, SeniorNotifyList, sessionService) {
    $.getScript('https://code.jquery.com/jquery-1.11.3.min.js', function () {
        $.getScript('//cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js', function () {
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

    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.notify = [];
    SeniorNotifyList.get({},
        function success(response) {
            console.log("Success:");
            $scope.notify = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('schoolNotifyCon', ['$scope', 'SchoolNotifyList', 'sessionService', function ($scope, SchoolNotifyList, sessionService) {
    $.getScript('https://code.jquery.com/jquery-1.11.3.min.js', function () {
        $.getScript('//cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js', function () {
            $(document).ready(function () {
                $('#table').DataTable({
                    "language": {
                        "lengthMenu": "Display _MENU_ records per page",
                        "zeroRecords": "No school events recorded",
                        "info": "Showing page _PAGE_ of _PAGES_",
                        "infoEmpty": "Showing 0 to 0 of 0 entries",
                        "infoFiltered": "(filtered from _MAX_ total records)"
                    },
                    "columnDefs": [
                        {"width": "60%", "targets": 0}
                    ],
                    "bFilter": false,
                    "bPaginate": true,
                    "iDisplayLength": 5,
                    "aLengthMenu": [[55, 20, 25, 50, -1], [55, 20, 25, 50, "All"]],
                    "bLengthChange": false,
                    "bDestroy": true
                });
            });
        });
    });

    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.notify = [];
    SchoolNotifyList.get({},
        function success(response) {
            console.log("Success:");
            $scope.notify = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('ImageController', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {

    function getContextPath() {
        return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
    }

    var url = getContextPath() + '/items/image.html?id=1';
    $http.get(url).success(function (result) {
        $scope.image = result.image;
    })
}]);


App.controller('NewEventPost', ['$scope', 'EventSave', '$window',
    function ($scope, EventSave, $window) {
        //
        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolEventValidate.js', function () {
                        });
                    });
                });
            });
        });

        $scope.submit = function () {
            $scope.sub = true;
            if (!!$scope.type && !!$scope.title && !!$scope.location && !!$scope.link && !!$scope.text && !!$scope.publishedDate) {
                var event = {
                    "type": $scope.type,
                    "name": $scope.title,
                    "location": $scope.location,
                    "link": $scope.link,
                    "text": $scope.text,
                    "publishedDate": $scope.publishedDate
                };

                EventSave.save({}, event,
                    function success(response) {
                        console.log("Success:");
                        $window.location.reload();
                    },
                    function error(errorResponse) {
                        console.log("Error:" + JSON.stringify(errorResponse));
                    }
                );
            }


        };

    }]);


App.controller('schoolEventCon', ['$scope', 'SchoolEventList', 'sessionService', function ($scope, SchoolEventList, sessionService) {

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


    $scope.isLoggedIn = sessionService.isLoggedIn;
    SchoolEventList.get({},
        function success(response) {
            console.log("Success:");
            $scope.events = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('seniorClassEventsCon', ['$scope', 'SeniorClassEventsList', 'sessionService', function ($scope, SeniorClassEventsList, sessionService) {
    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.eventList = [];
    SeniorClassEventsList.get({},
        function success(response) {
            console.log("Success:");
            $scope.eventList = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('juniorClassEventsCon', ['$scope', 'JuniorClassEventsList', 'sessionService', function ($scope, JuniorClassEventsList, sessionService) {
    $scope.isLoggedIn = sessionService.isLoggedIn;
    $scope.eventList = [];
    JuniorClassEventsList.get({},
        function success(response) {
            console.log("Success:");
            $scope.eventList = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('allPreviousEventsCon', ['$scope', 'EventList', function ($scope, EventList) {

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
    $scope.eventList = [];
    EventList.get({},
        function success(response) {
            console.log("Success:");
            $scope.eventList = response;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);

App.controller('UpdateUpcomingEvent', ['$scope', '$window', '$http', '$routeParams', '$filter',
    function ($scope, $window, $http, $routeParams, $filter) {

        $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
            $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
                $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
                    $(document).ready(function () {
                        $.getScript('/resources/js/other/schoolEventValidate.js', function () {
                        });
                    });
                });
            });
        });

        var eventId = $routeParams.id;
        $scope.submit = function () {
            $scope.type = $scope.event.type;
            $scope.name = $scope.event.name;
            $scope.location = $scope.event.location;
            $scope.link = $scope.event.link;
            $scope.text = $scope.event.text;
            $scope.publishedDate = $filter('date')($scope.event.publishedDate, "dd/MM/yyyy");

            var myDate = $scope.publishedDate;

            $scope.event.publishedDate = $filter('date')($scope.date, "dd/MM/yyyy");

            var fd = new FormData();
            fd.append('type', $scope.type);
            fd.append('name', $scope.name);
            fd.append('location', $scope.location);
            fd.append('link', $scope.link);
            fd.append('text', $scope.text);
            fd.append('publishedDate', myDate);

            $http.post('/updateUpcomingEvent/' + eventId, fd, {
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


App.controller('EventUpdate', ['$scope', '$window', '$http', '$routeParams',
    function EventUpdate($scope, $window, $http, $routeParams) {

        var eventId = $routeParams.id;
        $scope.submit = function () {

            $scope.text = $scope.event.text;
            $scope.story = $scope.event.story;
            var file = $scope.myFile;
            var file2 = $scope.myFile2;
            var file3 = $scope.myFile3;

            var fd = new FormData();
            fd.append('text', $scope.text);
            fd.append('story', $scope.story);
            fd.append('file', file);
            fd.append('file2', file2);
            fd.append('file3', file3);

            $http.post('/updateEvent/' + eventId, fd, {
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

App.controller('previousEventsURLCon', ['$scope', 'Event', '$routeParams', 'sessionService', function ($scope, Event, $routeParams, sessionService) {
    $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
        $.getScript('/resources/js/responsiveSlide.js', function () {
            $.getScript('/resources/js/sliderEventsSlider.js', function () {

            });
        });
    });

    $.getScript('http://jqueryvalidation.org/files/dist/jquery.validate.min.js', function () {
        $.getScript('http://jqueryvalidation.org/files/dist/additional-methods.min.js', function () {
            $(document).ready(function () {
                $.getScript('/resources/js/other/previousEventsValidate.js', function () {
                });
            });
        });
    });

    $scope.isLoggedIn = sessionService.isLoggedIn;

    var eventId = $routeParams.id;
    Event.get({id: eventId},
        function success(response) {
            console.log("Success:");
            $scope.event = response;
            $scope.text = $scope.event.text;
            $scope.story = $scope.event.story;

        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}
]);

App.controller('upcomingEventURLCon', ['$scope', 'Event', '$routeParams', 'sessionService', function ($scope, Event, $routeParams, sessionService) {

    $.getScript('http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js', function () {
        $.getScript("//code.jquery.com/ui/1.11.3/jquery-ui.js", function () {

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1;
            var yyyy = today.getFullYear();

            if (dd < 10) {
                dd = '0' + dd
            }

            if (mm < 10) {
                mm = '0' + mm
            }

            today = dd + '/' + mm + '/' + yyyy;

            $("#datepicker").datepicker({
                minDate: today,
                startDate: today,
                dateFormat: 'dd/mm/yy'
            });

        });
    });

    $scope.isLoggedIn = sessionService.isLoggedIn;

    var eventId = $routeParams.id;
    Event.get({id: eventId},
        function success(response) {
            console.log("Success:");
            $scope.event = response;
            $scope.type = $scope.event.type;
            $scope.name = $scope.event.name;
            $scope.location = $scope.event.location;
            $scope.link = $scope.event.link;
            $scope.text = $scope.event.text;
        },
        function error(errorResponse) {
            console.log("Error:" + JSON.stringify(errorResponse));
        }
    );
}]);
