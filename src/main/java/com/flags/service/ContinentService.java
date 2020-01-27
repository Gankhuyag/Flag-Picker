package com.flags.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.flags.model.Continent;
import com.flags.model.Countries;
import com.flags.repository.CountryRepository;
import com.flags.repository.ContinentRepository;

@Service
public class ContinentService {

	@Autowired
	ContinentRepository rep;
	@Autowired
	CountryRepository countryRep;

	@Transactional
	public List<Continent> saveCont(List<Continent> cont) {

		List<Continent> result = new ArrayList<Continent>();

		if (cont == null) {
			return result;
		}
		
		for (Continent cn : cont) {
			result.add(rep.save(cn));
			for (int i = 0; i < cn.getCountries().size(); i++) {
				cn.getCountries().get(i).setCont(new Continent(cn.getContinentId()));
				countryRep.save(cn.getCountries().get(i));
				;
			}

		}

		return result;
	}

}
