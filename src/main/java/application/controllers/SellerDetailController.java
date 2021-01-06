package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.SellerDetails;
import application.services.SellerDetailsService;

@RestController
@RequestMapping("/seller")
public class SellerDetailController {

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
	
	
	
}
