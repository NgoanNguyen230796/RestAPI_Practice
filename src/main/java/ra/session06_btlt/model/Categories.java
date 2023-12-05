package ra.session06_btlt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int catalogId;

    @Column(name = "catalog_name",columnDefinition = "varchar(100)",nullable = false)
    private String catalogName;

    @Column(columnDefinition = "TEXT", name = "descriptions")
    private String descriptions;

    private int priority;

    @Column(name = "catalog_status",columnDefinition = "bit default 1")
    private boolean catalogStatus;

    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct;


}
