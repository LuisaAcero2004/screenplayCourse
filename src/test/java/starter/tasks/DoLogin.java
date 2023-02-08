package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.LoginUI;

import  static  net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoLogin implements Task {

    private String userName;
    private String userPassword;

    public DoLogin(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public static Performable withCredentials(String userName, String userPassword){



        return instrumented(DoLogin.class, userName, userPassword);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LoginUI.USER_NAME,isVisible()),
                Enter.theValue(this.userName).into(LoginUI.USER_NAME),
                Enter.theValue(this.userPassword).into(LoginUI.USER_PASSWORD),
                Click.on(LoginUI.LOGIN_BUTTON)

        );

    }
}
