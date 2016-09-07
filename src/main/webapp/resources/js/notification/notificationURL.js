/**
 * Created by Paul on 11/07/2016.
 */

$("#registerationForm").validate({
    rules: {
        eventName: {
            required: true,
            minlength: 2
        },
        eventNotificationType: {
            required: true
        },
        eventText: {
            required: true,
            minlength: 10,
            maxlength: 1000
        },
        eventPublishedDate: {
            required: true,
            date: true,
            dateFormat: 'MM/dd/yy'
        }
    }
})
