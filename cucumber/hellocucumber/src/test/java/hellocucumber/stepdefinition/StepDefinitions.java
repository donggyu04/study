package hellocucumber.stepdefinition;

import hellocucumber.Day;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static hellocucumber.Day.FRI;
import static hellocucumber.Day.SUN;
import static java.lang.Boolean.valueOf;
import static org.junit.Assert.*;

public class StepDefinitions {

    private Day today;
    private Boolean result;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = SUN;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        result = FRI.equals(today);
        throw new RuntimeException("Oops");
    }

    @Then("I should be told {booleanValue}")
    public void iShouldBeTold(Boolean expected) {
        assertEquals(expected, result);
    }

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return valueOf(value);
    }
}
