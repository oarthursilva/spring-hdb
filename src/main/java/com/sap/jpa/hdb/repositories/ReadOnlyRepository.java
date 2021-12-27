package com.sap.jpa.hdb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {
  Optional<T> findById(ID id);

  List<T> findAll();

  <S extends T> S save(S var1);
}
