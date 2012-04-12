package br.com.coding.dojo.fakesmtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

public class MailSenderTest {

	private SimpleSmtpServer smtpServer;

	@Before
	public void setUp() {
		smtpServer = SimpleSmtpServer.start(8000);
	}

	@After
	public void tearDown() {
		smtpServer.stop();
	}

	@Test
	public void shouldSentAnEmailToLuizaAtCanadaSuccessfully() throws Exception {
		MailSender mailSender = new MailSender();
		boolean wasSent = mailSender.send();

		assertEquals("Should recieved a email", 1, smtpServer.getReceivedEmailSize());

		Iterator receivedEmail = smtpServer.getReceivedEmail();
		SmtpMessage message = (SmtpMessage) receivedEmail.next();
		assertEquals("Mensagem", message.getBody());
		assertTrue("The mail need to be sent successfully", wasSent);
	}

}
