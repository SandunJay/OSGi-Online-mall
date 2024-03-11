package customerProducer;

import java.io.Serializable;

public class Customer implements Serializable{

	private String cName;
	private String cAddress;
	private String cEmail;
	private String cPhone;
	private String _id;
	
	public Customer() {}
	
	public Customer(String cName, String cAddress, String cEmail, String cPhone, String _id) {
		super();
		this.cName = cName;
		this.cAddress = cAddress;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this._id = _id;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
