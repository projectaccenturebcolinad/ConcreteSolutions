package com.evaluateApisBcolinad.restfulApis.Repositories;

import com.evaluateApisBcolinad.restfulApis.Entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    //
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.token = :vToken")
    User findByToken(@Param("vToken") String vToken);

    List<User> findAll();

    @Modifying
    @Query("UPDATE User u SET u.token = :vToken,u.last_login = :vLastLogin WHERE u.email = :vEmail")
    int updateUser(
        @Param("vEmail") String vEmail,
        @Param("vToken") String vToken,
        @Param("vLastLogin") LocalDateTime vLastLogin
    );
}
