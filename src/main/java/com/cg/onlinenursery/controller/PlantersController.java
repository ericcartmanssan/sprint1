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
import com.cg.onlinenursery.exception.PlantersIdNotFoundException;
import com.cg.onlinenursery.service.IPlantersService;
	
@RestController
@RequestMapping("/planters")
public class PlantersController {

@Autowired
private  IPlantersService plantersService;
private Planters planter;
Logger logger = LoggerFactory.getLogger(PlantersController.class);

//@GetMapping("/planters")
//public ResponseEntity<List< Planters>> getPlanters() {
//
//			List<Planters> plantersList = plantersService.getPlanters();
//
//			ResponseEntity<List<Planters>> response = new ResponseEntity<>(plantersList, HttpStatus.NOT_FOUND);
//
//			if (!plantersList.isEmpty()) {
//				response = new ResponseEntity<>(plantersList, HttpStatus.OK);
//			}
//
//			return response;
//		}


@GetMapping
    public ResponseEntity<List< Planters>> getPlanters() {
	    logger.info("Inside getPlanters method");

			List<Planters> plantersList = plantersService.viewAllPlanters();
			logger.info("viewAll Planters" + plantersList);
			ResponseEntity<List<Planters>> response = new ResponseEntity<>(plantersList, HttpStatus.NOT_FOUND);

			if (!plantersList.isEmpty()) {
				response = new ResponseEntity<>(plantersList, HttpStatus.OK);
			}

			return response;
		}


//@GetMapping(value= "/{planterId}")
//public ResponseEntity<Object> getPlanters(@PathVariable("planterId") int planterId) {
//			Planters planters = plantersService.getPlanters(planterId);
//		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planters" + planterId + "Not found");
//					
//        if(planters !=null) {
//        	response = new ResponseEntity<>(planters,HttpStatus.OK);
//        }
//			return response;
//		}
//
//@GetMapping(value= "/{planterId}")
//public ResponseEntity<Object> viewAllPlanters(@PathVariable("minCost, maxCost") double minCost,double maxCost) throws PlantersIdNotFoundException {
//			List<Planters> planters = plantersService.viewAllPlanters(minCost,maxCost);
//		ResponseEntity<Object> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planters" +minCost +maxCost +  "Not found");
//		if (planters == null) {
//			throw new PlantersIdNotFoundException("minCost Not found "+ "maxCost Not found ");
//		}
//
//		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
//		}



@GetMapping("/{plantersId}")
public ResponseEntity<Planters> viewPlanters(@PathVariable("plantersId") int planterId) throws PlantersIdNotFoundException {
	logger.info("Inside viewPlanters method");	
	Planters planters = plantersService.viewPlanters(planterId);
	logger.info("View Planters" + planters);
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planters" + planterId + "Not found");
		if (planters == null) {
			throw new PlantersIdNotFoundException("PlantersId Not found ");
		}

		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
		}

@GetMapping("/shape/{plantersShape}")
public ResponseEntity<List<Planters>> viewPlanters(@PathVariable("plantersShape") String plantersShape) throws PlantersIdNotFoundException {
	logger.info("Inside viewPlanters method");
	List<Planters>  planters = plantersService.viewPlanters(plantersShape);
	logger.info("View Planters" + planters);
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planters" + plantersShape + "Not found");
		if (planters == null) {
			throw new PlantersIdNotFoundException("plantersShape Not found ");
		}

		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
}


@DeleteMapping("/planters/{pid}")
public ResponseEntity<String> deletePlanters(@PathVariable("pid")int plantersId) throws PlantersIdNotFoundException
{   logger.info("Inside deletePlanters method");
	Planters plantersPresent=plantersService.viewPlanters(plantersId);
	logger.info("Delete Planters" + plantersPresent);
	if(plantersPresent==null)
	{
		throw new  PlantersIdNotFoundException("PlantersId "+plantersId+" not found");
	}
	plantersService.deletePlanters(plantersId);
	return  ResponseEntity.status(HttpStatus.OK).body("Planters "+plantersId+" deleted");
}

@PutMapping("/{plantersId}")
public ResponseEntity<String> updatePlanters(@PathVariable("plantersId") int plantersId,@RequestBody Planters planters) {
	logger.info("Inside updatePlanters method");
	planters.setPlanterId(plantersId);
	Planters updatePlanters = plantersService.updatePlanters(planters);
	logger.info("Update Customer" + updatePlanters);
           if (updatePlanters == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Planters" + plantersId + "Not found");
			}else {
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planters.getPlanterId()).toUri();
				return ResponseEntity.created(location).build();
			}
   }


@PostMapping
public ResponseEntity<String> addPlanters(@RequestBody Planters planters){
	logger.info("Inside addPlanters method");
	Planters newPlanters = plantersService.addPlanters(planters);
	logger.info("New Planters" + newPlanters);
	if(newPlanters == null)
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPlanters.getPlanterId()).toUri();
	return ResponseEntity.created(location).build();
    }

}