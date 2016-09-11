<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%-- <%@ include file="../layout/taglib.jsp"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring and Angularjs Tutorial</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <script
            src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


    <%--<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>--%>


    <%--<script src="/resources/js/other/lightbox.min.js"></script>--%>
    <style>
        <%@include file="/resources/static/css/navigation.css"%>
        <%@include file="/resources/static/css/simple-sidebar.css"%>
        <%@include file="/resources/static/css/sticky-footer-navbar.css"%>
        <%@include file="/resources/static/css/index/index.css" %>

        <%--<%@include file="/resources/static/css/jquery.e-calendar.css" %>--%>
        <%--<%@include file="/resources/static/css/calendar/responsiveSlide.css" %>--%>
        <%--<%@include file="/resources/static/css/gallery/gallery.css"%>--%>


    </style>

    <link href="/resources/static/css/lightbox.css" rel="stylesheet">
    <link href="/resources/static/css/events/events.css" rel="stylesheet">
    <link href="/resources/static/css/theme.css" rel="stylesheet">
    <link href="/resources/static/css/calendar/schoolCalendar.css" rel="stylesheet">
    <link href="/resources/static/css/events/eventsURL.css" rel="stylesheet">
    <link href="/resources/static/css/gallery/gallery.css" rel="stylesheet">
    <link href="/resources/static/css/contactUs/contactUs.css" rel="stylesheet">
    <link href="/resources/static/css/location/locationTwo.css" rel="stylesheet">
    <link href="/resources/static/css/notification/notification.css" rel="stylesheet">
    <link href="/resources/static/css/calendar.css" rel="stylesheet">
    <link href="/resources/static/css/calendar/responsiveSlide.css" rel="stylesheet">



</head>
<body>
<div flemby-menu></div>
<div class="container">

    <script type="text/javascript">
        var d1 = new Date();
        var h1 = d1.getHours();
        var morn = 6;
        var evening = 19;

        if (h1 >= morn && h1 <= evening) {
            document.write("<style> .navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus { background-image: -webkit-linear-gradient(top, #84bced 0, #e8e8e8 110%);background-image: -webkit-linear-gradient(top, #e8e8e8 0, #84bced 110%);background-repeat: repeat-x;filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#84bced', endColorstr='#84bced', GradientType=0);background-color: #84bced;font-size: 1.1em; }</style>");
            document.write("<style> .dropdown-menu > li > a:hover, .dropdown-menu > li > a:focus { background-image: -webkit-linear-gradient(top, #84bced 0, #e8e8e8 100%); background-image: linear-gradient(to bottom, #e8e8e8  0, #84bced 100%); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#84bced', endColorstr='#84bced', GradientType=0);background-color: #84bced;text-align: center;}</style>");
            document.write("<style> .navbar-default .navbar-nav > li > a:hover, .navbar-default .navbar-nav > li > a:focus { background-image: -webkit-linear-gradient(top, #84bced 0, #e8e8e8 100%); background-image: linear-gradient(to bottom, #e8e8e8  0, #84bced 100%); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#84bced', endColorstr='#84bced', GradientType=0); background-color: #84bced; text-align: center;}</style>");
            document.write("<nav class='navbar navbar-default navbar-customDay'>");

        } else {
            document.write("<style>.navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus { background-image: -webkit-linear-gradient(top, #898bcc 0, #84bced 120%);background-image: -webkit-linear-gradient(top, #84bced 0, #898bcc 120%);background-repeat: repeat-x;filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#84bced', endColorstr='#84bced', GradientType=0);background-color: #899ddd;font-size: 1.1em; </style>");
            document.write("<style> .dropdown-menu > li > a:hover, .dropdown-menu > li > a:focus { background-image: -webkit-linear-gradient(top, #898bcc 0, #84bced 100%); background-image: linear-gradient(to bottom, #84bced  0, #898bcc 100%); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#898bcc', endColorstr='#84bced', GradientType=0);background-color: #898bcc;text-align: center;}</style>");
            document.write("<style> .navbar-default .navbar-nav > li > a:hover, .navbar-default .navbar-nav > li > a:focus { background-image: -webkit-linear-gradient(top, #898bcc 0, #84bced 100%); background-image: linear-gradient(to bottom, #84bced  0, #898bcc 100%); background-repeat: repeat-x; filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#898bcc', endColorstr='#84bced', GradientType=0); background-color: #898bcc; text-align: center;}</style>");
            document.write("<nav class='navbar navbar-default navbar-customNight '>");

        }
    </script>


    <div class="container">
        <div class="navbar-header">

            <%--<button class="navbar-toggle" data-toggle="collapse" data-target=".myNav">--%>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".myNav">

                <span class="sr-only">Toggle navigation</span>
                Menu <i class="fa fa-bars"></i>

            </button>


        </div>

        <div ng-controller="navigation as nav" class="collapse navbar-collapse myNav" id="bs-example-navbar-collapse-1">
            <%--<a class="navbar-brand navbar-left nav-pills" role="tablist" href='#/home'>Flemby</a>--%>
            <ul class="nav navbar-nav myNav">

                <li class="	${current == 'index' ? 'active' : ''} " data-toggle="collapse" data-target=".in">
                    <a href='#/home'>Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="dropdown" data-toggle="collapse" data-target=".in">

                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"
                       data-toggle="collapse" data-target=".in">
                        School Policies
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" role="menu">

                        <li><a href="#">Principal's Message</a></li>
                        <li><a href="#">School History</a></li>
                    </ul>
                </li>

                <li class=" dropdown" data-toggle="collapse" data-target=".in">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        Parents Information
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#">Parent Council</a>
                        </li>
                    </ul>
                </li>

                <li data-toggle="collapse" data-target=".in">
                    <a href="#/allPreviousEvents">Previous Activities</a>
                </li>

                <li data-toggle="collapse" data-target=".in">
                    <a href="#/upcomingEvents">Upcoming Activities</a>
                </li>


                <li data-toggle="collapse" data-target=".in">
                    <a href="#/gallery" alt="Gallery">Gallery</a>
                </li>

            </ul>

        </div>

    </div>
    </nav>
    <div class="container">

        <script type="text/javascript" defer="defer">
            var d1 = new Date();
            var h1 = d1.getHours();
            var morn = 6;
            var evening = 19;

            if (h1 >= morn && h1 <= evening) {
                document
                        .write("<img width='367px' height='43px'  class='img-responsive plane' src='/resources/static/images/planeHeader3.png'> ");
            } else {
                document
                        .write("<img width='367px' height='43px' class='img-responsive plane' src='/resources/static/images/planeHeaderNight.png'>");
            }
        </script>

    </div>

</div>


<script src="https://code.jquery.com/jquery-1.3.2.min.js"
        integrity="sha256-yDcKLQUDWenVBazEEeb0V6SbITYKIebLySKbrTp2eJk=" crossorigin="anonymous"></script>
<script type="text/javascript">
    var d = new Date();
    var h = d.getHours();
    var morn = 6;
    var evening = 19;


    if (h >= morn && h <= evening) {

        $('#sun_red').animate({'bottom': '75%', 'opacity': 1}, 10000, function () {
        });
        $('#sun_yellow').animate({'bottom': '75%', 'opacity': 1}, 10000);

        document.write("<div id='clouds' ></div>");
        document.write("<div id='sky'></div>");
        document.write("<div id='sun_red' class='hidden-xs hidden-sm'></div>");
        document.write("<div id='sun_yellow' class='hidden-xs hidden-sm'></div>");


        $(function () {

            $('#sun_red').animate({
                'bottom': '70%',

                'opacity': 2
            }, 9000, function () {

            });

            $('#sun_yellow').animate({
                'bottom': '70%',
                'backgroundPosition': '0px 1200px',
                'opacity': 2
            }, 9000);
            $('#clouds').animate({
                'backgroundPosition': '1000px 0px',
                'opacity': 0
            }, 30000);
            $('#plane').animate({
                "margin-right": '70%'
            }, 30000);
            $('#sky').animate({
                'backgroundPosition': '0px 000px',
                'opacity': .55
            }, 5000);

        });

    } else {

        document.write("<div id='cloudsNight'></div>");
        document.write("<div id='nightsky'></div>");
        document.write("<div id='stars'></div>");
        document.write("<div id='sstar'></div>");
        document.write("<div id='moon' class='hidden-xs col-sm-1'></div>");


        $(function () {
            $('#stars').animate({
                'opacity': 2
            }, 8000, function () {
                $('#moon').animate({
                    'top': '10%',
                    'opacity': 1
                }, 7000, function () {

                    $('#sstar').animate({
                        'opacity': 1
                    }, 300);
                    $('#sstar').animate({
                        'backgroundPosition': '0px 0px',
                        'top': '15%',
                        'opacity': 0
                    }, 500);
                });
            });
        });
        $('#cloudsNight').animate({
            'backgroundPosition': '-1490px 0px',
            'opacity': 0
        }, 30000);
        $('#nightsky').animate({
            'bottom': '98%'
        }, 5000);

        $('#night').animate({
            'opacity': 0.4
        }, 20000);


    }
</script>
<div id='ground' class=''></div>


<div ng-view ng-cloak class="ng-cloak" autoscroll="true"></div>

<script src="./webjars/angularjs/1.4.8/angular.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-resource.js"></script>
<script src="./webjars/angularjs/1.4.8/angular-route.js"></script>
<script src="../resources/static/js/app.js"></script>
<script src="../resources/static/js/service.js"></script>
<script src="../resources/static/js/controller.js"></script>
<script src="../resources/static/js/eventController/eventController.js"></script>
<script src="../resources/static/js/directive.js"></script>






<%--<%@include file="/resources/static/css/events/events.css"%>--%>
<%--<%@include file="/resources/static/css/theme.css"%>--%>

<%--<%@include file="/resources/static/css/calendar/schoolCalendar.css" %>--%>
<%--<%@include file="/resources/static/css/events/eventsURL.css" %>--%>
<%--<%@include file="/resources/static/css/gallery/gallery.css" %>--%>
<%--<%@include file="/resources/static/css/contactUs/contactUs.css" %>--%>
<%--<%@include file="/resources/static/css/location/locationTwo.css" %>--%>
<%--<%@include file="/resources/static/css/notification/notification.css" %>--%>
<%--<%@include file="/resources/static/css/calendar.css" %>--%>
<%--<%@include file="/resources/static/css/contacts/contacts.css" %>--%>

<%--<script src="/resources/js/other/jquery.e-calendar.js"></script>--%>

<%--<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>--%>

<%--<script src="/resources/js/schoolCalendar/getMonth.js"></script>--%>
</body>
</html>