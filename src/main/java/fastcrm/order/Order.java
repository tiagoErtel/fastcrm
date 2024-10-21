package fastcrm.order;

import java.util.Date;

public class Order {
    private String id;
    private String customer_id;
    private Date date;
    private float value;
    private boolean is_canceled;
    private String status;
    private String seller_id;
    private String store_id;
    
    public Order() {};

	public Order(String id, String customer_id, Date date, float value, boolean is_canceled, String status,
			String seller_id, String store_id) {
		this.id = id;
		this.customer_id = customer_id;
		this.date = date;
		this.value = value;
		this.is_canceled = is_canceled;
		this.status = status;
		this.seller_id = seller_id;
		this.store_id = store_id;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	public boolean isIs_canceled() {
		return is_canceled;
	}
	
	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSeller_id() {
		return seller_id;
	}
	
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	
	public String getStore_id() {
		return store_id;
	}
	
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
    
}
