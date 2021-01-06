package application.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import application.dao.SellerDetailsDao;
import application.dao.SellerMediaDao;
import application.models.SellerDetails;
import application.models.SellerMedia;

@Service
public class SellerMediaService {

	Logger logger = Logger.getLogger(SellerMediaService.class.getName());

	@Autowired
	private SellerMediaDao sellerMediaDao;

	@Autowired
	private SellerDetailsDao dellerdetaildao;

	public String SaveImageDetails() throws Exception {
		try {
			logger.info("saving imavge details: ");
			ClassPathResource jsaCoverImgFile = new ClassPathResource("Images/hello.png");
			byte[] arrayData = new byte[(int) jsaCoverImgFile.contentLength()];
			jsaCoverImgFile.getInputStream().read(arrayData);
			Long id = (long) 1;
			SellerDetails sellerInfo = dellerdetaildao.findByIdAndIsDeleted(id, false);
			logger.info("sellerInfo: " + sellerInfo);
			SellerMedia sellerImage = new SellerMedia();
			sellerImage.setImages(arrayData);
			sellerImage.setSellerdetail(sellerInfo);
			sellerMediaDao.save(sellerImage);
		} catch (IOException e) {
			e.printStackTrace();
			return "something went wrong" + e;
		}
		return "details saved successfully";

	}
	
	public String downloadImages() throws Exception {
		Long id1 = (long) 1;
		try {
			logger.info("saving imavge details: ");
			
			SellerMedia sellerMedia=sellerMediaDao.findByIdAndIsDeleted(id1, false);
			logger.info("sellerMedia:====>>: " + sellerMedia);
			Files.write(Paths.get(  "download/" + "hello"+ "." + "png"), sellerMedia.getImages());
		} catch (IOException e) {
			e.printStackTrace();
			return "something went wrong" + e;
		}
		return "details saved successfully";

	}

}
