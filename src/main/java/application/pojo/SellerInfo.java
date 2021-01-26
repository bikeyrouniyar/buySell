package application.pojo;

import java.util.List;

public class SellerInfo {
	
	private String sellerName;
	private String propertyType;
	private String description;
	private String price;
	private List<String> imagesUrl;
	private List<String> videosUrl;
	private AddressDetails addressDetails;
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<String> getImagesUrl() {
		return imagesUrl;
	}
	public void setImagesUrl(List<String> imagesUrl) {
		this.imagesUrl = imagesUrl;
	}
	public List<String> getVideosUrl() {
		return videosUrl;
	}
	public void setVideosUrl(List<String> videosUrl) {
		this.videosUrl = videosUrl;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	@Override
	public String toString() {
		return "SellerInfo [sellerName=" + sellerName + ", propertyType=" + propertyType + ", description="
				+ description + ", price=" + price + ", imagesUrl=" + imagesUrl + ", videosUrl=" + videosUrl
				+ ", addressDetails=" + addressDetails + "]";
	}
	
	
	
	
	
	

}
