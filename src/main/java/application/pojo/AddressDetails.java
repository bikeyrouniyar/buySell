package application.pojo;

import java.io.Serializable;

public class AddressDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String houseNo;
	private String streetName;
	private String areaName;
	private String cityName;
	private String country;
	private String State;
	private String pinCode;
	private double latitude;
	private double longitude;
	private String wardNumber;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	@Override
	public String toString() {
		return "AddressDetails [houseNo=" + houseNo + ", streetName=" + streetName + ", areaName=" + areaName
				+ ", cityName=" + cityName + ", country=" + country + ", State=" + State + ", pinCode=" + pinCode
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", wardNumber=" + wardNumber + "]";
	}


}
