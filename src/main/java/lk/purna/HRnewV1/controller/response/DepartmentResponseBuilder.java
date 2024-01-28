package lk.purna.HRnewV1.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponseBuilder {

    private Long id;
    private String name;
}
