package starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "with")
public class Employee {

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;



}
