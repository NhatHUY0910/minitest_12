package com.minitest_12.repository;

import com.minitest_12.model.TypeComputer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends CrudRepository<TypeComputer, Long> {
}
