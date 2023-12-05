package ra.session06_btlt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private String productId;
    private String productName;
    private float price;
    private Date created;
    private int quantity;
    private boolean productStatus;
    private int catalogId;
    private String catalogName;


}
