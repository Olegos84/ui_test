package task.test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

public abstract class BaseTest {
    protected Assertion assertion;

    @BeforeClass(alwaysRun = true)
    protected void configureSelenide() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @BeforeMethod(alwaysRun = true)
    protected void init() {
        assertion = new Assertion();
    }
}
