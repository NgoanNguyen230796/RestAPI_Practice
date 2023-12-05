package ra.session06_btlt.mapper;

import org.springframework.stereotype.Component;
import ra.session06_btlt.dto.request.CategoriesRequest;
import ra.session06_btlt.dto.response.CategoriesResponse;
import ra.session06_btlt.model.Categories;

@Component
public class CategoriesMapper implements GenericMapper<Categories,CategoriesRequest, CategoriesResponse>{

    @Override
    public Categories toEntity(CategoriesRequest categoriesRequest) {
        return Categories.builder().catalogId(categoriesRequest.getCatalogId())
                .catalogName(categoriesRequest.getCatalogName())
                .descriptions(categoriesRequest.getDescriptions())
                .priority(categoriesRequest.getPriority()).build();
    }

    @Override
    public CategoriesResponse toResponse(Categories categories) {
        return CategoriesResponse.builder().catalogId(categories.getCatalogId())
                .catalogName(categories.getCatalogName())
                .priority(categories.getPriority())
                .catalogStatus(categories.isCatalogStatus()).build();
    }
}
