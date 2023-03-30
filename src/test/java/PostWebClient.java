//import au.com.dius.pact.consumer.MockServer;
//import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
//import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
//import au.com.dius.pact.consumer.junit5.PactTestFor;
//import au.com.dius.pact.core.model.PactSpecVersion;
//import au.com.dius.pact.core.model.RequestResponsePact;
//import au.com.dius.pact.core.model.annotations.Pact;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.http.*;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.ClientResponse;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
////import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
//
//@ExtendWith(PactConsumerTestExt.class)
//@PactTestFor(pactVersion = PactSpecVersion.V3,providerName = "test_provider", hostInterface="localhost")
//public class PostWebClient {
//
////    @Pact(provider="test_provider", consumer = "test_consumer")
////    public RequestResponsePact createPact(PactDslWithProvider builder) {
////        Map<String, String> headers = new HashMap<>();
////        headers.put("Content-Type", "application/json");
////
////        return builder
////                .given("test GET")
////                .uponReceiving("GET REQUEST")
////                .path("/pact")
////                .method("GET")
////                .willRespondWith()
////                .status(200)
////                .headers(headers)
////                .body("{\"condition\": true, \"name\": \"tom\"}")
////                .given("test POST")
////                .uponReceiving("POST REQUEST")
////                .method("POST")
////                .headers(headers)
////                .body("{\"name\": \"Michael\"}")
////                .path("/pact")
////                .willRespondWith()
////                .status(201)
////                .toPact();
////    }
//
//    @Pact(provider="test_provider", consumer = "test_consumer")
//    public RequestResponsePact pact_post_request(PactDslWithProvider builder) {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//      return   builder
//                .given("test POST")
//                .uponReceiving("NEW POST REAUEST")
//                .method("POST")
//                .headers(headers)
//                .body("{\"name\": \"Michael\"}")
//                .path("/newPact")
//                .willRespondWith()
//                .status(200)
//                .toPact();
//    }
//
////    @Test
////    @PactTestFor(pactMethod = "createPact")
////    void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody(MockServer mockServer) {
////        WebTestClient.bindToServer().baseUrl(mockServer.getUrl()).build()
////                .get()
////                .uri("/pact")
////                .exchange()
////                .expectStatus().isOk()
////                .expectHeader().contentType("application/json")
////                .expectBody().json("{\"name\": \"tom\"}");
////
////    // when
////        ResponseEntity<String> response = new RestTemplate().getForEntity(mockServer.getUrl() + "/pact", String.class);
////
////        // then
////        assertThat(response.getStatusCode().value()).isEqualTo(200);
////        assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();
////        assertThat(response.getBody()).contains("condition", "true", "name", "tom");
////
////        // and
////        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        String jsonBody = "{\"name\": \"Michael\"}";
////
////        // when
////        ResponseEntity<String> postResponse = new RestTemplate().exchange(mockServer.getUrl() + "/pact", HttpMethod.POST, new HttpEntity<>(jsonBody, httpHeaders), String.class);
////
////        // then
////        assertThat(postResponse.getStatusCode().value()).isEqualTo(201);
////    }
//
////    @Test
////    @PactTestFor(pactMethod = "pact_post_request")
////    void givenGet_lala_shouldStatus200(MockServer mockServer) {
////        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
////        String jsonBody = "{\"name\": \"Michael\"}";
////
////        WebTestClient.bindToServer().baseUrl(mockServer.getUrl()).build()
////                .post()
////                .uri("/pact")
////                .accept(MediaType.APPLICATION_JSON)
////                .body(BodyInserters.fromValue("{\"name\": \"Michael\"}"))
////                .exchange()
////                .expectStatus().isOk()
////                .expectHeader().contentType("application/json")
////                .expectBody().json("{\"name\": \"tom\"}");
////
////
////    }
//
//    @Test
//    @PactTestFor(pactMethod = "pact_post_request")
//    void givenGet_lala_shouldStatus200(MockServer mockServer) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        String jsonBody = "{\"name\": \"Michael\"}";
//
//        var webClient = WebClient.create(mockServer.getUrl());
//
//        var exchange = webClient
//                .post()
//                .uri("/pact")
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue("{\"name\": \"Michael\"}"))
//                .retrieve().bodyToMono(String.class);
////                .expectStatus().isOk()
////                .expectHeader().contentType("application/json")
////                .expectBody().json("{\"name\": \"tom\"}");
//
//        StepVerifier.create(exchange)
//                .assertNext(s->assertThat(s).isNotBlank())
//                .verifyComplete();
//
//
//    }
//
//}