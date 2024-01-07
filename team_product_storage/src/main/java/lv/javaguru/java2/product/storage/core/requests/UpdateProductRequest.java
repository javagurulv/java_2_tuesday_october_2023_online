package lv.javaguru.java2.product.storage.core.requests;

import java.math.BigDecimal;

public class UpdateProductRequest {

	private Long id;
	private String newProductName;
	private String newProductBrand;

	private String newProductModel;
	private Integer newProductQuantity;

	private BigDecimal newPrice;

	public UpdateProductRequest() { }

	public UpdateProductRequest(Long id, String newProductName, String newProductBrand, String newProductModel, Integer newProductQuantity, BigDecimal newPrice) {
		this.id = id;
		this.newProductName = newProductName;
		this.newProductBrand = newProductBrand;
		this.newProductModel = newProductModel;
		this.newProductQuantity = newProductQuantity;
		this.newPrice = newPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewProductName() {
		return newProductName;
	}

	public void setNewProductName(String newProductName) {
		this.newProductName = newProductName;
	}

	public String getNewProductBrand() {
		return newProductBrand;
	}

	public void setNewProductBrand(String newProductBrand) {
		this.newProductBrand = newProductBrand;
	}

	public String getNewProductModel() {
		return newProductModel;
	}

	public void setNewProductModel(String newProductModel) {
		this.newProductModel = newProductModel;
	}

	public Integer getNewProductQuantity() {
		return newProductQuantity;
	}

	public void setNewProductQuantity(Integer newProductQuantity) {
		this.newProductQuantity = newProductQuantity;
	}

	public BigDecimal getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
}