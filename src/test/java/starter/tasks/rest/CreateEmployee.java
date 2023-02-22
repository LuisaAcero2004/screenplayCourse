package starter.tasks.rest;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import starter.models.Employee;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static starter.utils.Constants.CREATE_EMPLOYEE_ENDPOINT;

public class CreateEmployee implements Task {

    private Employee employee;

    public CreateEmployee(Employee employee){
        this.employee = employee;
    }

    public static CreateEmployee inTheApp(Employee employee){
        return instrumented(CreateEmployee.class,employee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to(CREATE_EMPLOYEE_ENDPOINT)
                        .with(
                                request -> request.header(CONTENT_TYPE, ContentType.JSON)
                                        .body(employee)
                        )
        );
    }
}
