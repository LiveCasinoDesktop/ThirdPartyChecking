package Utilities.Listeners;

import Utilities.Settings.Constants;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.List;

public class SendEmail {

    private static String formattedDate, currentTime;
    private static String provider;

    public static void send(){

        SendEmail.provider = provider;

        boolean doContinue = true;
        int maxRetries = 3, reTry = 1;

        formattedDate = Events.FORMATTER.dateFormat();
        currentTime = Events.FORMATTER.timeFormat();

        while(doContinue){

            try{

                HtmlEmail email = setUpEmail();
                EmailAttachment attachment = new EmailAttachment();
                attachment.setDisposition(EmailAttachment.ATTACHMENT);

                List<String> filePaths = FileAttachments.attachFiles();;

                // * Setting Message
                setMessage(email);

                for(String filePath : filePaths){

                    System.out.println("File: " + filePath);
                    attachment.setPath(filePath);

                    email.attach(attachment);
                }

                sendEmail(email);

                System.out.println("============================================================");

                doContinue = false;


            }catch (EmailException e) {

                System.out.println(e.getMessage());

                reTry++;

                if(reTry == maxRetries){
                    break;
                }

            }
        }

    }
    private static HtmlEmail setUpEmail() throws EmailException {
        HtmlEmail email = new HtmlEmail();

        email.setHostName(Constants.Email.HostName.outlook); // ! SETTING SMTP HOST NAME
        email.setSmtpPort(Constants.Email.SMTPPort.SSL); // ! SETTING SMTP PORT
        email.setAuthenticator(new DefaultAuthenticator(Constants.Email.Sender.username, Constants.Email.Sender.password)); // ! SETTING SENDER USERNAME AND PASSWORD AUTHENTICATION
        email.setFrom(Constants.Email.Sender.username, Constants.Email.Sender.name); // ! SETTING SENDER USERNAME AND NAME
        email.setStartTLSEnabled(true); // ! SETTING SMTP PORT

        setEmailSubject(email);
        setRecipients(email);

        return email;
    }
    private static void setEmailSubject(HtmlEmail email){
        email.setSubject("Third Party Lobby Checking Report: " + formattedDate + " " + currentTime);
    }
    private static void setRecipients(HtmlEmail email) throws EmailException {

        email.addTo(Constants.Email.RECEIVER.Receiver1.username, Constants.Email.RECEIVER.Receiver1.name);
//        email.addTo(Constants.Email.RECEIVER.SCReceiver.username, Constants.Email.RECEIVER.SCReceiver.name);
//        email.addTo(Constants.Email.RECEIVER.BOSS1.username, Constants.Email.RECEIVER.BOSS1.name);
    }
    private static void sendEmail(HtmlEmail email) throws EmailException {

        System.out.println("SENDING EMAIL...");
        email.send();
        System.out.println("EMAIL SENT SUCCESSFULLY!");
    }

    private static void setMessage(HtmlEmail email) throws EmailException {
        String htmlMessage = "<html><body><p style=\"font-family: 'Arial', sans-serif; font-size: 16px; color: #333;\">" +
                "Good Day Everyone!<br>" +
                "The following attachments are the Excel Files Results for each 3rd Party Providers.</p>" +
                "Each categories has its own sheet. There are 3 columns for each categories: <b><i>Base List</i></b>, <b><i>Added List</i></b>, and <b><i>Removed List</i></b>.</p>"+
                "<ul>" +
                "<li><b><i>Base List</i></b>: Is the list that will be compared to by the tables inside the Game Lobby</li>" +
                "<li><b><i>Added List</i></b>: List of the tables that are added inside the game and not found in the Base List.</li>" +
                "<li><b><i>Removed List</i></b>: Lost of the tables that are inside the Base List, but cannot be found in Game Lobby</li>" +
                "</ul>" +
                "<p style=\"font-family: 'Arial', sans-serif; font-size: 16px; color: #333;\">Please check the attachments, thank you! - <b>" + " Automation Team "
                + "</b></p></body></html>";

        email.setHtmlMsg(htmlMessage);
    }


    public static void sendSpecific(String provider){

        SendEmail.provider = provider;

        boolean doContinue = true;
        int maxRetries = 3, reTry = 1;

        formattedDate = Events.FORMATTER.dateFormat();
        currentTime = Events.FORMATTER.timeFormat();

        while(doContinue){

            try{

                HtmlEmail email = setUpEmail();
                EmailAttachment attachment = new EmailAttachment();
                attachment.setDisposition(EmailAttachment.ATTACHMENT);

                List<String> filePaths = FileAttachments.attachFiles(provider);

                // * Setting Message
                setMessage(email);

                for(String filePath : filePaths){

                    System.out.println("File: " + filePath);
                    attachment.setPath(filePath);

                    email.attach(attachment);
                }

                sendEmail(email);

                System.out.println("============================================================");

                doContinue = false;


            }catch (EmailException e) {

                System.out.println(e.getMessage());

                reTry++;

                if(reTry == maxRetries){
                    break;
                }

            }
        }
    }
}
