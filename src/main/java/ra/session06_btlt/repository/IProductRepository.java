package ra.session06_btlt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.session06_btlt.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,String> {
    @Query("select pr from Product pr where pr.productName like %?1% or pr.catalog.catalogName like %?1%")
    List<Product> findByProductNameOrCatalogCatalogName(@Param("inputSearch")String inputSearch);

}
