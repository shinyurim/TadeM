package project.TadeM.components;


import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MailComponents {

	private final JavaMailSender javaMailSender;
	private final Logger logger = LoggerFactory.getLogger(MailComponents.class);

	public boolean sendMail(String mail, String subject, String text) {

		boolean result = false;

		MimeMessagePreparator msg = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,
					"UTF-8");
				mimeMessageHelper.setTo(mail);
				mimeMessageHelper.setSubject(subject);
				mimeMessageHelper.setText(text);
			}
		};
		try {
			javaMailSender.send(msg);
			result = true;
		} catch (Exception e) {
			logger.info(e.getMessage()); // sout -> logger로 수정
		}
		return result;
	}
}
