package tests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import tests.pages.android.calculator.CalculatorPage;
import utilities.Context;

public class AndroidCalculatorSteps{

    private Context context;
    private AppiumDriver driver;

    public AndroidCalculatorSteps(){
        this.context = Context.getContext();
        driver = (AppiumDriver) context.getValue("driver");
    }

    @When("I add ([^\"]*) and ([^\"]*)")
    public void iAdd(int first_num, int second_num) {
        String operation = "+";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage
                .calculateOperation(first_num, operation, second_num)
                .verifyFormula(first_num, operation, second_num);
    }

    @Then("I check that result is equal to ([^\"]*)")
    public void iCheckThatResultIsEqualToExpectedResult(int expectedResult){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage
                .verifyResult(expectedResult);
    }

}
