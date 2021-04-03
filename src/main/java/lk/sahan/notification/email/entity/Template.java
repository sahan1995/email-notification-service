/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;

    @Column(unique = true)
    private Long templateNumber;

    @Lob
    @Column(length=8192)
    private String template;
}
