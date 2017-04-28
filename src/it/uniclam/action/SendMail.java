package it.uniclam.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniclam.db.DBUtility;
import org.apache.struts2.interceptor.ServletRequestAware;


public class SendMail extends ActionSupport implements ServletRequestAware{
    private String to;
    public static final String from = "monugramapp@gmail.com";
    public static final String m_password = "unicas2017";
    public static final String smtpServ = "smtp.gmail.com";
    public static final String subject = "Password Recovery from Monugram";
    public String message = "Hi, you have requested your password from MonugramAPP. Your password is: ";
    public String user_pass;
    private HttpServletRequest hsr;
    private HttpSession hs;
    private int i;

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.hsr=hsr;
    }

    // Also include an inner class that is used for authentication purposes
    private class SMTPAuthenticator extends Authenticator{
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, m_password);
        }
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toLowerCase();
    }


    public int sendMail(){
        try
        {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.starttls.enable","true" );
            props.put("mail.smtp.host",smtpServ);
            props.put("mail.smtp.auth", "true" );
            Authenticator auth = new SendMail.SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // -- FIND PASSWORD --
            user_pass = findPassword(getTo());
            System.out.println("Password "+user_pass);
            message = message + user_pass;

            msg.setSubject(subject);
            msg.setText(message);
            // -- Set some other header information --
            msg.setHeader("MyMail", "Mr. XYZ" );
            msg.setSentDate(new Date());

            // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to "+to+" OK." );
            return 0;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception "+ex);
            return -1;
        }
    }
    @Override
    public String execute(){


        hs=hsr.getSession();
        try{
            if(hs.getAttribute("sms")!=null){
                hs.removeAttribute("sms");
            }
        }catch(Exception e){
            System.out.println("IN EXECUTE() : FIRST TRY FAILED");
        }
        try{
            i=sendMail();
            if(i==0){
                hs.setAttribute("sms", "Your E-Mail has been sent successfully to :"+to);
            }else{
                hs.setAttribute("sms", "Failed to Send Email to :"+to+" : Authentication Failed ");
            }
            return "success";
        }catch(Exception e){
            System.out.println("IN EXECUTE : SECOND TRY FAILED");
            System.out.println(e);
            hs.setAttribute("sms", "Error:::"+e);
            return "error";
        }
    }

    public String findPassword(String u_email)
    {
        String uPass = "null";
        Statement st = null;
        try{

            Connection con = DBUtility.getDBConnection();
            st=con.createStatement();
            String query = "select password from User where email='"+u_email+"';";

            ResultSet rs=st.executeQuery(query);

            if (rs.next())
            {
                uPass = rs.getString("password");
            }
        }catch(Exception e){e.printStackTrace();}

        return uPass;
    }


    @Override
    public void validate(){

        if(to.isEmpty()){
            addFieldError("to", "Email Field cannot be left blank!!!");
        }

        else  if((!from.endsWith("@gmail.com"))&&(!from.endsWith("@live.com"))&&(!from.endsWith("@hotmail.com"))){
            addFieldError("from", "Email ID not valid!!!");
        }

       /* else if((!to.endsWith("@gmail.com"))&&(!to.endsWith("@live.com"))&&(!to.endsWith("@hotmail.com"))){
            addFieldError("from", "Email ID not valid!!!");
        }
        else if(from.isEmpty()){
            addFieldError("to", "Email Field cannot be left blank!!!");
        }
        else if(m_password.isEmpty()||password2.isEmpty())
        {
            addFieldError("password2", "Please enter your m_password!!!");
        }

        else if(!m_password.equals(password2)) {
            addFieldError("password2", "Password mismatch!!!");
        }
        else if(message.isEmpty()){
            addFieldError("message", "Please Enter your message!!!");
        }*/
    }

}