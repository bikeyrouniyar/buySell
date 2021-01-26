package application.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.models.SellerDetails;
import application.pojo.SellerInfo;
import application.services.SellerDetailsService;
@RestController
@RequestMapping("/seller")
public class SellerDetailController {

	Logger logger = Logger.getLogger(SellerDetailController.class.getName());
	
	@Autowired
	private SellerDetailsService sellerDetail;
	
	
	@PostMapping("/save-detail")
	public ResponseEntity<?> saveSellerDetails(@RequestBody SellerDetails sellerInfo){
		if(sellerInfo!=null) {
			String response=sellerDetail.saveSellerInfo(sellerInfo);
			return new ResponseEntity<String>(response,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("seller details null",HttpStatus.BAD_REQUEST);
		
		
	}
	
	@GetMapping("/get/state")
	public ResponseEntity<?> getByState(@RequestParam String state){
			try {
			logger.info("statename:====>>: " + state);
			List<SellerInfo> response = sellerDetail.getByState(state);
			return new ResponseEntity<List<SellerInfo>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getByState(){
			try {
				
			List<SellerInfo> response = sellerDetail.getall();
			return new ResponseEntity<List<SellerInfo>>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
}
