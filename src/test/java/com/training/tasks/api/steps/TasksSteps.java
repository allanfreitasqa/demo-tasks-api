package com.training.tasks.api.steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

public class TasksSteps {

    private Response response;

    @When("the client calls GET Tasks")
    public void the_client_calls_GET_Tasks() {
        response = when().get("/tasks");
    }

    @Then("the api returns with status code {int}")
    public void the_api_returns_status_code_of(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    @When("POST request is made with a valid payload")
    public void post_with_payload_file(){
        File jsonData = new File("src/test/resources/payload.json");
        response = given().contentType(ContentType.JSON).body(jsonData).when().post("/tasks");
    }
}
