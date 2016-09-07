/**
 *
 * Created by Paul on 10/07/2016.
 */

function month(m) {
    var today = new Date();
    var dd = 1;
    var mm = m;
    var yyyy;

    if (mm >= 1 && mm <= 8) {
        yyyy = (today.getFullYear() + 1);
    } else {
        yyyy = today.getFullYear();
    }

    if (dd < 10) {
        dd = '0' + dd
    }

    d = new Date(yyyy, mm, 0);

    var today2 = dd + '/' + mm + '/' + yyyy;

    return today2
}

function getMonth (newMM){
    var date;
    var yr = new Date();
    var nxtYr = (yr.getFullYear() + 1)

    if (newMM == 1) {
        date = new Date("January 01," + nxtYr);
    } else if (newMM == 2) {
        date = new Date("February 01," + nxtYr);
    } else if (newMM == 3) {
        date = new Date("March 01," + nxtYr);
    } else if (newMM == 4) {
        date = new Date("April 01," + nxtYr);
    } else if (newMM == 5) {
        date = new Date("May 01," + nxtYr);
    } else if (newMM == 6) {
        date = new Date("June 01," + nxtYr);
    } else if (newMM == 7) {
        date = new Date("July 01," + nxtYr);
    } else if (newMM == 8) {
        date = new Date("August 01," + nxtYr);
    } else if (newMM == 9) {
        date = new Date("September 01," + yr.getFullYear());
    } else if (newMM == 10) {
        date = new Date("October 01," + yr.getFullYear());
    } else if (newMM == 11) {
        date = new Date("November 01," + yr.getFullYear());
    } else if (newMM == 12) {
        date = new Date("December 01," + yr.getFullYear());
    }

    return date
}
