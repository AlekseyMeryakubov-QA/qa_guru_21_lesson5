import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.menu;

public class GithubSearchTest2 {
        static {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Configuration.browserCapabilities = capabilities;
        }


            @BeforeAll
            static public void beforeAll() {
                Configuration.browserSize = "1920x1080";
                Configuration.pageLoadStrategy ="eager";
            }

            @Test
            void searchBuildLikeTheBestTest2() {
                open("https://github.com/");

                // На главной странице GitHub выберите меню Solutions
                $(".header-menu-wrapper").$(byText("Solutions")).hover();


                //-> Enterprize с помощью команды hover для Solutions
                $(".header-menu-wrapper").$(byText("Enterprise")).click();

                // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
                $(".application-main h1").shouldHave(text("Build like the best"));

            }

}
