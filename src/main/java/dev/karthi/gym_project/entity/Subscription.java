package dev.karthi.gym_project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Subscription {
	@Id
	private String id; 
	    private String memberId; 
	    private LocalDate startDate; 
	    private LocalDate endDate; 
	    private double amount; 
	    private String status; 
	    private LocalDateTime paymentDate; 
	    private String planType;
	    
	    
	    
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
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}
		public String getPlanType() {
			return planType;
		}
		public void setPlanType(String planType) {
			this.planType = planType;
		}
		public Subscription(String id, String memberId, LocalDate startDate, LocalDate endDate, double amount,
				String status, LocalDateTime paymentDate, String planType) {
			super();
			this.id = id;
			this.memberId = memberId;
			this.startDate = startDate;
			this.endDate = endDate;
			this.amount = amount;
			this.status = status;
			this.paymentDate = paymentDate;
			this.planType = planType;
		}
		public Subscription() {
			super();
		}
		@Override
		public String toString() {
			return "Subscription [id=" + id + ", memberId=" + memberId + ", startDate=" + startDate + ", endDate="
					+ endDate + ", amount=" + amount + ", status=" + status + ", paymentDate=" + paymentDate
					+ ", planType=" + planType + "]";
		}
	    
	    
   
}
