package com.restaurant.garlix.repository;

import com.restaurant.garlix.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value ="SELECT * FROM Item WHERE item_status = :active", nativeQuery=true)
    List<Item> findByStatus(@Param("active") Boolean active);

}
