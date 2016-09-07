$("#registerationForm").validate({
    rules: {
        eventName: {
            required: true,
            minlength: 4
        },
        eventLocation: {
            required: true,
            minlength: 4
        },
        eventLink: {
            required: true,
            url: true
        },
        eventText: {
            required: true,
            minlength: 5,
            maxlength: 1000
        },
        eventDate: {
            required: true,
            date: true,
            dateFormat: 'MM/dd/yy'
        }
    }
});