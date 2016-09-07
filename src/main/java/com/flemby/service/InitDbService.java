package com.flemby.service;

import com.flemby.entity.*;
import com.flemby.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private IndexRepository indexRepository;

//    @Autowired
//    private ItemRepository itemRepository;

    @PostConstruct
    public void init() throws ParseException, IOException {

        Index index = new Index();
        index.setId(1);
        index.setText("Flemby National School is a two teacher co-educational school that proudly flies The Active" +
                " School Flag. The flag which has been awared to the school, recognises schools that strive to achieve a physically " +
                "educated and active school community.Here at Flemby we have decided that achieving an active flag would " +
                "be a great stimulus for the school.Some of the activities the school adopted were, hill -walking, " +
                "swimming and cycling.We have also drew a running track around the grounds of the school. " +
                "Flemby National School is a two teacher co - educational school that proudly flies The Active School " +
                "Flag. The flag which has been awared to the school, recognises schools that strive to achieve a physically " +
                "educated and active school community.Here at Flemby we have decided that achieving an active flag ");
        indexRepository.save(index);

//        String seniorClass = "Senior Class";
//        String juniorClass = "Junior Class";
//
//        Contact contact = new Contact();
//        contact.setId(1);
//        contact.setFirstName("John");
//        contact.setSurname("Doe");
//        contact.setEmail("paulzcos@hotmail.com");
//        contact.setNumber("0871111111");
//        contact.setType(juniorClass);
//        contactRepository.save(contact);
//
//        Contact contact2 = new Contact();
//        contact2.setId(2);
//        contact2.setFirstName("Mary");
//        contact2.setSurname("Doe");
//        contact2.setEmail("paulzcos@hotmail.com");
//        contact2.setNumber("0872222222");
//        contact2.setType(juniorClass);
//        contactRepository.save(contact2);
//
//        Contact contact3 = new Contact();
//        contact3.setId(3);
//        contact3.setFirstName("Pat");
//        contact3.setSurname("Doe");
//        contact3.setEmail("paulzcos@hotmail.com");
//        contact3.setNumber("0871111111");
//        contact3.setType(juniorClass);
//        contactRepository.save(contact3);
//
//        Contact contact4 = new Contact();
//        contact4.setId(4);
//        contact4.setFirstName("Joan");
//        contact4.setSurname("Doe");
//        contact4.setEmail("paulzcos@hotmail.com");
//        contact4.setNumber("0872222222");
//        contact4.setType(juniorClass);
//        contactRepository.save(contact4);
//
//        Contact contact5 = new Contact();
//        contact5.setId(5);
//        contact5.setFirstName("Mike");
//        contact5.setSurname("Doe");
//        contact5.setEmail("paulcostello11@gmail.com");
//        contact5.setNumber("0871111111");
//        contact5.setType(seniorClass);
//        contactRepository.save(contact5);
//
//        Contact contact6 = new Contact();
//        contact6.setId(6);
//        contact6.setFirstName("Ciara");
//        contact6.setSurname("Doe");
//        contact6.setEmail("paulcostello11@gmail.com");
//        contact6.setNumber("0872222222");
//        contact6.setType(seniorClass);
//        contactRepository.save(contact6);
//
        List<String> titleText = new ArrayList<>();
        titleText.add("test-");
        titleText.add("test-");

        List<String> descriptionText = new ArrayList<>();
        descriptionText.add("test description -");
        descriptionText.add("test description -");

        String dateStrCalendar = "2017, 00, 03-";
        String dateStrCalendar2 = "2017, 00, 04-";

        List<String> datesCalendar = new ArrayList<>();
        datesCalendar.add(dateStrCalendar);
        datesCalendar.add(dateStrCalendar2);

        Calendar calendar = new Calendar();
        calendar.setId(1);
        calendar.setMonth("January");
        calendar.setDays(31);
        calendar.setTitle(titleText);
        calendar.setDescription(descriptionText);
        calendar.setDates(datesCalendar);
        calendarRepository.save(calendar);

        List<String> titleText2 = new ArrayList<>();
        titleText2.add("test -");
        titleText2.add("test -");

        List<String> descriptionText2 = new ArrayList<>();
        descriptionText2.add("Midterm break -");
        descriptionText2.add("Midterm break -");

        List<String> datesCalendar2 = new ArrayList<>();
        datesCalendar2.add("2017, 01, 07-");
        datesCalendar2.add("2017, 01, 08-");

        Calendar calendar2 = new Calendar();
        calendar2.setId(2);
        calendar2.setMonth("February");
        calendar2.setDays(29);
        calendar2.setTitle(titleText2);
        calendar2.setDescription(descriptionText2);
        calendar2.setDates(datesCalendar2);
        calendarRepository.save(calendar2);

        Calendar calendar3 = new Calendar();
        calendar3.setId(3);
        calendar3.setMonth("March");
        calendar3.setDays(31);
        calendarRepository.save(calendar3);

        Calendar calendar4 = new Calendar();
        calendar4.setId(4);
        calendar4.setMonth("April");
        calendar4.setDays(30);
        calendarRepository.save(calendar4);

        Calendar calendar5 = new Calendar();
        calendar5.setId(5);
        calendar5.setMonth("May");
        calendar5.setDays(31);
        calendarRepository.save(calendar5);

        Calendar calendar6 = new Calendar();
        calendar6.setId(6);
        calendar6.setMonth("June");
        calendar6.setDays(30);
        calendarRepository.save(calendar6);

        Calendar calendar7 = new Calendar();
        calendar7.setId(7);
        calendar7.setMonth("July");
        calendar7.setDays(31);
        calendarRepository.save(calendar7);

        Calendar calendar8 = new Calendar();
        calendar8.setId(8);
        calendar8.setMonth("August");
        calendar8.setDays(31);
        calendarRepository.save(calendar8);

        String title = "Summer Holidays -";
        List<String> titleText3 = new ArrayList<>();
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);
        titleText3.add(title);

        List<String> descriptionText3 = new ArrayList<>();
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");
        descriptionText3.add("school closed -");


        String dateStrCalendar9 = "2016, 08, 20-";
        String dateStrCalendar10 = "2016, 08, 21-";
        String dateStrCalendar11 = "2016, 08, 22-";
        String dateStrCalendar12 = "2016, 08, 23-";
        String dateStrCalendar13 = "2016, 08, 24-";
        String dateStrCalendar14 = "2016, 08, 25-";
        String dateStrCalendar15 = "2016, 08, 26-";
        String dateStrCalendar16 = "2016, 08, 27-";

        List<String> datesCalendar9 = new ArrayList<>();
        datesCalendar9.add(dateStrCalendar9);
        datesCalendar9.add(dateStrCalendar10);
        datesCalendar9.add(dateStrCalendar11);
        datesCalendar9.add(dateStrCalendar12);
        datesCalendar9.add(dateStrCalendar13);
        datesCalendar9.add(dateStrCalendar14);
        datesCalendar9.add(dateStrCalendar15);
        datesCalendar9.add(dateStrCalendar16);

        Calendar calendar9 = new Calendar();
        calendar9.setId(9);
        calendar9.setMonth("September");
        calendar9.setDays(30);
        calendar9.setTitle(titleText3);
        calendar9.setDescription(descriptionText3);
        calendar9.setDates(datesCalendar9);
        calendarRepository.save(calendar9);

        Calendar calendar10 = new Calendar();
        calendar10.setId(10);
        calendar10.setMonth("October");
        calendar10.setDays(31);
        calendarRepository.save(calendar10);

        Calendar calendar11 = new Calendar();
        calendar11.setId(11);
        calendar11.setMonth("November");
        calendar11.setDays(30);
        calendarRepository.save(calendar11);

        Calendar calendar12 = new Calendar();
        calendar12.setId(12);
        calendar12.setMonth("December");
        calendar12.setDays(31);
        calendarRepository.save(calendar12);
//
        String dateStrNotification = "10/07/2016";
        DateFormat formatNotification = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNotification;
        dateNotification = formatNotification.parse(dateStrNotification);

        Notification notification = new Notification();
        notification.setId(1);
        notification.setName("Test1");
        notification.setPublishedDate(dateNotification);
        notification.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        notification.setType("School Notification");
        notification.setLink("https://www.google.com");
        notificationRepository.save(notification);

        Notification notification2 = new Notification();
        notification2.setId(2);
        notification2.setName("Test2");
        notification2.setPublishedDate(dateNotification);
        notification2.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        notification2.setType("Junior Class Notification");
        notification2.setLink("https://www.google.com");
        notificationRepository.save(notification2);

        Notification notification3 = new Notification();
        notification3.setId(3);
        notification3.setName("Test3");
        notification3.setPublishedDate(dateNotification);
        notification3.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        notification3.setType("Senior Class Notification");
        notification3.setLink("https://www.google.com");
        notificationRepository.save(notification3);
//
//        Role roleUser = new Role();
//        roleUser.setName("ROLE_USER");
//        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
//        roles.add(roleUser);
//
        User userAdmin = new User();
        userAdmin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("AdmiN123fns"));
//        userAdmin.setPassword("AdmiN123fns");
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);
//
        String dateStr = "10/07/2016";
        DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        date = format1.parse(dateStr);

        String dateStr2 = "10/01/2017";
        DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2;
        date2 = format2.parse(dateStr2);

        String dateStr3 = "11/01/2015";
        DateFormat format3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date3;
        date3 = format3.parse(dateStr3);

        String dateStr4 = "10/01/2015";
        DateFormat format4 = new SimpleDateFormat("dd/MM/yyyy");
        Date date4;
        date4 = format4.parse(dateStr4);

        String dateStr5 = "12/01/2015";
        DateFormat format5 = new SimpleDateFormat("dd/MM/yyyy");
        Date date5;
        date5 = format5.parse(dateStr5);

        String dateStr6 = "13/01/2015";
        DateFormat format6 = new SimpleDateFormat("dd/MM/yyyy");
        Date date6;
        date6 = format6.parse(dateStr6);

        String dateStr7 = "14/01/2015";
        DateFormat format7 = new SimpleDateFormat("dd/MM/yyyy");
        Date date7;
        date7 = format7.parse(dateStr7);

        String dateStr8 = "15/01/2018";
        DateFormat format8 = new SimpleDateFormat("dd/MM/yyyy");
        Date date8;
        date8 = format8.parse(dateStr8);


        Event event = new Event();
        event.setId(1);
        event.setType("School Event");
        event.setName("School Tour");
        event.setSlideShow("s");
        event.setLocation("Wet Lands");
        event.setHasImage(false);
        event.setLink("http://www.traleebaywetlands.org/");
        event.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event.setPublishedDate(date8);
        eventRepository.save(event);


        Event event2 = new Event();
        event2.setId(2);
        event2.setType("Senior Class Event");
        event2.setName("Town Park Walk!");
        event2.setSlideShow("s");
        event2.setLocation("Tralee Town Park");
        event2.setHasImage(false);
        event2.setLink("http://www.traleebaywetlands.org/");
        event2.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event2.setPublishedDate(date2);
        eventRepository.save(event2);

        Event event3 = new Event();
        event3.setId(3);
        event3.setType("Junior Class Event");
        event3.setName("Dublin Zoo1!");
        event3.setSlideShow("s");
        event3.setLocation("Dublin City");
        event3.setHasImage(false);
        event3.setLink("http://aquadome.ie/");
        event3.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event3.setPublishedDate(date5);
        eventRepository.save(event3);

        Event event4 = new Event();
        event4.setId(4);
        event4.setType("Junior Class Event");
        event4.setName("Photo Island Wildlife Park2!");
        event4.setSlideShow("s");
        event4.setLocation("Cork City");
        event4.setHasImage(false);
        event4.setLink("http://aquadome.ie/");
        event4.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event4.setPublishedDate(date2);
        eventRepository.save(event4);

        Event event5 = new Event();
        event5.setId(5);
        event5.setType("School Event");
        event5.setName("Aqua Dome");
        event5.setSlideShow("s");
        event5.setLocation("Aqua Dome Tralee");
        event5.setHasImage(false);
        event5.setLink("http://aquadome.ie/");
        event5.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event5.setPublishedDate(date3);
        eventRepository.save(event5);

        Event event6 = new Event();
        event6.setId(6);
        event6.setType("Senior Class Event");
        event6.setName("Aqua Dome");
        event6.setSlideShow("s");
        event6.setLocation("Aqua Dome Tralee");
        event6.setHasImage(false);
        event6.setLink("http://aquadome.ie/");
        event6.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event6.setPublishedDate(date4);
        eventRepository.save(event6);

        Event event7 = new Event();
        event7.setId(7);
        event7.setType("Junior Class Event");
        event7.setName("Dublin Zoo3!");
        event7.setSlideShow("s");
        event7.setLocation("Dublin City");
        event7.setHasImage(false);
        event7.setLink("http://aquadome.ie/");
        event7.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event7.setPublishedDate(date6);
        eventRepository.save(event7);

        Event event8 = new Event();
        event8.setId(8);
        event8.setType("Junior Class Event");
        event8.setName("Photo Island Wildlife Park4!");
        event8.setSlideShow("s");
        event8.setLocation("Cork City");
        event8.setHasImage(false);
        event8.setLink("http://aquadome.ie/");
        event8.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event8.setPublishedDate(date2);
        eventRepository.save(event8);

        Event event9 = new Event();
        event9.setId(9);
        event9.setType("Junior Class Event");
        event9.setName("Dublin Zoo5!");
        event9.setSlideShow("s");
        event9.setLocation("Dublin City");
        event9.setHasImage(false);
        event9.setLink("http://aquadome.ie/");
        event9.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event9.setPublishedDate(date7);
        eventRepository.save(event9);

        Event event10 = new Event();
        event10.setId(10);
        event10.setType("Junior Class Event");
        event10.setName("Photo Island Wildlife Park6!");
        event10.setSlideShow("s");
        event10.setLocation("Cork City");
        event10.setHasImage(false);
        event10.setLink("http://aquadome.ie/");
        event10.setText("Popular at home and abroad with locals, tourists, walking enthusiasts, nature lovers, day trippers, coach groups, garden clubs, school tours and families, Tralee Bay Wetlands Centre is equipped with not only scenic views from the 20 metre Viewing and Observation Tower but also with full visitor facilities, including the Lakeside Caf� and Bistro, An Interactive Wildlife Exhibition, Guided Nature Boat Tours, Bird Hides, and for the more energetic the light Watersports and Activity Lake Vibrant on the one hand, tranquil on the other, Tralee Bay Wetlands Centre is really a fantastic place to visit with facilities and activities to cater for all ages making your visit a uniquely individual experience.Whether you are looking for an all action activity outdoor day or a quiet and peaceful break from the stresses of modern living, the range of options are here.With 2 Areas / Zones and a myriad of attractions on site there really is something for everyone!");
        event10.setPublishedDate(date2);
        eventRepository.save(event10);

    }

}
