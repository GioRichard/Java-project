package com.abc.buoi2.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
public class Saleorder extends BaseEntity {
	@Column(name = "code", length= 45, nullable = false)
	private String code; 
	
	@Column(name = "user_id", nullable = true)
	private Integer userId;
	
	@Column(name = "total", precision = 13, scale = 2, nullable = true)
	private BigDecimal total; 
	
	@Column(name = "customer_name", length= 100, nullable = true)
	private String customerName; 
	
	@Column(name = "customer_address", length= 100, nullable = true)
	private String customerAddress;
	
	@Column(name = "seo", length= 200, nullable = true)
	private String seo;
	
	@Column(name = "customer_phone", length= 100, nullable = true)
	private String customerPhone;
	
	@Column(name = "cutomer_email", length= 100, nullable = true)
	private String cutomerEmail;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCutomerEmail() {
		return cutomerEmail;
	}

	public void setCutomerEmail(String cutomerEmail) {
		this.cutomerEmail = cutomerEmail;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "saleorder")
	private List<SaleorderProducts> saleorderProducts = new ArrayList<SaleorderProducts>();
	
	public void addSaleorderProducts(SaleorderProducts _saleorderProducts) {
		_saleorderProducts.setSaleorder(this);
		saleorderProducts.add(_saleorderProducts);
	}
	
	public void deleteSaleorderProducts(SaleorderProducts _saleorderProducts ) {
		_saleorderProducts.setSaleorder(this);
		saleorderProducts.remove(_saleorderProducts);
	}
	
	
}
