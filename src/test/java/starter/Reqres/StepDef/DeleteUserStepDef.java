package starter.Reqres.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef
{
    @Steps
    ReqresAPI reqresAPI;

    //scenario 4
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id)
    {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser()
    {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    //Tugas scenario 1
    @Given("Delete user with invalid id input {string}")
    public void deleteUserWithInvalidId(String id)
    {
        reqresAPI.deleteInvalidUser(id);
    }
}
