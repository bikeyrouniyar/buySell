package application.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.SellerMedia;

@Repository
@Transactional
public interface SellerMediaDao extends JpaRepository<SellerMedia, Long> {
	
	public SellerMedia findByIdAndIsDeleted(Long id,boolean isDeleted);

}
