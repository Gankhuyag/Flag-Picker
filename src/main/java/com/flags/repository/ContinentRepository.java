package com.flags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flags.model.Continent;
import com.flags.model.Countries;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

	@Query("SELECT cn FROM Continent cn WHERE cn.continent like :str%")
	public List<Continent> findByLetters(String str);

	@Query("SELECT cntr from Countries cntr INNER JOIN Continent cn ON cntr.cont=cn.continentId WHERE "
			+ "cn.continent like :str%")
	public List<Countries> findByContinent(String str);

	@Query("SELECT cntr.flag from Countries cntr INNER JOIN Continent cn ON cntr.cont=cn.continentId WHERE"
			+ " cn.continent like :cont% AND cntr.name like :counti%")	
	public List<String> findByContCount(String cont, String counti);

}
