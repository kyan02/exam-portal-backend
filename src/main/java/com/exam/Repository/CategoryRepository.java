package com.exam.Repository;

import com.exam.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findOneByNameAndIsActive(String name, Boolean isActive);

    void deleteByName(String name);


}
