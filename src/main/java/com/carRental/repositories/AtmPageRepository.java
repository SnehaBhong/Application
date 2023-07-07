package com.carRental.repositories;

import com.carRental.entities.AtmPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmPageRepository extends JpaRepository<AtmPage,Integer> {
}
