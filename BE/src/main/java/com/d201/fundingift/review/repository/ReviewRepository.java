package com.d201.fundingift.review.repository;

import com.d201.fundingift.product.entity.Product;
import com.d201.fundingift.product.entity.ProductOption;
import com.d201.fundingift.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 상품 별 리뷰 리스트 조회
    @Query("select r from Review r " +
            "where r.product = :product and r.productOption = :productOption " +
            "and r.status = 'ACTIVE' and r.deletedAt is null")
    Slice<Review> findAllSliceByProductAndOption(
            @Param("product") Product product, @Param("productOption") ProductOption productOption, Pageable pageable);

}