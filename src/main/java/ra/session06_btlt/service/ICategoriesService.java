package ra.session06_btlt.service;

import ra.session06_btlt.dto.request.CategoriesRequest;
import ra.session06_btlt.dto.response.CategoriesResponse;

import java.util.List;

public interface ICategoriesService {
    List<CategoriesResponse> findAll();
    CategoriesResponse findById(int catalogId);
    List<CategoriesResponse> findByName(String catalogName);
    CategoriesResponse save(CategoriesRequest categoriesRequest);

    CategoriesResponse update(CategoriesRequest categoriesRequest,int catalogId);

    CategoriesResponse delete(int catalogId);
}
