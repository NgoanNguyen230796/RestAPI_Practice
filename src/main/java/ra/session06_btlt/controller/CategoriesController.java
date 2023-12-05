package ra.session06_btlt.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session06_btlt.dto.request.CategoriesRequest;
import ra.session06_btlt.dto.response.CategoriesResponse;
import ra.session06_btlt.service.ICategoriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private ICategoriesService categoriesService;

    @GetMapping("/getAllData")
    public ResponseEntity<List<CategoriesResponse>> getAllData() {
        List<CategoriesResponse> listCategoriesResponse = categoriesService.findAll();
        return new ResponseEntity<>(listCategoriesResponse, HttpStatus.OK);
    }

    @GetMapping("/getCategoryById/{catalogId}")
    public ResponseEntity<CategoriesResponse> getCategoryById(@PathVariable int catalogId) {
        CategoriesResponse categoriesResponse = categoriesService.findById(catalogId);
        return new ResponseEntity<>(categoriesResponse, HttpStatus.OK);
    }

    @GetMapping("/getCategoriesByName/{catalogName}")
    public ResponseEntity<List<CategoriesResponse>> getCategoriesByName(@PathVariable String catalogName) {
        List<CategoriesResponse> listCategoriesResponse = categoriesService.findByName(catalogName);
        return new ResponseEntity<>(listCategoriesResponse, HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoriesResponse> createCategory(@Valid @RequestBody CategoriesRequest categoriesRequest) {
        CategoriesResponse categoriesResponse = categoriesService.save(categoriesRequest);
        return new ResponseEntity<>(categoriesResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateCategory/{catalogId}")
    public ResponseEntity<CategoriesResponse> updateCategory(@Valid @RequestBody CategoriesRequest categoriesRequest,@PathVariable int catalogId) {
        CategoriesResponse categoriesResponse = categoriesService.save(categoriesRequest);
        return new ResponseEntity<>(categoriesResponse, HttpStatus.CREATED);
    }

    @PutMapping("/deleteCategory/{catalogId}")
    public ResponseEntity<CategoriesResponse> deleteCategory(@PathVariable int catalogId) {
        CategoriesResponse categoriesResponse = categoriesService.delete(catalogId);
        return new ResponseEntity<>(categoriesResponse, HttpStatus.CREATED);
    }




}
