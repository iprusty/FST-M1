package Projects;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    // Set the headers
	Map<String, String> headers = new HashMap<>();

    // Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        // Set the headers
    	headers.put("Content-Type", "application/json");
    	// The request and response body
    	DslPart reqResBody = new PactDslJsonBody().
			numberType("id", 321).
			stringType("firstName", "ipsita").
			stringType("lastName", "prusty").
			stringType("email", "ipsita@example.com");
    	
    	// Create the Pact
    	return builder.given("POST Request")
			.uponReceiving("A request to create a user")
				.method("POST")
				.path("/api/users")
				.headers(headers)
				.body(reqResBody)
			.willRespondWith()
				.status(201)
				.body(reqResBody)
			.toPact();
	}

    // Consumer test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest() {
        // Create a request body
    	Map<String, Object> reqBody = new HashMap<>();
    	reqBody.put("id", 123);
    	reqBody.put("firstName", "Saahil");
    	reqBody.put("lastName", "Sharma");
    	reqBody.put("email", "saahil@example.com");
    	
    	// Send request, get response, add assertions
    	given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all()
    	.when().post()
    	.then().statusCode(201).body("firstName", equalTo("Saahil")).log().all();
    }
}
