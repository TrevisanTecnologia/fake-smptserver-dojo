package br.com.coding.dojo.fakesmtp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public boolean send() throws Exception {

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "localhost");
		properties.setProperty("mail.smtp.port", "8000");

		Session session = Session.getInstance(properties);
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("fulano@foo.com"));
		msg.setRecipient(RecipientType.TO, new InternetAddress("ebohrer@trevisantecnologia.com.br"));
		msg.setSubject("Fake SMTP dojo");
		msg.setContent("Mensagem", "text/plain");

		Transport.send(msg);

		return true;
	}

}
