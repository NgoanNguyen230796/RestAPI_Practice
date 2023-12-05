package ra.session06_btlt.service;

import ra.session06_btlt.dto.request.ProductRequest;
import ra.session06_btlt.dto.response.ProductResponse;
import ra.session06_btlt.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponse> findAll();
    List<ProductResponse> findProductByNameOrCatalogName(String inputSearch);

    ProductResponse findById(String productId);

    ProductResponse save(ProductRequest productRequest);

    ProductResponse update(ProductRequest productRequest,String productId);

    ProductResponse delete(String productId);
}
