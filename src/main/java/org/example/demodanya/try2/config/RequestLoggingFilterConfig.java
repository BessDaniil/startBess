package org.example.demodanya.try2.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestLoggingFilterConfig implements WebMvcConfigurer {
    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(100000);
        loggingFilter.setIncludeHeaders(false);
        loggingFilter.setAfterMessagePrefix("REQUEST DATA: ");
        return loggingFilter;
    }
}
