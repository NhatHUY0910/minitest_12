package com.minitest_12.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> getAll();

    Optional<T> getById(Long id);

    void save(T t);

    void delete(Long id);
}
