package GOFO.verification;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Verify {
    static Random rand ;
    static  int rand_int1 ;
    public static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public static boolean send_verify_code(String email,String name) {
        rand = new Random();
        rand_int1 = rand.nextInt(10000);


        String from = "mohamedpop955555@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mohamedpop.955555@gmail.com", "asa7be.com");
            }

        });

        session.setDebug(false);
        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));


            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));


            message.setSubject(" GOFO ");
            message.setText("hi " +name+"\n\nyour verification code is "+rand_int1);

            Transport.send(message);
            return true;
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }
    public static boolean check_validation_code(int code){
        if(code==rand_int1){
            return true;
        }else {
            return false;
        }
    }

    }



