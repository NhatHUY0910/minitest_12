package com.minitest_12.service.computer;

import com.minitest_12.model.Computer;
import com.minitest_12.model.TypeComputer;
import com.minitest_12.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerRepository computerRepository;


    @Override
    public Iterable<Computer> getAll() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> getById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void delete(Long id) {
        computerRepository.deleteById(id);
    }

    @Override
    public Iterable<Computer> findAllByType(TypeComputer type) {
        return computerRepository.findAllByTypeComputer(type);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    @Override
    public Page<Computer> findAllByCodeContaining(String code, Pageable pageable) {
        return computerRepository.findAllByCodeContaining(code, pageable);
    }
}
