package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Security.enums.SizeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISizeDetailsRepository extends JpaRepository<SizeDetails, Long> {
    SizeDetails findBySize(SizeName sizeName);

    @Modifying
    @Query(value = "DELETE FROM product_size WHERE product_id =:id",
            nativeQuery = true)
    void deleteProductSizeById(@Param("id") Long id);
}
