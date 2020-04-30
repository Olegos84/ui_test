package task.test;

import org.testng.annotations.Test;
import task.product.page.GooglePage;
import task.product.page.OpenBankPage;

import static task.product.page.OpenBankPage.CurrencyName.EUR;
import static task.product.page.OpenBankPage.CurrencyName.USD;
import static task.product.page.OpenBankPage.CurrencyTransactionType.PURCHASE;
import static task.product.page.OpenBankPage.CurrencyTransactionType.SALE;

public class SearchTest extends BaseTest {

    public static final String BANK_URL = "https://www.open.ru/";

    @Test(groups = {"P0"},
            testName = "testCurrencyRateOnMainPage",
            description = "Find bank page using google and verify that currency selling rate is higher than the purchase rate")
    public void testCurrencyRateOnMainPage() {
        OpenBankPage openBankPage =
                GooglePage.openPage()
                        .searchFor("Открытие")
                        .clickByLink(BANK_URL, OpenBankPage.class);

        assertion.assertTrue(openBankPage.getCurrencyRate(USD, SALE) >
                        openBankPage.getCurrencyRate(USD, PURCHASE),
                "Verify that selling rate more than buying rate for USD");
        assertion.assertTrue(openBankPage.getCurrencyRate(EUR, SALE) >
                        openBankPage.getCurrencyRate(EUR, PURCHASE),
                "Verify that selling rate more than buying rate for EUR");
    }
}
