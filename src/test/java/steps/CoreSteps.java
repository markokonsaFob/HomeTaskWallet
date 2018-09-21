package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cify.framework.core.DeviceCategory;
import io.cify.framework.core.DeviceManager;

/**
 * Created by FOB Solutions
 */
public class CoreSteps {

    @Before
    public void createBrowser() {
        DeviceManager.getInstance().createDevice(DeviceCategory.BROWSER);
    }

    @After(order = 0)
    public void closeBrowsers() {
        try {
            DeviceManager.getInstance().quitAllDevices();
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println("Cannot quit browser cause: " + message);
        }
    }
}
