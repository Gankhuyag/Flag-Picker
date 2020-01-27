package com.flags.controller;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flags.model.Continent;
import com.flags.model.Countries;
import com.flags.observer.LoggerObserver;
import com.flags.observer.SaveObserver;
import com.flags.observer.SaveToDB;
import com.flags.observer.SendMailObserver;
import com.flags.observer.Subject;
import com.flags.repository.ContinentRepository;
import com.flags.service.ContinentService;

@RestController
public class ContinentContoller {
	@Autowired
	private ContinentRepository repo;

	@Autowired
	private ContinentService service;

	/*
	 * GET Request
	 */
	@GetMapping(path = "/list")
	public List<Continent> retrieveCountries() {
		List<Continent> con = repo.findAll();

		if (con == null) {
			throw new SelectionNotFoundException("No Countries found!");
		}
		return con;
	}

	/*
	 * POST Request
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<Continent> createContinent(@RequestBody List<Continent> continent) {
		String msgTxt = "Countries are persisted into DB!";
		
		service.saveCont(continent);
		Subject subject=new Subject();

        new SaveObserver(subject);        
        new LoggerObserver(subject);
        SaveToDB sd=new SaveToDB(continent);
        subject.setState(sd);

		return new ResponseEntity<Continent>(HttpStatus.CREATED);
	}

	/*
	 * I. GET Request-List of Continents by filtering by entered letters
	 * using @PathVarialble
	 * 
	 * example: http://localhost:8080/list/Asia
	 */

	@GetMapping(path = "/list/{str}")
	public List<Continent> findByLetters(@PathVariable String str) {
		List<Continent> con = repo.findByLetters(str);
		if (con.isEmpty()) {
			throw new SelectionNotFoundException("No Continents found!");
		}
		return con;
	}

	/*
	 * I. GET Request-List of Continents by filtering by entered letters
	 * using @RequestParam
	 * 
	 * example: http://localhost:8080/listing?continent=Asia
	 */

	@GetMapping(path = "/listing")
	public List<Continent> continentListing(@RequestParam(value = "continent", defaultValue = "Asia") String cont) {
		List<Continent> con = repo.findByLetters(cont);
		if (con.isEmpty()) {
			throw new SelectionNotFoundException("No Continent found!");
		}
		return con;
	}

	/*
	 * II. GET Request-List of Countries on a selected Continent
	 * using @PathVarialble
	 * 
	 * example: http://localhost:8080/list/countries/Asia
	 * 
	 */

	@GetMapping(path = "/list/countries/{str}")
	public List<Countries> findByContinent(@PathVariable String str) {
		List<Countries> con = repo.findByContinent(str);
		if (con.isEmpty()) {
			throw new SelectionNotFoundException("No Countries found!");
		}
		return con;
	}

	/*
	 * II. GET Request-List of Countries on a selected Continent using @RequestParam
	 * 
	 * example: http://localhost:8080/list/countries/?continent=Asia
	 * 
	 */

	@GetMapping(path = "/listing/countries")
	public List<Countries> countryListing(@RequestParam(value = "continent", defaultValue = "Asia") String conti) {
		List<Countries> con = repo.findByContinent(conti);
		if (con.isEmpty()){
			throw new SelectionNotFoundException("No Countries found!");
		}
		return con;
	}

	/*
	 * III. GET Request-List of flags on a selected Countries and Continent
	 * using @PathVarialble
	 * 
	 * example: http://localhost:8080/list/flag/Japan
	 * 
	 */

	@GetMapping(path = "/list/flag/{cont}/{counti}")
	public List<String> findByContCountry(@PathVariable("cont") String cont, @PathVariable("counti") String counti) {
		List<String> con = repo.findByContCount(cont, counti);
		if (con.isEmpty()) {
			throw new SelectionNotFoundException("No Flags found!");
		}
		return con;
	}

	

	/*
	 * III. GET Request-List of flags on a selected Countries and Continent
	 * using @RequestParam
	 * 
	 * example: http://localhost:8080/listing/flag?continent=asia&country=japan
	 * 
	 */

	@GetMapping(path = "/listing/flag")
	public List<String> listContCountry(@RequestParam(value = "continent", defaultValue = "Asia") String cont,
	@RequestParam(value = "country", defaultValue = "Japan") String counti) {
		List<String> con = repo.findByContCount(cont, counti);
		if (con.isEmpty()) {
			throw new SelectionNotFoundException("No Flags found!");
		}
		return con;
	}

	
	
//
//	/*
//	 * PUT REQUEST
//	 * 
//	 */
//	@PutMapping("/storage/documents/{docId}")
//	public ResponseEntity<Object> replaceEmployee(@RequestBody String newContent, @PathVariable String docId) {
//
//		Document doc = service.findOne(docId);
//
//		if (doc == null) {
//			throw new DocNotFoundException("DocId-" + docId);
//		}
//		doc.setContent(newContent);
//		// service.save(doc);
//		String msgTxt = "Content-Type: text/plain; charset=us-ascii Content-Length: " + newContent.length()
//				+ System.lineSeparator() + docId.toUpperCase();
//
//		return new ResponseEntity<>(msgTxt, HttpStatus.NO_CONTENT);
//	}
//
//	/*
//	 * DELETE REQUEST
//	 * 
//	 */
//	@DeleteMapping("/storage/documents/{docId}")
//	public ResponseEntity<Object> deleteDocument(@PathVariable String docId) {
//		Document doc = service.deleteDocument(docId);
//		if (doc == null) {
//			throw new DocNotFoundException("DocId-" + docId);
//		}
//
//		return new ResponseEntity<>("No Content", HttpStatus.NO_CONTENT);
//	}

}
