package com.java.generics;

import java.util.*;

public class InMemoryRepository<T extends BaseEntity> implements Repository<T>{
    private final Map<String, T> storage;
    InMemoryRepository() {
        storage = new HashMap<>();
    }

    @Override
    public void save(T entity) {
        if(entity == null || entity.getId() == null)
            throw new IllegalArgumentException("Entity or ID cannot be null");
        storage.put(entity.getId(), entity);
    }

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}
