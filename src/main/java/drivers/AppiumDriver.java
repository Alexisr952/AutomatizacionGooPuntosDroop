package drivers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDriver {
    public static AndroidDriver driver;

    private AppiumDriver() {
        // Constructor privado para evitar instancias de la clase
        // Puedes dejarlo vacío o lanzar una excepción si deseas
    }
    public static AppiumDriver initializeDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            /*            capabilities.setCapability("deviceName", "GM3200");
                        capabilities.setCapability("platformName", "Android");
                        capabilities.setCapability("platformVersion", "11");
                        capabilities.setCapability("automationName", "UiAutomator2");
                        capabilities.setCapability("appPackage", "com.coordinadora.timgoo.qa");
                        capabilities.setCapability("appActivity", "com.coordinadora.timgoo.Session.View.activities.LoginUsernameActivity");
                        capabilities.setCapability("noReset", true);
                        capabilities.setCapability("nativeWebTap", true);
                        capabilities.setCapability("appium:eventTimings", true);
                        capabilities.setCapability("newCommandTimeout", 45000);
                        capabilities.setCapability("udid", "ZE222NGZHZ");*/

//Fabian
 /**           capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("deviceName", "RZCWC0H5P9N");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "15");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "com.coordinadora.timgoo.qa");
            capabilities.setCapability("appActivity", "com.coordinadora.timgoo.Session.View.activities.LoginUsernameActivity");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("nativeWebTap", true);
            capabilities.setCapability("appium:eventTimings", true);
            capabilities.setCapability("newCommandTimeout", 45000);
            capabilities.setCapability("udid", "RZCWC0H5P9N");*/

//Jp           
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("deviceName", "fd99d00a");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "com.coordinadora.timgoo.qa");
            capabilities.setCapability("appActivity", "com.coordinadora.timgoo.Session.View.activities.LoginUsernameActivity");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("nativeWebTap", true);
            capabilities.setCapability("appium:eventTimings", true);
            capabilities.setCapability("newCommandTimeout", 45000);
            capabilities.setCapability("udid", "fd99d00a");



//            capabilities.setCapability("autoGrantPermissions", true); // Para permitir permisos automáticamente
//            capabilities.setCapability("automationName", "UiAutomator2");
//            capabilities.setCapability("deviceName", "M2102J20SG");
//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("platformVersion", "13.0.3");
//            capabilities.setCapability("automationName", "UiAutomator2");
//            capabilities.setCapability("appPackage", "com.coordinadora.timgoo.qa");
//            capabilities.setCapability("appActivity", "com.coordinadora.timgoo.Session.View.activities.LoginUsernameActivity");
//            capabilities.setCapability("noReset", true);
//            capabilities.setCapability("nativeWebTap", true);
//            capabilities.setCapability("appium:eventTimings", true);
//            capabilities.setCapability("newCommandTimeout", 45000);
//            capabilities.setCapability("udid", "a9adacc6");
            URI uri = new URI("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(uri.toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        return new AppiumDriver();
    }

    public static io.appium.java_client.AppiumDriver on() {
        return driver;
    }

    /**
     *SIRVE PARA REALIZAR LA CORRECTA EJECUCION DEL SERVIDOR INTERNO DE APPIUM CON EL PLUGIN FARM DEVICE
     *  appium server -pa /wd/hub
     */

}
