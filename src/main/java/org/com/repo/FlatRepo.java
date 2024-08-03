package org.com.repo;

import org.com.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Integer> {

}
