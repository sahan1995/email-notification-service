/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.repository;

import lk.sahan.notification.email.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {

    Optional<Template> findByTemplateNumber( Long templateNumber );
}
