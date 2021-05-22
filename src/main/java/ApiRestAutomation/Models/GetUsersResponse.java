package ApiRestAutomation.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUsersResponse {

    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private List<Datum> data = null;
    private Support support;
}
