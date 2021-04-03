/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailRS {
    private String message;
    private boolean status;
}
