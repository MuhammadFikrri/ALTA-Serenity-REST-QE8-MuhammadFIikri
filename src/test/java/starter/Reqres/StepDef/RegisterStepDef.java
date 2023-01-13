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

public class RegisterStepDef
{
    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid json input")
    public void registerUserWithValidJson()
    {
        File json = new File(Constant.JSON_REQUEST + "/RegisterRequest.json");
        reqresAPI.registerUser(json);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser()
    {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterSuccessSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(jsonSchema));
    }

    @Given("Register user with valid email and blank password")
    public void registerUserWithInvalidJson()
    {
        File json = new File(Constant.JSON_REQUEST + "/RegisterInvalid.json");
        reqresAPI.registerUser(json);
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterFailedSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(jsonSchema));
    }
}
