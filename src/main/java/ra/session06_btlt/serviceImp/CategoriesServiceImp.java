package ra.session06_btlt.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session06_btlt.dto.request.CategoriesRequest;
import ra.session06_btlt.dto.response.CategoriesResponse;
import ra.session06_btlt.dto.response.ProductResponse;
import ra.session06_btlt.mapper.CategoriesMapper;
import ra.session06_btlt.model.Categories;
import ra.session06_btlt.repository.ICategoriesRepository;
import ra.session06_btlt.service.ICategoriesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImp implements ICategoriesService {
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Autowired
    private ICategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesResponse> findAll() {
        return categoriesRepository.findAll().stream().map(categories -> categoriesMapper.toResponse(categories)).collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse findById(int catalogId) {
        Optional<Categories> otpCategories = categoriesRepository.findById(catalogId);
        if (otpCategories.isPresent()) {
            return categoriesMapper.toResponse(otpCategories.get());
        }
        return null;
    }

    @Override
    public List<CategoriesResponse> findByName(String catalogName) {
        return categoriesRepository.findByCatalogNameContains(catalogName).stream().map(categories -> categoriesMapper.toResponse(categories)).collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse save(CategoriesRequest categoriesRequest) {
        return categoriesMapper.toResponse(categoriesRepository.save(categoriesMapper.toEntity(categoriesRequest)));
    }

    @Override
    public CategoriesResponse update(CategoriesRequest categoriesRequest, int catalogId) {
        Optional<Categories> otpCategories = categoriesRepository.findById(catalogId);
        if (otpCategories.isPresent()) {
            return categoriesMapper.toResponse(categoriesRepository.save(categoriesMapper.toEntity(categoriesRequest)));
        }
        return null;
    }

    @Override
    public CategoriesResponse delete(int catalogId) {
        Optional<Categories> otpCategories = categoriesRepository.findById(catalogId);
        if (otpCategories.isPresent()) {
            Categories categoriesUpdateStatus=otpCategories.get();
            categoriesUpdateStatus.setCatalogStatus(false);
            return categoriesMapper.toResponse(categoriesRepository.save(categoriesUpdateStatus));
        }
        return null;
    }
}
