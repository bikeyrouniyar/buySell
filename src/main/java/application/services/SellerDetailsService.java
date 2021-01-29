package application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.SellerDetailsDao;
import application.dao.SellerMediaDao;
import application.models.SellerDetails;
import application.models.SellerMedia;
import application.pojo.SellerInfo;
import application.utils.ReadFileName;

@Service
public class SellerDetailsService {

	Logger logger = Logger.getLogger(SellerDetailsService.class.getName());

	@Autowired
	private SellerDetailsDao sellerDetailDao;

	@Autowired
	private SellerMediaDao sellerMediaDao;

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
			getSellerMedia();
		} catch (Exception e) {
			logger.info("saving details failed" + e);
			e.printStackTrace();
			return "something went wrong";
		}
		logger.info("details are saved successfully");
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
		logger.info("seller info by state: " + sellerInfoList);
		return sellerInfoList;
	}

	public void getSellerMedia() throws Exception {
		String[] fileNames = ReadFileName.readFileNames();
		if (fileNames != null) {
			for (String fileName : fileNames) {
				if (fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
					logger.info("images name:=>: " + fileName);
					try {
						String[] sellerImageId = fileName.split("_", 2);
						setSellerMedia(sellerImageId[0], fileName);
					} catch (Exception e) {
						e.printStackTrace();

					}
				}
			}
		}
	}

	public void setSellerMedia(String sellerId, String fileName) {
		long id = Long.parseLong(sellerId);
		SellerDetails sellerDetail = sellerDetailDao.findByIdAndIsDeleted(id, false);
		if (sellerDetail != null) {
			SellerMedia sellerMedia = new SellerMedia();
			sellerMedia.setSellerdetail(sellerDetail);
			logger.info("sellerDetail id:=:  " + sellerDetail.getId());
			sellerMedia.setImages(fileName);
			sellerMediaDao.save(sellerMedia);
		}

	}

	public void setSellerInfo(SellerDetails sellerDetail, List<SellerInfo> sellerInfoList) {
		SellerInfo sellerInfo = new SellerInfo();
		sellerInfo.setSellerName(sellerDetail.getName());
		sellerInfo.setDescription(sellerDetail.getDescription());
		sellerInfo.setPrice(sellerDetail.getPrice());
		sellerInfo.setAddressDetails(sellerDetail.getAddressDetails());
		sellerInfo.setPropertyType(sellerDetail.getPropertyType());
		sellerInfo.setImagesUrl(imagesList(sellerDetail));
		sellerInfoList.add(sellerInfo);
	}
	
	public List<String> imagesList(SellerDetails sellerDetail){
		List<String> images=new ArrayList<String>();
		List<SellerMedia> mediaDetails= sellerMediaDao.findBySellerdetailAndIsDeleted(sellerDetail, false);
		if(mediaDetails!=null && !mediaDetails.isEmpty()) {
			for(SellerMedia sellerMedia: mediaDetails) {
				images.add(sellerMedia.getImages());
			}
		}
		logger.info("images list==>>: " + images);
		return images;
	}

	public List<SellerInfo> getall() {
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
		logger.info("seller info get all=>: " + sellerInfoList);
		return sellerInfoList;

	}

	public List<SellerInfo> getByCity(String city) {
		List<SellerInfo> sellerInfoList = new ArrayList<SellerInfo>();

		try {
			List<SellerDetails> sellerDetails = sellerDetailDao.findByCityAndIsDeleted(city, false);
			if (sellerDetails != null && !sellerDetails.isEmpty()) {
				logger.info("sellerinfo size==: " + sellerDetails.size());

				for (SellerDetails sellerDetail : sellerDetails) {
					setSellerInfo(sellerDetail, sellerInfoList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("seller info by city=>: " + sellerInfoList);
		return sellerInfoList;
	}
}
