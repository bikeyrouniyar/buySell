package application.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.SellerDetails;
import application.models.SellerMedia;

@Repository
@Transactional
public interface SellerMediaDao extends JpaRepository<SellerMedia, Long> {
	
	public SellerMedia findByIdAndIsDeleted(Long id,boolean isDeleted);
	public List<SellerMedia> findBySellerdetailAndIsDeleted(SellerDetails sellerdetail,boolean isDeleted);
	public SellerMedia  findByImagesAndIsDeleted(String images,boolean isDeleted);
	
	

}
