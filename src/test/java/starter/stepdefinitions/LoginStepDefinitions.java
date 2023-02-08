package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.navigation.NavigateTo;
import starter.questions.OnThePrincipalPage;
import starter.questions.SwagLabsStoreQuestions;
import starter.tasks.DoLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {

    @Given("{actor} is a {}")
    public void userNavigatesToHomePage(Actor actor, String customerType){
        actor.wasAbleTo(NavigateTo.theSauceHomePage());

    }

    @When("{actor} tries to login")
    public void userTriesToLogin(Actor actor){
        actor.attemptsTo(
                DoLogin.withCredentials("standard_user","secret_sauce")

        );
    }

    @When("{actor} tries to login with username {} and password {}")
    public void userTriesToLoginWithCredentials(Actor actor, String username, String password){
        actor.attemptsTo(
                DoLogin.withCredentials(username,password)

        );
    }

    @Then("{actor} should see the products list")
    public void userShouldSeeTheProductsList(Actor actor){
        actor.should(
                seeThat( "the display title",
                        OnThePrincipalPage.theTitleIs(),equalTo("PRODUCTS")

                )
        );

        theActorInTheSpotlight().should(seeThat("", SwagLabsStoreQuestions.ProductsAvailable()));

    }

}
