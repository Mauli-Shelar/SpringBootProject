package org.com.repo;

import org.com.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {

	LoginUser getByUsername(String username);

}
