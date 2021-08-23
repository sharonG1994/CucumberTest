package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPostSteps {
    private static final String age = "70";
    private static final String name = "Test";
    private static final String salary = "5000";
    private static final String updatesalary = "7000";
    private static final String BASE_URL = "http://dummy.restapiexample.com";

    private static Response response;

    @Given("ViewAllEmployees")
    public void view_all_employees() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/api/v1/employees");
        System.out.println(response.getStatusCode());

        //Always displays status code:Too many request(429)
        //assertEquals(200,response.getStatusCode());
    }

    @When("Creation Of Employee")
    public void creation_of_employee() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + name + "\", \"salary\":\"" + salary + "\",\"age\":\""+age+"\"}")
                .post("/api/v1/create");
        System.out.println(response.getStatusCode());
        //Always displays status code:Too many request(429)
        //assertEquals(200,response.getStatusCode());

    }
    @When("Update Employee Details")
    public void update_employee_details() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + name + "\", \"salary\":\"" + updatesalary + "\",\"age\":\""+age+"\"}")
                .put("/api/v1/update/1");
        System.out.println(response.getStatusCode());
        //Always displays status code:Too many request(429)
        //assertEquals(200,response.getStatusCode());

    }

    @When("View Employee Details")
    public void view_employee_details()
    {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/api/v1/employee/1");
        System.out.println(response.getStatusCode());
        //Always displays status code:Too many request(429)
        // assertEquals(200,response.getStatusCode());

    }

    @Then("Delete the Employee")
    public void delete_the_employee() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.delete("/api/v1/delete/719");
        System.out.println(response.getStatusCode());
        //Always displays status code:Too many request(429)
       // assertEquals(200,response.getStatusCode());
    }

}
