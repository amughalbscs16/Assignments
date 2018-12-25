package com.hibernate.aplab8;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name="Customer")
@SecondaryTable(name="CustomerDetail")
public class Customer {
	private int CustomerId;
	private String customerName;
	private String customerAddress;
	private int creditScore;
	private int rewardPoints;
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
	@Column(table="CustomerDetail")
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Column(table="CustomerDetail")
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	@Column(table="CustomerDetail")
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public String toString() {
		return this.getCustomerId() + " " + this.getCustomerName() + " " + this.getCustomerAddress() + " " + this.getCreditScore() + " "+ this.getRewardPoints();
	}
		
}
