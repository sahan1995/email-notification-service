/**
 * @author Sahan Rajakaruna
 */
package lk.sahan.notification.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class EmailConfig {

    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean configurationFactoryBean() {

        FreeMarkerConfigurationFactoryBean bean =
                new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
