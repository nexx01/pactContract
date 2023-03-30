//import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
//import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
//import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
//import au.com.dius.pact.core.model.RequestResponsePact;
//import au.com.dius.pact.core.model.annotations.Pact;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//@ExtendWith(PactConsumerTestExt.class)
//public class springBootTest {
//
//    @Pact(provider = "userservice", consumer = "userclient")
//    public RequestResponsePact createPersonPact(PactDslWithProvider builder) {
//        // @formatter:off
//        return builder
//                .given("provider accepts a new person")
//                .uponReceiving("a request to POST a person")
//                .path("/user-service/users")
//                .method("POST")
//                .willRespondWith()
//                .status(201)
//                .matchHeader("Content-Type", "application/json")
//                .body(new PactDslJsonBody()
//                        .integerType("id", 42))
//                .toPact();
//        // @formatter:on
//    }
//
//
//
//}
