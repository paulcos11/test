/**
 * Created by Paul on 28/08/2016.
 */

jQuery(document).ready(function ($) {

    var width = 240;
    var aninationSpeed = 1000;
    var pause = 9000;
    var currentSlide = 1;

    var $sliderEvents = $('#sliderIndex');
    var $sliderContainerEvents = $sliderEvents.find('.slides');
    var $slidesEvents = $sliderContainerEvents.find('.slide');

    var interval;

    function startSlider() {
        interval = setInterval(function () {
            $sliderContainerEvents.animate({'margin-left': '-=' + width}, aninationSpeed, function () {
                currentSlide++;
                if (currentSlide == $slidesEvents.length) {
                    currentSlide = 1;
                    $sliderContainerEvents.css('margin-left', 0);
                }
            });
        }, pause);
    }

    function stopSlider() {
        clearInterval(interval);
    }

    $sliderEvents.on('mouseenter', stopSlider).on('mouseleave', startSlider);
    startSlider();


});
