package ApiRestAutomation.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@lombok.Data
@Builder
@NoArgsConstructor
public class Datum {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
}
