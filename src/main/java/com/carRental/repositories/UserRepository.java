package com.carRental.repositories;

import com.carRental.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
;
     User findByEmail(String userName);
}
