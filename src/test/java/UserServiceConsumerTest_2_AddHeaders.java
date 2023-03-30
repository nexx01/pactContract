import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.example.ConsumerApplication;
import org.example.IdObject;
import org.example.User;
import org.example.UserClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(PactConsumerTestExt.class)
@ExtendWith(SpringExtension.class)
@PactTestFor(pactVersion = PactSpecVersion.V3,providerName = "userservice", port = "8888")
@SpringBootTest(classes={ConsumerApplication.class},properties = {
        // overriding provider address
        "userservice.ribbon.listOfServers: localhost:8888"
})
public class UserServiceConsumerTest_2_AddHeaders {

  @Autowired
  private UserClient userClient;

  @Pact(provider = "userservice", consumer = "userclient")
  public RequestResponsePact createPersonPact(PactDslWithProvider builder) {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    return builder
            .given("provider accepts a new person")
            .uponReceiving("a request to POST a person")
            .headers(headers)
            .path("/user-service/users")
            .method("POST")
            .willRespondWith()
            .status(201)
            .matchHeader("Content-Type", "application/json")
            .body(new PactDslJsonBody()
                    .integerType("id", 42))
            .toPact();
    // @formatter:on
  }

  @Test
  @PactTestFor(pactMethod = "createPersonPact")
  public void verifyCreatePersonPact() {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    User user = new User();
    user.setFirstName("Zaphod");
    user.setLastName("Beeblebrox");
    IdObject id = userClient.createUser(user,headers);
    assertEquals(id.getId(), 42);
  }

  @Test
  @PactTestFor(pactMethod = "createPersonPact")
  public void verifyCreatePersonPactWebClient() {
    var webClient = WebClient.create("http://localhost:8888");

    User user = new User();
    user.setFirstName("Zaphod");
    user.setLastName("Beeblebrox");

    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    var idObjectMono = webClient
            .post().uri("/user-service/users")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(user))
            .retrieve()
            .bodyToMono(IdObject.class);

    StepVerifier.create(idObjectMono)
            .assertNext(id -> assertEquals(id.getId(), 42))
            .verifyComplete();

  }

  @Test
  @PactTestFor(pactMethod = "createPersonPact")
  public void verifyCreatePersonPactWebTestClient() {
    var build = WebTestClient.bindToServer().baseUrl("http://localhost:8888").build();

    User user = new User();
    user.setFirstName("Zaphod");
    user.setLastName("Beeblebrox");


    var idObject = build
            .post().uri("/user-service/users")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(user))
            .exchange()
            .expectStatus().isCreated()
            .expectBody(new ParameterizedTypeReference<IdObject>() {
            })
            .returnResult().getResponseBody();


    assertEquals(idObject.getId(), 42);
  }

}