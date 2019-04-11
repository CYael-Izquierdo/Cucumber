package tests.steps;

import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import utilities.BaseUtil;
import utilities.Context;

import static utilities.Framework.setup_appium_driver;

public class BaseMobileSteps {

    private Context context;
    private AppiumDriver driver;

    public BaseMobileSteps(){
        this.context = Context.getContext();
        driver = (AppiumDriver) context.getValue("driver");
    }

    @Given("([^\"]*) appium driver")
    public void setup_appium(String configName, DataTable dataTable) throws Exception {
        if (dataTable != null) {
            context.setValue("dataTable", dataTable);
        }

        context.setValue("gridServerUrl", BaseUtil.getGridServerUrl());
        Failsafe.with(BaseUtil.getRetryPolicy()).run(() -> driver = setup_appium_driver(dataTable, configName));
        context.setValue("driver", driver);
    }


}


