package com.flags.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.get; 
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.BeforeClass;


@RunWith(SpringRunner.class)


public class ContinentControllerTest {
	 
 	    @BeforeClass
	    public  void init() 
	    {
	        RestAssured.baseURI = "http://localhost";
	        RestAssured.port = 8080;
	    }
	 
	    @Test
	    public void getCountriesListSuccess() {
	    	get("/listing?continent=Asia").then()
	    	.body("countries.name", hasItems("Russia", "Germany","UK","Italy","France"));
	         
	    }
	    @Test
	    public void getContinentListSuccess() {
	    	get("/listing?continent=Asia").then()
	    	.body("countries.name", hasItems("Russia", "Germany","UK","Italy","France"));
	         
	    }@Test
	    public void getFlagListSuccess() {
	    	get("/listing/flag/?continent=asia&country=India").then()
	    	.body("countries.flag", hasItems("🇫, ", "🇮","🇬�,"));
	         
	    }@Test
	    public void getAllListSuccess() {
	    	get("/list/Europe").then()
	    	.body("countries.name", hasItems("Russia", "Germany","UK","Italy","France"));
	         
	    }
	}
 