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

public class LoginStepDef
{
    @Steps
    ReqresAPI reqresAPI;

    @Given("User login with valid username and password")
    public void userLoginWithValidInput()
    {
        File json = new File(Constant.JSON_REQUEST + "/LoginRequest.json");
        reqresAPI.loginUser(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser()
    {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Validate json schema success login user")
    public void validateJsonSchemaLoginUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginSuccessSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(jsonSchema));
    }

    @Given("User login with valid username and blank password")
    public void userLoginWithBlankPassword()
    {
        File json = new File(Constant.JSON_REQUEST + "/LoginInvalid.json");
        reqresAPI.loginUser(json);
    }

    @And("Validate json schema failed login user")
    public void validateJsonSchemaFailedLoginUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginFailedSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(jsonSchema));
    }
}
