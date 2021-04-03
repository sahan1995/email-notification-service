/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.model.request;

import lombok.Data;

import java.util.Map;

@Data
public class SendMailRQ {

    private String to;

    private String subject;

    private Long templateNumber;

    private Map<String, Object> values;

}
