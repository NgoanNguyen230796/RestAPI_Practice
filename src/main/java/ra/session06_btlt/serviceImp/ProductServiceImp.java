package ra.session06_btlt.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session06_btlt.dto.request.ProductRequest;
import ra.session06_btlt.dto.response.ProductResponse;
import ra.session06_btlt.mapper.ProductMapper;
import ra.session06_btlt.model.Categories;
import ra.session06_btlt.model.Product;
import ra.session06_btlt.repository.IProductRepository;
import ra.session06_btlt.service.ICategoriesService;
import ra.session06_btlt.service.IProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoriesService categoriesService;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(product -> productMapper.toResponse(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findProductByNameOrCatalogName(String inputSearch) {
        return productRepository.findByProductNameOrCatalogCatalogName(inputSearch).stream().map(product -> productMapper.toResponse(product)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(String productId) {
        Optional<Product> otpProduct=productRepository.findById(productId);
        if(otpProduct.isPresent()){
            return productMapper.toResponse(otpProduct.get());
        }
        return null;
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, String productId) {
        Optional<Product> otpProduct=productRepository.findById(productId);
        if(otpProduct.isPresent()){
            return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
        }
        return null;
    }

    @Override
    public ProductResponse delete(String productId) {
        Optional<Product> otpProduct=productRepository.findById(productId);
        if(otpProduct.isPresent()){
            Product productUpdateStatus=otpProduct.get();
            productUpdateStatus.setProductStatus(false);
            return productMapper.toResponse(productRepository.save(productUpdateStatus));
        }
        return null;
    }
}
