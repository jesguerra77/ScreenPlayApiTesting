package ApiRestAutomation.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Datum {
    private Integer id;
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;
}
