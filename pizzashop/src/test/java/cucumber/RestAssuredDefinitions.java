package cucumber;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDefinitions implements En {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    public RestAssuredDefinitions() {
        Given("the shop has a pizza {string}", (String pizza) -> {
            System.out.format("Pizza: %s", pizza);
        });

        When("I request {string}", (String path) -> {
            response = when().get(path);
        });

        Then("the response code is {int}", (Integer statusCode) -> {
            json = response.then().statusCode(statusCode);
        });

        Then("the response body is", (String body) -> {
            json.body(equalTo(body));
        });
    }
}
