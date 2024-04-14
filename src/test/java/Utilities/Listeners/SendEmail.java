package Utilities.Listeners;

import Utilities.Settings.Constants;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.List;

public class SendEmail {

    private static String formattedDate, currentTime;

    public static void send(){

        boolean doContinue = true;
        int maxRetries = 3, reTry = 1;

        formattedDate = Events.FORMATTER.dateFormat();
        currentTime = Events.FORMATTER.timeFormat();

        while(doContinue){

            try{

                HtmlEmail email = setUpEmail();
                EmailAttachment attachment = new EmailAttachment();
                attachment.setDisposition(EmailAttachment.ATTACHMENT);

                List<String> filePaths = FileAttachments.attachFiles();
                String htmlMessage = "<html><body><p style=\"font-family: 'Arial', sans-serif; font-size: 16px; color: #333;\">" +
                        "Good Day Everyone!<br>" +
                        "The following attachments are the Excel Files Results for each 3rd Party Providers.</p>" +
                        "Each categories has its own sheet. There are 2 columns for each categories, <b><i>File List</i></b> and <b><i>Lobby List</i></b>.</p>"+
                        "<ul>" +
                        "<li><b><i>File List</i></b>: Are the tables that are listed inside the Game Lobby that are not listed inside the 3rd Party Table List File (the excel file given to the automation team).</li>" +
                        "<li><b><i>Lobby List</i></b>: Are the tables that are listed inside the 3rd Party Table List File but not visible inside the Game Lobby</li>" +
                        "</ul>" +
                        "<p style=\"font-family: 'Arial', sans-serif; font-size: 16px; color: #333;\">Please check the attachments, thank you! - <b>" + " Automation Team "
                        + "</b></p></body></html>";

                email.setHtmlMsg(htmlMessage);

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

        email.addTo(Constants.Email.Receiver1.username, Constants.Email.Receiver1.name); // ! SETTING RECEIVER USERNAME AND NAM
        email.addTo(Constants.Email.Receiver2.username, Constants.Email.Receiver2.name); // ! SETTING RECEIVER USERNAME AND NAM


    }
    private static void sendEmail(HtmlEmail email) throws EmailException {

        System.out.println("SENDING EMAIL...");
        email.send();
        System.out.println("EMAIL SENT SUCCESSFULLY!");
    }
}
