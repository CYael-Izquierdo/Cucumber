package tests.pages.android.calculator;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.pages.MobileBasePage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorPage extends MobileBasePage {

    //*********Constructor*********
    public CalculatorPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //*********WebElements*********
    // Numbers
    @FindBy(id = "digit_0")
    private WebElement btnZeroBy;
    @FindBy(id = "digit_1")
    private WebElement btnOneBy;
    @FindBy(id = "digit_2")
    private WebElement btnTwoBy;
    @FindBy(id = "digit_3")
    private WebElement btnThreeBy;
    @FindBy(id = "digit_4")
    private WebElement btnFourBy;
    @FindBy(id = "digit_5")
    private WebElement btnFiveBy;
    @FindBy(id = "digit_6")
    private WebElement btnSixBy;
    @FindBy(id = "digit_7")
    private WebElement btnSevenBy;
    @FindBy(id = "digit_8")
    private WebElement btnEightBy;
    @FindBy(id = "digit_9")
    private WebElement btnNineBy;

    //Operation
    @FindBy(id = "op_div")
    private WebElement btnDivBy;
    @FindBy(id = "op_mul")
    private WebElement btnMulBy;
    @FindBy(id = "op_sub")
    private WebElement btnSubBy;
    @FindBy(id = "op_add")
    private WebElement btnAddBy;
    @FindBy(id = "del")
    private WebElement btnDelBy;
    @FindBy(id = "eq")
    private WebElement btnEqBy;
    @FindBy(id = "dec_point")
    private WebElement btnPointBy;

    // Advanced operations
    @FindBy(id = "pad_advanced")
    private WebElement padAdvancedBy;
    @FindBy(id = "toggle_inv")
    private WebElement btnInvBy;
    @FindBy(id = "toggle_mode")
    private WebElement btnModeBy;
    @FindBy(id = "fun_cos")
    private WebElement btnCosBy;

    // Result
    @FindBy(id = "formula")
    private WebElement txtFormulaBy;
    @FindBy(id = "result")
    private WebElement txtResultBy;

    //*********PageMethods*********

    public CalculatorPage calculateOperation(int num1, String op, int num2) {
        clickNumber(num1);
        clickOperation(op);
        clickNumber(num2);
        return this;
    }

    private void clickNumber(int number) {
        List<Integer> numberList = intToList(number);
        for (int i = numberList.size() - 1; 0 <= i; i--) clickIndividualNumber(numberList.get(i));
    }

    private List<Integer> intToList(int num) {
        List<Integer> list = new ArrayList<Integer>();
        while (num > 0) {
            list.add( num % 10 );
            num /= 10;
        }
        return list;
    }

    public CalculatorPage verifyFormula(int num1, String op, int num2) {
        String formula = num1 + op + num2;
        assertThat(txtFormulaBy.getText()).isEqualTo(formula);
        return this;
    }

    public CalculatorPage verifyResult(int expectedResult) {
        assertThat(txtResultBy.getText()).isEqualTo(String.valueOf(expectedResult));
        return this;
    }

    private void clickOperation(String op) {
        switch (op) {
            case "+":
                btnAddBy.click();
                break;
            case "-":
                btnSubBy.click();
                break;
            case "*":
                btnMulBy.click();
                break;
            case "/":
                btnDivBy.click();
                break;
        }
    }

    private void clickIndividualNumber(int num) {
        switch (num) {
            case 0:
                btnZeroBy.click();
                break;
            case 1:
                btnOneBy.click();
                break;
            case 2:
                btnTwoBy.click();
                break;
            case 3:
                btnThreeBy.click();
                break;
            case 4:
                btnFourBy.click();
                break;
            case 5:
                btnFiveBy.click();
                break;
            case 6:
                btnSixBy.click();
                break;
            case 7:
                btnSevenBy.click();
                break;
            case 8:
                btnEightBy.click();
                break;
            case 9:
                btnNineBy.click();
                break;
        }

    }

}
