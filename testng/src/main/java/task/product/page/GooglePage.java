package task.product.page;

import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    public static final String PAGE_URL = "https://www.google.com";
    public static final String SEARCH_INPUT_NAME = "q";
    private static final String LINK_XPATH_PATTERN = "//div[@class='g']//a[@href='%s']";

    public static GooglePage openPage() {
        open(PAGE_URL);
        return new GooglePage();
    }

    public GooglePage searchFor(String stringForSearch) {
        $(By.name(SEARCH_INPUT_NAME))
                .val(stringForSearch)
                .pressEnter();
        return new GooglePage();
    }

    public <T> T clickByLink(String url, Class<T> pageClass) {
        $(By.xpath(String.format(LINK_XPATH_PATTERN, url))).click();
        T page = null;
        try {
            page = pageClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LoggerFactory.getLogger(GooglePage.class).error(e.getMessage());

        }
        return page;
    }
}
