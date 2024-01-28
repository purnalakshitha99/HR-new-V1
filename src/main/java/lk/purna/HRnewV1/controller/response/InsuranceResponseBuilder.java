package lk.purna.HRnewV1.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceResponseBuilder {

    private Long id;
    private String company;
    private String type;
}
