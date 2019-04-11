package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utilities.DeviceFactory.getDevice;
import static utilities.DeviceFactory.startMacAppiumServer;

public class Framework {

    private static Context context;
    private static WebDriver webdriver = null;
    private static AppiumDriver appiumDriver = null;
    private static final HashMap<String, Object> serverParameters = new HashMap<String, Object>();
    public static JsonConfigReader jsonConfigReader = new JsonConfigReader();
    private static Map<String, Object> capMap;
    private static Map<String, Object> capVideoMap;
    private static DataTable table;

    public static AppiumDriver setup_appium_driver(DataTable table, String config) throws Exception {
        capMap = jsonConfigReader.getAppiumJsonConfig(config);
        context = Context.getContext();

        updateCapabilities(table);

        String device = capMap.get("platformName").toString();
        String hub_url = context.getValue("gridServerUrl").toString();

        //LOCAL APPIUM
        if (hub_url.equals("")) {
            String address = BaseUtil.getAppiumServerAddress();
            String port = BaseUtil.getAppiumServerPort();
            serverParameters.put("address", address);
            serverParameters.put("port", port);

            //String appium_server_url = "http://" + address + ":" + port + "/wd/hub";

            if (context.getValue("appium_subprocess") == null) {
                context.setValue("appium_subprocess", start_appium_server(serverParameters, new DesiredCapabilities(capMap)));
                context.setValue("appium_server_url", "http://" + address + ":" + port + "/wd/hub"); //added
            }

            //appiumDriver = create_appium_driver(device, appium_server_url, new DesiredCapabilities(capMap));
            appiumDriver = create_appium_driver(device, (String) context.getValue("appium_server_url"), new DesiredCapabilities(capMap)); //added
        }

        //REMOTE APPIUM
        else {
            appiumDriver = create_appium_driver(device, hub_url, new DesiredCapabilities(capMap));
        }

        return appiumDriver;
    }

    public static AppiumDriver create_appium_driver(String device,String url, DesiredCapabilities capability) throws
            MalformedURLException {
        appiumDriver = getDevice(device,url,capability);
        return appiumDriver;
    }

    private static AppiumDriverLocalService start_appium_server(HashMap<String, Object> serverParameters, DesiredCapabilities desiredCapabilities) {
        return startMacAppiumServer(serverParameters.get("address").toString(), Integer.parseInt(serverParameters.get("port").toString()), desiredCapabilities);
    }

    public static void updateCapabilities(DataTable table) {
        if (table != null) {
            Map<String, String> mapTable = table.asMap(String.class, String.class);
            for (Map.Entry<String, String> entry : mapTable.entrySet()) {
                if (entry.getKey().equals("appWaitDuration")) {
                    capMap.put(entry.getKey(), Integer.parseInt(entry.getValue()));
                } else {
                    capMap.put(entry.getKey(), entry.getValue());
                }

            }
        }
    }



}
