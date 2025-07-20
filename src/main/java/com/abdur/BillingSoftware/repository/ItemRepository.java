package com.abdur.BillingSoftware.repository;

import com.abdur.BillingSoftware.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    Optional<ItemEntity> findByItemId(String id);

    Integer countByCategoryId(Long id);
}
