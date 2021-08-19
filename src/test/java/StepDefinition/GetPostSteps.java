package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.AssertJUnit.assertEquals;

public class GetPostSteps {
    private static final String age = "70";
    private static final String name = "Test";
    private static final String salary = "5000";
    private static final String Updatesalary = "7000";
    private static final String BASE_URL = "http://dummy.restapiexample.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;



    @Given("Get Single Employee")
    public void get_single_employee()
    {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/api/v1/employee/1");
        System.out.println(response.getStatusCode());
       assertEquals(200,response.getStatusCode());

    }
    @When("ViewAllEmployees")
    public void view_all_employees() {
        RestAssured.baseURI = BASE_URL;
             RequestSpecification request = RestAssured.given();
        response = request.get("/api/v1/employees");
        System.out.println(response.getStatusCode());

        //Always display too many request
        //assertEquals(200,response.getStatusCode());


    }
    @When("CreateNewEmployee")
    public void create_new_employee() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + name + "\", \"salary\":\"" + salary + "\",\"age\":\""+age+"\"}")
                .post("/api/v1/create");
        System.out.println(response.getStatusCode());
        //String jsonString = response.asString();
        //token = JsonPath.from(jsonString).get("token");

    }
    @When("UpdateTheEmployeeDetails")
    public void update_the_employee_details() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"name\":\"" + name + "\", \"salary\":\"" + Updatesalary + "\",\"age\":\""+age+"\"}")
                .put("/api/v1/update/1");
        System.out.println(response.getStatusCode());
        //String jsonString = response.asString();
        //token = JsonPath.from(jsonString).get("token");

    }
    @Then("DeleteTheEmployee")
    public void delete_the_employee() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.delete("/api/v1/delete/719");
        System.out.println(response.getStatusCode());

    }

}
