package com.general.ecommerce.config;

import java.lang.reflect.Field;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {
    
    @Bean
    public Docket produceApi(@Value("${swagger.enabled}") Boolean enabled) {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.general.ecommerce.controller"))
                .build()
                .enable(enabled);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ecommerce project")
                .description("This page list all endpoints available at Ecommerce Service API.")
                .version("1.0-SNAPSHOT")
                .build();
    }

    /**
     * Configure CORS headers.
     *
     * @return Cors header
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Allow anyone and anything access. Probably ok for Swagger spec
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/v2/api-docs", config);
        return new CorsFilter(source);
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName)
                    throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider
                        || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(
                    List<T> mappings) {
                List<T> copy =
                        mappings.stream().filter(mapping -> mapping.getPatternParser() == null).toList();
                mappings.clear();
                mappings.addAll(copy);
            }

            /**
             * Suppressing warnings for java:S3011 because the accessibility update
             * 'field.setAccessible(true)' cannot be removed.
             */
            @SuppressWarnings({"unchecked", "java:S3011"})
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    if (field != null) {
                        field.setAccessible(true);
                        return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                    } else {
                        throw new IllegalStateException("Could not find field handlerMappings");
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}
