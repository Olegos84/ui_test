package task.product.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenBankPage {

    private static final String CURRENCY_RATE_XPATH_PATTERN = "//span[text()='%s']/ancestor::tr//td[%d]//span";

    public Double getCurrencyRate(CurrencyName name, CurrencyTransactionType transactionType) {
        SelenideElement currencyRate = $(By.xpath(
                String.format(CURRENCY_RATE_XPATH_PATTERN, name.name(), transactionType.getColumn())));
        String text = currencyRate.scrollIntoView(false).getText();
        return Double.parseDouble(text.replace(",", "."));
    }

    public enum CurrencyTransactionType {
        SALE(4), PURCHASE(2);
        private int column;

        public int getColumn() {
            return column;
        }

        CurrencyTransactionType(int columnNumber) {
            this.column = columnNumber;
        }
    }

    public enum CurrencyName {
        USD, EUR
    }
}
