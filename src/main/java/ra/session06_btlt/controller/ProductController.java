package ra.session06_btlt.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session06_btlt.dto.request.ProductRequest;
import ra.session06_btlt.dto.response.ProductResponse;
import ra.session06_btlt.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/getAllData")
    public ResponseEntity<List<ProductResponse>> getAllData() {
        List<ProductResponse> listProductResponse = productService.findAll();
        return new ResponseEntity<>(listProductResponse, HttpStatus.OK);
    }

    @GetMapping("/getProductByNameOrCatalogName/{inputSearch}")
    public ResponseEntity<List<ProductResponse>> getProductByNameOrCatalogName(@PathVariable String inputSearch) {
        List<ProductResponse> listProductResponse = productService.findProductByNameOrCatalogName(inputSearch);
        return new ResponseEntity<>(listProductResponse,HttpStatus.OK);
    }


    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.save(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest productRequest,@PathVariable String productId) {
        ProductResponse productResponse = productService.save(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @PutMapping("/delete/{productId}")
    public ResponseEntity<ProductResponse> delete(@PathVariable String productId) {
        ProductResponse productResponse = productService.delete(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }


}
