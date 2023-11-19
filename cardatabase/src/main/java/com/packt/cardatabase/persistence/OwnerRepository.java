package com.packt.cardatabase.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.cardatabase.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
