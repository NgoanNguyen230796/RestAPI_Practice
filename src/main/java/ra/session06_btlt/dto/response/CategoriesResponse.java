package ra.session06_btlt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesResponse {
    private int catalogId;

    private String catalogName;

    private int priority;

    private boolean catalogStatus;
}
