package application.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class SellerMedia extends BaseModel {
	@Lob
	private byte[] images;
	private String videos;
	
	@ManyToOne
	@JoinColumn(name="seller_id", nullable = false)
	private SellerDetails sellerdetail;

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	public SellerDetails getSellerdetail() {
		return sellerdetail;
	}

	public void setSellerdetail(SellerDetails sellerdetail) {
		this.sellerdetail = sellerdetail;
	}

	@Override
	public String toString() {
		return "SellerMedia [images=" + Arrays.toString(images) + ", videos=" + videos + ", sellerdetail="
				+ sellerdetail + "]";
	}

	
	
	
	

	
	
}
