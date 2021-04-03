/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lk.sahan.notification.email.model.request.SendMailRQ;
import lk.sahan.notification.email.repository.TemplateRepository;
import lk.sahan.notification.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender sender;

    private final Configuration configuration;

    private final TemplateRepository templateRepository;


    @Override
    public boolean sendEmail( SendMailRQ sendMailRQ ) {

        Optional<lk.sahan.notification.email.entity.Template> byTemplateNumber =
                templateRepository.findByTemplateNumber(sendMailRQ.getTemplateNumber());

        if(!byTemplateNumber.isPresent()) return false;


        lk.sahan.notification.email.entity.Template templateDb =
                byTemplateNumber.get();

        MimeMessage mimeMessage = sender.createMimeMessage();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String fileName = templateDb.getTemplateName() +".ftl";
            File file = new File(classLoader.getResource(".").getFile() + "/templates/" + fileName);
            file.createNewFile();

            List<String> lines = Arrays.asList(templateDb.getTemplate());


            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);

            MimeMessageHelper helper = new MimeMessageHelper( mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name() );

            Template template = configuration.getTemplate(fileName);
            String htmlTemplate =
                    FreeMarkerTemplateUtils.processTemplateIntoString(template, sendMailRQ.getValues());
            helper.setTo(sendMailRQ.getTo());
            helper.setText(htmlTemplate, true);
            helper.setSubject(sendMailRQ.getSubject());
            sender.send(mimeMessage);

            return true;

        }catch (MessagingException | IOException | TemplateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
