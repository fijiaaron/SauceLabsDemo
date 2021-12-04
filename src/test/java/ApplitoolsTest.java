import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import org.junit.After;

public class ApplitoolsTest extends SauceLabsTest
{
    String APPLITOOLS_API_KEY = System.getenv("APPLITOOLS_API_KEY");

    @After
    public void screenshot()
    {
        System.out.println(APPLITOOLS_API_KEY);

        EyesRunner runner = new ClassicRunner();
        Eyes eyes = new Eyes(runner);
        BatchInfo batch = new BatchInfo("Demo Batch");
        eyes.setBatch(batch);
        eyes.setApiKey(APPLITOOLS_API_KEY);
        System.out.println("before open");
        eyes.open(driver, "Amazon", "open home page");
        System.out.println("before open");

        System.out.println("before checkWindow");
        eyes.checkWindow("Amazon home page");
        System.out.println("after checkWindow");

        System.out.println("before closeAsync");
        eyes.closeAsync();
        System.out.println("after closeAsync");

        eyes.abortIfNotClosed();

    }
}
