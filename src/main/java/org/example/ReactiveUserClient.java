package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.ReactFeqignConfig;
import org.example.dto.Car;
import org.example.dto.RequestWrapperDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactivefeign.webclient.WebClientFeignCustomizer;
import reactor.core.publisher.Mono;

import java.util.Map;

@ReactiveFeignClient(name = "userservice", url = "http://localhost:8888", configuration = ReactFeqignConfig.class)
public interface ReactiveUserClient {

    @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
    Mono<IdObject> createUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
    Mono<IdObject> createUser(@RequestBody User user, @RequestHeader Map<String, String> headers);


    @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
    Mono<IdObject> createUser(@RequestBody RequestWrapperDto<User> user, @RequestHeader Map<String, String> headers);

    @RequestMapping(method = RequestMethod.POST, path = "/user-service/car")
    Mono<IdObject> createCar(@RequestBody RequestWrapperDto<Car> user, @RequestHeader Map<String, String> headers);

    @Configuration
    static class CustomConfiguration {

//    private static final int MAX_CODEC_MEMORY_SIZE = 2 * 1024 * 1024;

        @Bean
        public WebClientFeignCustomizer webClientFeignCustomizer(Module... modules) {
//      final ObjectMapper objectMapper = new ObjectMapper()
//              .registerModules(modules)
//              .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//              .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

            return builder -> {
                builder.codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(new ObjectMapper()
                        .setSerializationInclusion(JsonInclude.Include.NON_NULL), MediaType.APPLICATION_JSON)));
//        builder.exchangeStrategies(
//                buildExchangeStrategies(objectMapper));
            };
        }

//    public static ExchangeStrategies buildExchangeStrategies(ObjectMapper objectMapper) {
//      objectMapper.registerModule(new JavaTimeModule());
//      return ExchangeStrategies.builder().codecs(
//              configurer -> {
//                configurer.defaultCodecs().maxInMemorySize(MAX_CODEC_MEMORY_SIZE);
//                configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON));
//                configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON));
//              }
//      ).build();
//    }

    }
}

