/**
 *
 * Created by Paul on 31/08/2016.
 */

function downloadJSAtOnload() {

    var element = document.createElement("script");
    element.src = "/resources/js/schoolCalendar/schoolMonthCalendar.js";
    document.body.appendChild(element);
    today2 = month(9);

    var date = getMonth(9)

    $('#calendar').eCalendar({
        events: [
            {title: 'test', description: 'test description ', datetime: new Date(2017, 00, 03)}, {
                title: 'test',
                description: 'test description ',
                datetime: new Date(2017, 00, 04)
            }, {title: 'test ', description: 'Midterm break ', datetime: new Date(2017, 01, 07)}, {
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
            }, {title: 'Summer Holidays ', description: 'school closed ', datetime: new Date(2016, 08, 27)}
        ],
        date: date

    });
}
