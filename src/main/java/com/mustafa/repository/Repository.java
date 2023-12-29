package com.mustafa.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    /**
     * Generic Class -> Class<?>
     */
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(Long id);
    List<T> findAll();
    Optional<T> findById(Long id);
}
