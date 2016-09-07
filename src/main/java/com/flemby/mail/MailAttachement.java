package com.flemby.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;


public class MailAttachement {

    private JavaMailSenderImpl mailSender;

    public void setMailSender(JavaMailSenderImpl mailSender) {

        this.mailSender = mailSender;
    }

    // sending email with xtra emails + all or no customers, subject, message
    // and file
//    public void sendMails(List<Customer> customers, String r, String m,
//                          String s, File f) throws MessagingException {
//
//        String[] recipientList = r.split(",");
//        int custLength = customers.size();
//        String[] recipients = new String[custLength + recipientList.length];
//        int counter = 0;
//
//        if (customers != null) {
//            for (Customer c : customers) {
//                if (!c.getEmail().equals("")) {
//                    recipients[counter] = c.getEmail();
//                }
//                counter++;
//            }
//        }
//        if (counter == 0) {
//            System.out.println(counter + " custLen " + recipientList.length);
//            int counter2 = counter;
//            for (int i = counter2; i < counter2 + recipientList.length; i++) {
//                System.out.println(counter);
//                recipients[i] = recipientList[counter];
//                counter++;
//            }
//        } else {
//            int counter2 = counter;
//            int counter3 = 0;
//            for (int i = counter2; i < counter2 + recipientList.length; i++) {
//                recipients[i] = recipientList[counter3];
//                counter3++;
//            }
//        }
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(recipients);
//        helper.setSubject(s);
//        helper.setText(m);
//        String fileName = f.getName();
//        FileSystemResource file = new FileSystemResource(f.getAbsolutePath());
//        helper.addAttachment(fileName, file);
//        mailSender.send(message);
//
//    }

    // sending email with all or no customers, subject, message and file
//    public void sendMails(List<Customer> customers, String m, String s, File f)
//            throws MessagingException {
//
//        String[] recipients = new String[customers.size()];
//        int counter = 0;
//        for (Customer c : customers) {
//            if (!c.getEmail().equals("")) {
//                recipients[counter] = c.getEmail();
//            }
//            counter++;
//        }
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(recipients);
//        helper.setSubject(s);
//        helper.setText(m);
//        String fileName = f.getName();
//        FileSystemResource file = new FileSystemResource(f.getAbsolutePath());
//        helper.addAttachment(fileName, file);
//        mailSender.send(message);
//    }

    // sending email with recipients, all or no customers, subject, message
//    public void sendMails(List<Customer> customers, String r, String m, String s)
//            throws MessagingException {
//
//        String[] recipientList = r.split(",");
//        int custLength = customers.size();
//        String[] recipients = new String[custLength + recipientList.length];
//        int counter = 0;
//        if (customers != null) {
//            for (Customer c : customers) {
//                if (!c.getEmail().equals("")) {
//                    recipients[counter] = c.getEmail();
//                }
//                counter++;
//            }
//        }
//        if (counter == 0) {
//            System.out.println(counter + " custLen " + recipientList.length);
//            int counter2 = counter;
//            for (int i = counter2; i < counter2 + recipientList.length; i++) {
//                System.out.println(counter);
//                recipients[i] = recipientList[counter];
//                counter++;
//            }
//        } else {
//            int counter2 = counter;
//            int counter3 = 0;
//            for (int i = counter2; i < counter2 + recipientList.length; i++) {
//                recipients[i] = recipientList[counter3];
//                counter3++;
//            }
//        }
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(recipients);
//        helper.setSubject(s);
//        helper.setText(m);
//        mailSender.send(message);
//
//    }

    // sending email to all or no customers, subject, message
//    public void sendMails(List<Customer> customers, String m, String s)
//            throws MessagingException {
//
//        String[] recipients = new String[customers.size()];
//        int counter = 0;
//        for (Customer c : customers) {
//            if (!c.getEmail().equals("")) {
//                recipients[counter] = c.getEmail();
//            }
//            counter++;
//        }
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(recipients);
//        helper.setSubject(s);
//        helper.setText(m);
//        mailSender.send(message);
//
//    }
}
