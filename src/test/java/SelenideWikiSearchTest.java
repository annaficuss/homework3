import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiSearchTest {


    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl =  "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void shouldFineInSoftAssertions(){

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".filter-bar").click();
        $("#wiki-pages-filter").setValue("so");
        $(".details-reset a[href = '/selenide/selenide/wiki/SoftAssertions']").click();
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .sibling(0)
                .find("pre")
                .should(Condition.exist);



    }
}
