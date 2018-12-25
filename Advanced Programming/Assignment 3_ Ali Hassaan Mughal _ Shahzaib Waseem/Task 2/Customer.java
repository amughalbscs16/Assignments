package org.hibernate.task2;
import javax.persistence.*;
@Entity
@Table(name="Customer")
public class Customer {
	private int CustomerId;
	private String customerName;
	private CustomerDetail customerDetail;
	Customer()
	{
		this.customerDetail = new CustomerDetail();
	}
	@Id
	@GeneratedValue
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	@Column
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Embedded
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	public String toString() {
		return this.getCustomerId() + " " + this.getCustomerName() + " " + this.getCustomerDetail().getCreditScore() + " " +
		this.getCustomerDetail().getCustomerAddress() + " " + this.getCustomerDetail().getRewardPoints();
	}
		
}
