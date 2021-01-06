package application.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.SellerDetailsDao;
import application.models.SellerDetails;

@Service
public class SellerDetailsService {


Logger logger = Logger.getLogger(SellerDetailsService.class.getName());

	
	@Autowired
	private SellerDetailsDao sellerDetailDao;
	
	public String saveSellerInfo(SellerDetails sellerInfo) {
		try {
			logger.info("saving Seller details: " + sellerInfo.getMobileNumber());
			SellerDetails sellerdetail=new SellerDetails();
			sellerdetail=sellerInfo;
			sellerDetailDao.save(sellerdetail);
		} catch (Exception e) {
			logger.info("saving details failed" + e);
			e.printStackTrace();
			return "something went wrong";
		}
		return "details saved successfully";
	}

	
	
	
	
}
