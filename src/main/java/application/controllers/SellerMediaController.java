package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.services.SellerMediaService;
import application.utils.ReadFileName;

@RestController
@RequestMapping("/media")
public class SellerMediaController {

	@Autowired
	private SellerMediaService selerMedia;
	
	@Autowired
	private ReadFileName readFile;
	
//	@PostMapping("/save-image")
//	public ResponseEntity<?> saveSellerDetails() throws Exception{
//			String response=selerMedia.SaveImageDetails();
//			return new ResponseEntity<String>(response,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/read")
//	public String read() throws Exception {
//	return	selerMedia.SaveImageDetails();
//	}
//	
//	
//	@GetMapping("/download")
//	public String download() throws Exception {
//	return	selerMedia.downloadImages();
//	}
//	
	
	
	
	
	
}
