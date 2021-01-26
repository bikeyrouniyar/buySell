package application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.SellerDetailsDao;
import application.models.SellerDetails;
import application.pojo.SellerInfo;

@Service
public class SellerDetailsService {

	Logger logger = Logger.getLogger(SellerDetailsService.class.getName());

	@Autowired
	private SellerDetailsDao sellerDetailDao;

	public String saveSellerInfo(SellerDetails sellerInfo) {
		try {
			logger.info("saving Seller details: " + sellerInfo.getMobileNumber());
			String state = sellerInfo.getAddressDetails().getState();
			String city = sellerInfo.getAddressDetails().getCityName();
			SellerDetails sellerdetail = new SellerDetails();
			sellerdetail = sellerInfo;
			sellerdetail.setState(state);
			sellerdetail.setCity(city);
			sellerDetailDao.save(sellerdetail);
		} catch (Exception e) {
			logger.info("saving details failed" + e);
			e.printStackTrace();
			return "something went wrong";
		}
		return "details saved successfully";
	}

	public List<SellerInfo> getByState(String state) {
		List<SellerInfo> sellerInfoList = new ArrayList<SellerInfo>();

		try {
			List<SellerDetails> sellerDetails = sellerDetailDao.findByStateAndIsDeleted(state, false);
			if (sellerDetails != null && !sellerDetails.isEmpty()) {
				logger.info("sellerinfo size==: " + sellerDetails.size());

				for (SellerDetails sellerDetail : sellerDetails) {
					setSellerInfo(sellerDetail, sellerInfoList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sellerInfoList;
	}
	
	public void setSellerInfo(SellerDetails sellerDetail,List<SellerInfo> sellerInfoList) {
		SellerInfo sellerInfo = new SellerInfo();
		sellerInfo.setSellerName(sellerDetail.getName());
		sellerInfo.setDescription(sellerDetail.getDescription());
		sellerInfo.setPrice(sellerDetail.getPrice());
		sellerInfo.setAddressDetails(sellerDetail.getAddressDetails());
		sellerInfo.setPropertyType(sellerDetail.getPropertyType());
		sellerInfoList.add(sellerInfo);
	}
	
	
	
	public List<SellerInfo> getall(){
		List<SellerInfo> sellerInfoList = new ArrayList<SellerInfo>();
		try {
			List<SellerDetails> sellerDetails = sellerDetailDao.findAll();
			if (sellerDetails != null && !sellerDetails.isEmpty()) {
				logger.info("sellerinfo size==: " + sellerDetails.size());

				for (SellerDetails sellerDetail : sellerDetails) {
					setSellerInfo(sellerDetail, sellerInfoList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sellerInfoList;
		
	}
	
	

}
