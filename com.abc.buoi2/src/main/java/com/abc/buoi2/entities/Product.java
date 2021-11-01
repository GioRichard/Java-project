package com.abc.buoi2.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_products")
public class Product extends BaseEntity {
	
	@Column(name = "title", length= 1000, nullable = false)
	private String title;
	
	@Column(name = "price",precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(name = "price_sale",precision = 13, scale = 2, nullable = true)
	private BigDecimal priceSale;
	
	@Column(name = "short_description", length= 3000, nullable = false)
	private String shortDes;
	
	@Lob
	@Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT" )
	private String detail;
	
	@Column(name = "avatar", length= 200, nullable = true)
	private String avatar;

	@Column(name = "seo", length= 1000, nullable = true)
	private String seo;
	
	@Column(name = "is_hot",  nullable = true)
	private Boolean isHot = Boolean.FALSE;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Categories categories;
	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getPriceSale() {
		return priceSale;
	}


	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}


	public String getShortDes() {
		return shortDes;
	}


	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getSeo() {
		return seo;
	}


	public void setSeo(String seo) {
		this.seo = seo;
	}


	public Boolean getIsHot() {
		return isHot;
	}


	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}


	public Categories getCategories() {
		return categories;
	}


	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
	private List<ProductsImages> productsImages = new ArrayList<ProductsImages>();
	
	public void addProductsImages(ProductsImages _productsImages) {
		_productsImages.setProduct(this);
		productsImages.add(_productsImages);
	}
	
	public void deleteProductsImages(ProductsImages _productsImages) {
		_productsImages.setProduct(this);
		productsImages.remove(_productsImages);
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "saleorder")
	private List<SaleorderProducts> saleorderProducts = new ArrayList<SaleorderProducts>();
	
	public void addSaleorderProducts(SaleorderProducts _saleorderProducts) {
		_saleorderProducts.setProduct(this);
		saleorderProducts.add(_saleorderProducts);
	}
	
	public void deleteSaleorderProducts(SaleorderProducts _saleorderProducts ) {
		_saleorderProducts.setProduct(this);
		saleorderProducts.remove(_saleorderProducts);
	}
}
