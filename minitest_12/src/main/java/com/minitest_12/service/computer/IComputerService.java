package com.minitest_12.service.computer;

import com.minitest_12.model.Computer;
import com.minitest_12.model.TypeComputer;
import com.minitest_12.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerService extends IGeneralService<Computer> {
    Iterable<Computer> findAllByType(TypeComputer type);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByCodeContaining(String code, Pageable pageable);
}
