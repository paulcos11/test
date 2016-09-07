package com.flemby.controller.contactUsController;

import com.flemby.mail.FlembyMail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Paul on 06/09/2016.
 */
@Controller
public class ContactUsController {

    @RequestMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.POST)
    public String doAddNewEvent(@RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("message") String message) {
        String info = "\n" + name + " " + surname + "\n" + email + "\n" + phone + "\n\n" + message;
        emailContactUs(email, info);

        System.out.println(info);

        return info;
    }

    public void emailContactUs(String s, String s2) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringMail.xml");

        FlembyMail mm = (FlembyMail) context.getBean("flembyMail");
        mm.sendMail(s, s2);

    }
}
