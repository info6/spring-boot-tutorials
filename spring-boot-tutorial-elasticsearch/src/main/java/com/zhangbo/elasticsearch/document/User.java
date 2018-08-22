package com.zhangbo.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * indexName：索引名称，类比mysql的database
 * type：类型，类比mysql中的table
 */
@Document(indexName = "es", type = "user")
public class User implements Serializable {

	private Long id;

	private String userName;

	private String userPhone;

	private String userAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", userPhone='" + userPhone + '\'' +
				", userAddress='" + userAddress + '\'' + '}';
	}
}
