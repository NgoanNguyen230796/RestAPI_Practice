package ra.session06_btlt.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ra.session06_btlt.dto.response.CategoriesResponse;
import ra.session06_btlt.model.Categories;

import java.util.List;

@Repository
public interface ICategoriesRepository extends JpaRepository<Categories,Integer> {
    List<Categories> findByCatalogNameContains(String catalogName);

//    @Transactional
//    @Modifying
//    @Query("update Categories ca set ca.catalogStatus = 0 where ca.catalogId = :catalogId")
//    void updateStatus(@Param("catalogId") int catalogId);

}
