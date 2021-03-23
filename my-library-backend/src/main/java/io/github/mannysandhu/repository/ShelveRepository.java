package io.github.mannysandhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mannysandhu.model.Shelve;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve, Long> {

}
