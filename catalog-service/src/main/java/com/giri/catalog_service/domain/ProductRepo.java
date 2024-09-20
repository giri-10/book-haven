package com.giri.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

}
