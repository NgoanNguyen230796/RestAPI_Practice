package ra.session06_btlt.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoriesRequest {
    private int catalogId;
    @NotNull(message = "Tên catalogName không được null")
    private String catalogName;

    private String descriptions;

    private int priority;
}
