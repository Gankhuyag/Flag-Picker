package com.flags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flags.model.Continent;
import com.flags.model.Countries;

@Repository
public interface CountryRepository extends JpaRepository<Countries, Long> {

}
