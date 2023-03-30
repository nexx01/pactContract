package org.example.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import reactivefeign.webclient.WebClientFeignCustomizer;

//@Configuration
public class ReactFeqignConfig {

    @Bean
    public WebClientFeignCustomizer webClientFeignCustomizer() {

        return builder -> {
            builder.codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(new ObjectMapper()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL), MediaType.APPLICATION_JSON)));
        };
    }
}
