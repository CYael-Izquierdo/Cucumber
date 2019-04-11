package tests.pages.android.calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import tests.pages.MobileBasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorPage extends MobileBasePage {

    //*********Constructor*********
    public CalculatorPage(AppiumDriver driver) { super(driver); }

    //*********WebElements*********
    // Numbers
    private By btnZeroBy = MobileBy.id("digit_0");
    private By btnOneBy = MobileBy.id("digit_1");
    private By btnTwoBy = MobileBy.id("digit_2");
    private By btnThreeBy = MobileBy.id("digit_3");
    private By btnFourBy = MobileBy.id("digit_4");
    private By btnFiveBy = MobileBy.id("digit_5");
    private By btnSixBy = MobileBy.id("digit_6");
    private By btnSevenBy = MobileBy.id("digit_7");
    private By btnEightBy = MobileBy.id("digit_8");
    private By btnNineBy = MobileBy.id("digit_9");

    //Operation
    private By btnDivBy = MobileBy.id("op_div");
    private By btnMulBy = MobileBy.id("op_mul");
    private By btnSubBy = MobileBy.id("op_sub");
    private By btnAddBy = MobileBy.id("op_add");
    private By btnDelBy = MobileBy.id("del");
    private By btnEqBy= MobileBy.id("eq");
    private By btnPointBy= MobileBy.id("dec_point");

    // Advanced operations
    private By padAdvancedBy = MobileBy.id("pad_advanced");
    private By btnInvBy= MobileBy.id("toggle_inv");
    private By btnModeBy= MobileBy.id("toggle_mode");
    private By btnCosBy= MobileBy.id("fun_cos");

    // Result
    private By txtFormulaBy = MobileBy.id("formula");
    private By txtResultBy = MobileBy.id("result");

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
        assertEquals(txtFormulaBy, formula);
        return this;
    }

    public CalculatorPage verifyResult(int expectedResult) {
        assertEquals(txtResultBy, String.valueOf(expectedResult));
        return this;
    }

    private void clickOperation(String op) {
        switch (op) {
            case "+":
                click(btnAddBy);
                break;
            case "-":
                click(btnSubBy);
                break;
            case "*":
                click(btnMulBy);
                break;
            case "/":
                click(btnDivBy);
                break;
        }
    }

    private void clickIndividualNumber(int num) {
        switch (num) {
            case 0:
                click(btnZeroBy);
                break;
            case 1:
                click(btnOneBy);
                break;
            case 2:
                click(btnTwoBy);
                break;
            case 3:
                click(btnThreeBy);
                break;
            case 4:
                click(btnFourBy);
                break;
            case 5:
                click(btnFiveBy);
                break;
            case 6:
                click(btnSixBy);
                break;
            case 7:
                click(btnSevenBy);
                break;
            case 8:
                click(btnEightBy);
                break;
            case 9:
                click(btnNineBy);
                break;
        }

    }

}
