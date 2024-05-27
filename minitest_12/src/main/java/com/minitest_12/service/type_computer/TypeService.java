package com.minitest_12.service.type_computer;

import com.minitest_12.model.TypeComputer;
import com.minitest_12.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Iterable<TypeComputer> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<TypeComputer> getById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public void save(TypeComputer typeComputer) {
        typeRepository.save(typeComputer);
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}
