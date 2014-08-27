package org.formprocessor;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.*;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class FormdataServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse response)
			throws IOException {
		
		ObjectifyService.register(Student.class);
		
		
		Student s = new Student(req.getParameter("email"),req.getParameter("name1"),req.getParameter("college"),req.getParameter("year"),req.getParameter("phoneno"),req.getParameter("name2"),req.getParameter("department"),req.getParameter("event"));
		ofy().save().entity(s);
		sendMail(req.getParameter("email"),req.getParameter("name1"));
		response.setContentType("text/html");

	      // New location to be redirected
	      String site = new String("http://xxxx");

	      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	      response.setHeader("Location", site);    
		}
	public void sendMail(String emailid, String name) throws UnsupportedEncodingException{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String msgBody = "Hello "+name+",\nThanks for registering for Intuit'14!\n\\n\n\n\n\n\n\n\n\nKeep up with us @ xxxx https://xxxxx";
		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("xxxxx@gmail.com","xxx"));
		    msg.addRecipient(Message.RecipientType.TO,
		     new InternetAddress(emailid, name));
		    msg.setSubject("xxxx Registration Confirmation");
		    msg.setText(msgBody);
		    Transport.send(msg);

		}  catch (Exception e) {
			
            throw new RuntimeException(e);
		}


	}
}


