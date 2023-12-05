package ra.session06_btlt.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.session06_btlt.model.Categories;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String productId;
    @NotNull(message = "Tên productName không được null")
    private String productName;
    @NotNull(message = "price không được null")
    private float price;
    @NotNull(message = "catalog không được null")
    private int catalogId;
}
