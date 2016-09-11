package com.flemby.mail;

import com.flemby.entity.Contact;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlembyMail {
    private MailSender mailSender;

//    private Booking booking;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendMail(String s, String s2) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("paulcostello11@gmail.com");
        message.setTo("paulcostello11@gmail.com");
        message.setSubject("Contact Us Email");
        message.setText("\t\t***Contact Us Message***" + "\n\tFrom : " + s
                + "\n\n\tMessage : " + s2);
        mailSender.send(message);
    }

    public void sendMails(List<Contact> contacts, String text, String subject) {

        SimpleMailMessage message = new SimpleMailMessage();

        Set<String>emailAddresses = new HashSet<>();

        for (Contact c : contacts) {
            if (!c.getEmail().equals("")) {
                emailAddresses.add(c.getEmail());
            }
        }

        int size = emailAddresses.size();
        String[] contactEmails = new String[size];

        int i = 0;
        for (String s : emailAddresses) {
            if (!s.equals("")) {
                contactEmails[i] = s;
            }
            i++;
        }

        message.setFrom("paulcostello11@gmail.com");
        message.setTo(contactEmails);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
