package dev.karthi.gym_project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Subscriptions {
    @Id
	private String id;
    private String memberId; // foreign key to Member
    private String planType; // monthly, 3months, etc.
    private double amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Subscriptions(String id, String memberId, String planType, double amount, LocalDateTime startDate,
			LocalDateTime endDate, boolean isActive) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.planType = planType;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}
	public Subscriptions() {
		super();
	}

   
}
