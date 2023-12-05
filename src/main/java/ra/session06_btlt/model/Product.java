package ra.session06_btlt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "char(5)")
    private String productId;

    @Column(name = "product_name",columnDefinition = "varchar(100)",unique = true,nullable = false)
    private String productName;

    @Column(name = "price",nullable = false)
    private float price;

    @CreationTimestamp
    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date created;

    @Column(name = "quantity",columnDefinition = "int default 0")
    private int quantity;

    @Column(name = "product_status",columnDefinition = "bit default 1")
    private boolean productStatus;

    @ManyToOne
    @JoinColumn(name="catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;

}
