package org.hibernate.task2;

import javax.persistence.*;
@Embeddable
public class CustomerDetail {
	private String customerAddress;
	private int creditScore;
	private int rewardPoints;
	public String getCustomerAddress() {
		return this.customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
}
