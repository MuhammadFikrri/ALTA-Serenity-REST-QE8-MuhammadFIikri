package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef
{
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page)
    {
        reqresAPI.setGetListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser()
    {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyShouldPagePage(int page)
    {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Tugas scenario 1
    @Given("Get list user with total user per page {int} and total page {int}")
    public void getListUserWithPerPage(int perPage, int totalPage)
    {
        reqresAPI.setGetListUserPerPage(perPage,totalPage);
    }

    @When("Send request get list user with modified parameter")
    public void sendRequestGetListUserModified()
    {
        SerenityRest.when().get(ReqresAPI.GET_LIST_MODIFIED);
    }

    //Tugas scenario 2
    @Given("Get list user with page {string}")
    public void getListUserWithPage(String page)
    {
        reqresAPI.getListUsersInvalid(page);
    }
}
