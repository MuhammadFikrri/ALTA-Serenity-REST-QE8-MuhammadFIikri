package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef
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
        SerenityRest.then().body("page", equalTo(page));
    }

    // Scenario 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson()
    {
        File json = new File(ReqresAPI.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.setPostCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser()
    {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job)
    {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }
}
