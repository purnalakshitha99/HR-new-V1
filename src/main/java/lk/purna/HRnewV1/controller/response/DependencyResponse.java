package lk.purna.HRnewV1.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DependencyResponse {

    private Long id;
    private String relationship;
}
