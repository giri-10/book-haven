package com.giri.catalog_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepo extends JpaRepository<ProductEntity, Long> {}
