package org.uv.DAPP02Pracica03;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RepositoryUsers extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
