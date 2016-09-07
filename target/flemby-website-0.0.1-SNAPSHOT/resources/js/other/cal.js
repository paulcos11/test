$(document).ready(function () {
    $('#calendar').eCalendar({
        events: [
            {title: 'Summer Holidays', description: 'Summer break until the 1st of September', datetime: new Date(2016, 6, 31)},
            {title: 'Event Title 2', description: 'Description 2', datetime: new Date(2016, 0, 23)}
        ]
    });
});

