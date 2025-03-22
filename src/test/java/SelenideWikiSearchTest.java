import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiSearchTest {

    @BeforeAll
    static void setupConfig() {
       Configuration.browserSize = "1920x1080";
        Configuration.baseUrl =  "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void shouldFineInSoftAssertionsTest(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".filter-bar").click();
        $("#wiki-pages-filter").setValue("so");
        $(".details-reset a[href = '/selenide/selenide/wiki/SoftAssertions']").click();
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .sibling(0)
                .find("pre")
                .should(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}
