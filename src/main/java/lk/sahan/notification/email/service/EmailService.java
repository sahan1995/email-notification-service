/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.service;

import lk.sahan.notification.email.model.request.SendMailRQ;

public interface EmailService {

    public boolean sendEmail( SendMailRQ sendMailRQ );
}
