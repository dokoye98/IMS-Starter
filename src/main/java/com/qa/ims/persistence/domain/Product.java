package com.qa.ims.persistence.domain;

public class Product {
	//fields needed product id, cost, addOns
	public Long productId;
	public double cost; 
	public String addOns;
	
	//Constructor id
	public Product(Long productId, double cost, String addOns) {
		super();
		this.productId = productId;
		this.cost = cost;
		this.addOns = addOns;
	}
//constructor no id 
	public Product(double cost, String addOns) {
		super();
		this.cost = cost;
		this.addOns = addOns;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", cost=" + cost + ", addOns=" + addOns + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addOns == null) ? 0 : addOns.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (addOns == null) {
			if (other.addOns != null)
				return false;
		} else if (!addOns.equals(other.addOns))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the addOns
	 */
	public String getAddOns() {
		return addOns;
	}
	/**
	 * @param addOns the addOns to set
	 */
	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}
	
	
	
	
	
	

}
