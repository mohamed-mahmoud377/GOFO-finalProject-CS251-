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

/**
 * sent the verification code and check if it is right or not and has connection to the internet
 * and to run this class you must add the lib added with the project
 */
public class Verify {
    private static Random rand ;
    private static  int rand_int1 ;

    /**
     * sent a massage to the user to his email with a random number and only work with Gmail
     * @param email the user email
     * @param name the user name
     * @return return true if the massage sent successfully and false if not
     */
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
//            mex.printStackTrace();
            return false;
        }

    }

    /**
     * checks if the code sent to the User and user enters right or not
     * @param code the code intered by the user
     * @return true if the code is right
     */
    public static boolean check_validation_code(int code){
        return code == rand_int1;
    }

    }



