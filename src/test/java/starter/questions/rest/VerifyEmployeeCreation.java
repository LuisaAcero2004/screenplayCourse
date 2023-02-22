package starter.questions.rest;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyEmployeeCreation {

    public static Question<Integer> responseCodeOfService(){
        return actor -> lastResponse().statusCode();
    }

    public static Question<String> nameEmployeeCreated() {
        return actor -> lastResponse().getBody().jsonPath().getString("name");
    }

}
