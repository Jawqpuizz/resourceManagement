package com.itlize.project.resourceManagement.Repository;

import com.itlize.project.resourceManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUser(String user);

    void deleteById(Integer id);
}
