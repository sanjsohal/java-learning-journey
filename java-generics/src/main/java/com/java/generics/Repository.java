package com.java.generics;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends BaseEntity> {
    void save(T t);
    Optional<T> findById(String id);
    List<T> findAll();
}
