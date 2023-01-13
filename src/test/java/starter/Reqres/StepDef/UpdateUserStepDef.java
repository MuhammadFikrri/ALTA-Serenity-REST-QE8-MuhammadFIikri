package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.Utils.Constant;

import java.io.File;

public class UpdateUserStepDef
{
    @Steps
    ReqresAPI reqresAPI;

    //scenario 3
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id)
    {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser()
    {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Tugas scenario 1
    @Given("Put update user with category name, job and age with id {int}")
    public void putUpdateUserWithExtraJson(int id)
    {
        File json = new File(Constant.JSON_REQUEST+"/ExtraCategory.json");
        reqresAPI.putUpdateInvalidUser(id,json);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Tugas scenario 2
    @Given("Put update user with blank name and job with id {int}")
    public void putUpdateUserWithBlankJson(int id)
    {
        File json = new File(Constant.JSON_REQUEST+"/CreateUserBlank.json");
        reqresAPI.putUpdateInvalidUser(id,json);
    }
}
