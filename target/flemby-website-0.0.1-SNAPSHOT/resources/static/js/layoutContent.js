//<script src="/resources/js/other/jquery1.3.2-min.js"></script>
//    <script type="text/javascript">
var d = new Date();
var h = d.getHours();
var morn = 6;
var evening = 19;

if (h >= morn && h <= evening) {

    $('#sun_red').animate({'bottom': '75%', 'opacity': 1}, 10000, function () {
    });
    $('#sun_yellow').animate({'bottom': '75%', 'opacity': 1}, 10000);

    //document.write("<div id='clouds' >1234</div>");
    //document.write("<div id='sky'></div>");
    //document.write("<div id='sun_red' class='hidden-xs hidden-sm'></div>");
    //document.write("<div id='sun_yellow' class='hidden-xs hidden-sm'></div>");


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

    //document.write("<div id='cloudsNight'></div>");
    //document.write("<div id='nightsky'></div>");
    //document.write("<div id='stars'></div>");
    //document.write("<div id='sstar'></div>");
    //document.write("<div id='moon' class='hidden-xs col-sm-1'></div>");

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
    $('#clouds').animate({
        'backgroundPosition': '-1490px -1490px',
        'opacity': 0
    }, 0);

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
//</script>