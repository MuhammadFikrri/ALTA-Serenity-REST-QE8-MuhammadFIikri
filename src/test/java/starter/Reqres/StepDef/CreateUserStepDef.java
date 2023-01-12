package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef
{
    @Steps
    ReqresAPI reqresAPI;

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

    //Tugas scenario 1
    @Given("Post create user with blank name and job")
    public void postCreateUserWithBlankJson()
    {
        File json = new File(ReqresAPI.JSON_REQUEST+"/CreateUserBlank.json");
        reqresAPI.setPostCreateUser(json);
    }

    //Tugas scenario 2
    @Given("Post create user with category name, job and age")
    public void postCreateUserWithExtraJson()
    {
        File json = new File(ReqresAPI.JSON_REQUEST+"/ExtraCategory.json");
        reqresAPI.setPostCreateUser(json);
    }

    @And("Response body name should be {string}, job {string} and age {string}")
    public void responseBodyNameJobAndAge(String name, String job, String age)
    {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("job",equalTo(job))
                .body("age",equalTo(age));
    }
}