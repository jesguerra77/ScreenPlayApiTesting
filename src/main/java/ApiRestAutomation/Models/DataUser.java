package ApiRestAutomation.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataUser {

    private String name;
    private String salary;
    private String age;
    private Integer id;
}
