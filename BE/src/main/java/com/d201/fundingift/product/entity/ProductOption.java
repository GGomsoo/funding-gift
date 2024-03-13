package com.d201.fundingift.product.entity;

import com.d201.fundingift._common.entity.BaseTime;
import com.d201.fundingift.product.entity.status.ProductOptionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@ToString
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOption extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_option_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'ACTIVE'")
    private ProductOptionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Builder
    private ProductOption(String name, Integer price, ProductOptionStatus status, Product product) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.product = product;
    }

}
