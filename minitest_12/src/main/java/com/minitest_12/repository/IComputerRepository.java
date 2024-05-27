package com.minitest_12.repository;

import com.minitest_12.model.Computer;
import com.minitest_12.model.TypeComputer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends CrudRepository<Computer, Long> {
    Iterable<Computer> findAllByTypeComputer(TypeComputer typeComputer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByCodeContaining(String code, Pageable pageable);
}
