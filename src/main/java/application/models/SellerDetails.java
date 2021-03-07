package application.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import application.pojo.AddressDetails;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SellerDetails extends BaseModel {

	private String name;
	@NotNull
	@NotBlank(message = "mobile number can't be blank")
	@Size(min = 10, max = 12, message = "mobile mumber should be 10 to 12 digits")
	private String mobileNumber;

	@Email(message = "please enter valid email id")
	private String emailId;
	
	private String propertyType;
	
	@Column(name = "seller_address", nullable = true, updatable = true, columnDefinition = "jsonb")
	@Type(type = "jsonb")
	private AddressDetails addressDetails;
	
	private String description;
	
	private String status;
	
	private String price;
	
	private String state;
	
	private String city;
	
	@OneToMany(mappedBy = "sellerdetail")
	private List<SellerMedia> sellerMedia;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<SellerMedia> getSellerMedia() {
		return sellerMedia;
	}

	public void setSellerMedia(List<SellerMedia> sellerMedia) {
		this.sellerMedia = sellerMedia;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "SellerDetails [name=" + name + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", propertyType=" + propertyType + ", addressDetails=" + addressDetails + ", description="
				+ description + ", status=" + status + ", price=" + price + ", state=" + state + ", city=" + city
				+ ", sellerMedia=" + sellerMedia + "]";
	}





	
	
	
	
	

}
