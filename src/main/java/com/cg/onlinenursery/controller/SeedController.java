package com.cg.onlinenursery.controller;


import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cg.onlinenursery.entity.Planters;
import com.cg.onlinenursery.entity.Seed;
import com.cg.onlinenursery.exception.PlantersIdNotFoundException;
import com.cg.onlinenursery.exception.SeedsIdNotFoundException;

import com.cg.onlinenursery.service.SeedServiceImpl;

@RestController
@RequestMapping("/seed")
public class SeedController {
	
	@Autowired
    private SeedServiceImpl SeedService;
	Logger logger = LoggerFactory.getLogger(SeedController.class);
	
    @GetMapping("/seed")
     public  ResponseEntity<List<Seed>>viewSeed(){
    	logger.info("Inside viewSeed method");
		List<Seed> seedList = SeedService.viewSeed();
        logger.info("ViewAll Seed" + seedList);
	ResponseEntity<List<Seed>>response = new ResponseEntity<>(seedList , HttpStatus.NOT_FOUND);
	if (!seedList.isEmpty()) {
		response = new ResponseEntity<>(seedList, HttpStatus.OK);
	}

	return response;
}
    @GetMapping("/{seedId}")
    public ResponseEntity<Seed> ViewSeed(@PathVariable("seedId") int seedId) throws SeedsIdNotFoundException {
    	logger.info("Inside ViewSeed method");
	     Seed seed = SeedService.viewSeed(seedId);
	     logger.info("View Seed" + seed);
	   if (seed == null) {
		throw new SeedsIdNotFoundException(seedId + " Not Found");
	   }
	// return response;
	   return new ResponseEntity<>(seed, HttpStatus.ACCEPTED);
  	   
}       
    @GetMapping("/commanname/{commanname}")
    public ResponseEntity<List<Seed>> viewSeed(@PathVariable("commanname") String commanname) throws SeedsIdNotFoundException {
    	logger.info("Inside viewSeed method");
    	List<Seed>  seed = SeedService.viewSeed(commanname);
    	
    	logger.info("view Seed" + seed);
    		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seed" + commanname + "Not found");
    		if (seed == null) {
    			throw new SeedsIdNotFoundException("commanname Not found ");
    		}

    		return new ResponseEntity<>(seed, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/typeofseed/{typeofseed}")
    public ResponseEntity<List<Seed>> viewAllSeed(@PathVariable("typeofseed") String typeofseed) throws SeedsIdNotFoundException {
    	logger.info("Inside viewAllSeed method");
    	List<Seed>  seed = SeedService.viewAllSeeds(typeofseed);
    	logger.info("viewAll Seed" + seed);
    		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seed" + typeofseed + "Not found");
    		if (seed == null) {
    			throw new SeedsIdNotFoundException("typeofseed Not found ");
    		}

    		return new ResponseEntity<>(seed, HttpStatus.ACCEPTED);
    }


    @PostMapping
	public ResponseEntity<String> addseed(@RequestBody Seed seed) {
    	logger.info("Inside addseed method");
		// If message is inserted it returns inserted message object else null
    	Seed newSeed = SeedService.addSeed(seed);
    	logger.info("New Seed" + newSeed);
		// response is set to error if message is null.
		if (newSeed == null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Inernal server error");
		// response is set to inserted message id in response header section.
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{seedid}")
				.buildAndExpand(newSeed.getSeedId()).toUri();
		return ResponseEntity.created(location).build();
}
	
     @DeleteMapping(value = "/{seedId}")
 	public ResponseEntity<String> deleteSeed(@PathVariable("seedId") int seedId) throws SeedsIdNotFoundException {
    	 logger.info("Inside deleteSeed method");
 		Seed seedPresent = SeedService.deleteSeed(seedId);
 		logger.info("Delete Seed" +seedPresent);
 		// Creating an success response.
 		// ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.OK)
 		if (seedPresent == null) {
 			
 	throw new SeedsIdNotFoundException( );
 		}
 		// return response;
 		return ResponseEntity.status(HttpStatus.OK).body("Seed " + seedId + " deleted");
 }
     @PutMapping("/{seedId}")
 	public ResponseEntity<Object> updateSeed(@PathVariable("seedId") int seedId,
 			@RequestBody Seed seed) throws SeedsIdNotFoundException {
    	 logger.info("Inside updatSeed method");
 		seed.setSeedId(seedId);
 		Seed updateseed =  SeedService.updateSeed(seed);
 		logger.info("Update Seed" + updateseed);
 		// response is set to error if seed is null.
 		if (updateseed == null) {

 		throw new SeedsIdNotFoundException();
 } 
 		else {
 			// response is set to updated seed id in response header section.
 			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{seed}")
 					.buildAndExpand(seed.getSeedId()).toUri();
 			return ResponseEntity.created(location).build();
 		}
 	}
}