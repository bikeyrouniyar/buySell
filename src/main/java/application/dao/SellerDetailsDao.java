package application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.models.SellerDetails;

public interface SellerDetailsDao extends JpaRepository<SellerDetails, Long>{
	
	public SellerDetails findByIdAndIsDeleted(Long id,boolean isDeleted);
	
	public List<SellerDetails> findByStateAndIsDeleted(String state,boolean isDeleted);
	
	

}
