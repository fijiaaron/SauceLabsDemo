import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsTest
{
    WebDriver driver;
//    String SAUCE_URL = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
    String SAUCE_URL = "https://ondemand.saucelabs.com:443/wd/hub";

    String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
    String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    String BUILD_ID = System.getenv("BUILD_ID");
    String TEST_NAME = this.getClass().getSimpleName();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setup() throws MalformedURLException
    {
        TEST_NAME += " " + testName.getMethodName();
        URL url = new URL(SAUCE_URL);
        Capabilities capabilities = getSauceCapabilities("chrome");
        driver = new RemoteWebDriver(url, capabilities);
    }

    @After
    public void cleanup()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void amazonCapture()
    {
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
    }

    protected Capabilities getSauceCapabilities(String browserName)
    {
        MutableCapabilities capabilities = new MutableCapabilities();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "any");
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "latest");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", SAUCE_USERNAME);
        sauceOptions.setCapability("accessKey", SAUCE_ACCESS_KEY);
        sauceOptions.setCapability("name", TEST_NAME);
        sauceOptions.setCapability("build", "BUILD_ID");
        sauceOptions.setCapability("browserVersion", "latest");

        capabilities.setCapability("sauce:options", sauceOptions);
        System.out.println(sauceOptions);
        System.out.println(capabilities);

        return capabilities;
    }
}
