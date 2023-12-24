package com.general.ecommerce.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Configuration for enabling cross site origin request. */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Optional<ObjectMapper> registeredObjectMapper = getRegisteredObjectMapper(converters);
    if (registeredObjectMapper.isPresent()) {
      setupObjectMapper(registeredObjectMapper.get());
    } else {
      converters.add(createJacksonConverter());
    }
  }

  private Optional<ObjectMapper> getRegisteredObjectMapper(
          List<HttpMessageConverter<?>> converters) {
    return converters.stream()
            .filter(MappingJackson2HttpMessageConverter.class::isInstance)
            .findFirst()
            .map(MappingJackson2HttpMessageConverter.class::cast)
            .map(MappingJackson2HttpMessageConverter::getObjectMapper);
  }

  private void setupObjectMapper(ObjectMapper objectMapper) {
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  private MappingJackson2HttpMessageConverter createJacksonConverter() {
    ObjectMapper mapper = new ObjectMapper();
    setupObjectMapper(mapper);
    return new MappingJackson2HttpMessageConverter(mapper);
  }
}
