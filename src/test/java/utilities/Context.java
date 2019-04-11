package utilities;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.Map;


public class Context {

    private static Context instance = null;
    private Map<String, Object> context;

    private Context() {
        context = new HashMap<String, Object>();
    }

    public static Context getContext() {
        if (instance == null){
            instance = new Context();
        }
        return instance;
    }

    public Context setValue(String key, DataTable value) {
        context.put(key, value);

        return this;
    }

    public Context setValue(String key, HashMap value) {
        context.put(key, value);

        return this;
    }

    public Context setValue(String key, String value) {
        context.put(key, value);

        return this;
    }

    public Context setValue(String key, Map value) {
        context.put(key, value);

        return this;
    }

    public Context setValue(String key, HashMap<String, Object>[] value) {
        context.put(key, value);

        return this;
    }

    public Context setValue(String key, AppiumDriverLocalService value) {
        context.put(key, value);

        return this;
    }

    ////////////////// New variables for Refactor //////////////////
    public Context setValue(String key, WebDriver value) {
        context.put(key, value);

        return this;
    }
    ////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public Object getValue(String key) {
        return context.get(key);
    }

}
