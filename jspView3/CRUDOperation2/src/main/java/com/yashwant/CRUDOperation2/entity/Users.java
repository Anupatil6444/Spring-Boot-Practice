package com.yashwant.CRUDOperation2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name="userId")
		private int userId;
		
		@Column(name="userName")
		private String userName;
		
		@Column(name="userAddress")
		private String userAddress;
		
		@Column(name="userAge")
		private  int userAge;
		
		@Column(name="userSalary")
		private float userSalary;

		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Users(int userId, String userName, String userAddress, int userAge, float userSalary) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userAddress = userAddress;
			this.userAge = userAge;
			this.userSalary = userSalary;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}

		public int getUserAge() {
			return userAge;
		}

		public void setUserAge(int userAge) {
			this.userAge = userAge;
		}

		public float getUserSalary() {
			return userSalary;
		}

		public void setUserSalary(float userSalary) {
			this.userSalary = userSalary;
		}

		@Override
		public String toString() {
			return "Users [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userAge="
					+ userAge + ", userSalary=" + userSalary + "]";
		}
		
	
}
