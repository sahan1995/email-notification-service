/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.controller;

import lk.sahan.notification.email.model.request.SendMailRQ;
import lk.sahan.notification.email.model.response.MailRS;
import lk.sahan.notification.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/email")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping(value = "send")
    public MailRS sendEmail( @RequestBody SendMailRQ sendMailRQ) {

        boolean result = emailService.sendEmail(sendMailRQ);
        return MailRS.builder()
                .status(result)
                .message(result ? "Email send successfully to " + sendMailRQ.getTo() : "Unable to send email !!")
                .build();

    }
}
