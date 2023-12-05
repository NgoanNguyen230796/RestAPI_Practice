package ra.session06_btlt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.session06_btlt.dto.request.ProductRequest;
import ra.session06_btlt.dto.response.ProductResponse;
import ra.session06_btlt.model.Product;
import ra.session06_btlt.repository.ICategoriesRepository;

@Component
public class ProductMapper implements GenericMapper<Product, ProductRequest, ProductResponse>{
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder().productId(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .catalog(categoriesRepository.findById(productRequest.getCatalogId()).get())
                .build();

    }

    @Override
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .created(product.getCreated())
                .quantity(product.getQuantity())
                .productStatus(product.isProductStatus())
                .catalogId(product.getCatalog().getCatalogId())
                .catalogName(product.getCatalog().getCatalogName()).build();
    }
}
