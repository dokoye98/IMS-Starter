package com.qa.ims.persistence.domain;

public class Order {
	
	//this class is a joining class
	private Long Order_ID;
	private Long Customer_ID;
	
	//with order_id which is used a reference
	public Order(Long order_ID, Long customer_ID) {
		super();
		Order_ID = order_ID;
		Customer_ID = customer_ID;
	}

	public Order(Long customer_ID) {
		super();
		Customer_ID = customer_ID;
	}

	@Override
	public String toString() {
		return "Order [Order_ID=" + Order_ID + ", Customer_ID=" + Customer_ID + "]";
	}
//hash code with generated methods as done in the skeleton(customer) 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Customer_ID == null) ? 0 : Customer_ID.hashCode());
		result = prime * result + ((Order_ID == null) ? 0 : Order_ID.hashCode());
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
		Order other = (Order) obj;
		if (Customer_ID == null) {
			if (other.Customer_ID != null)
				return false;
		} else if (!Customer_ID.equals(other.Customer_ID))
			return false;
		if (Order_ID == null) {
			if (other.Order_ID != null)
				return false;
		} else if (!Order_ID.equals(other.Order_ID))
			return false;
		return true;
	}

	/**
	 * @return the order_ID
	 */
	public Long getOrder_ID() {
		return Order_ID;
	}

	/**
	 * @param order_ID the order_ID to set
	 */
	public void setOrder_ID(Long order_ID) {
		Order_ID = order_ID;
	}

	/**
	 * @return the customer_ID
	 */
	public Long getCustomer_ID() {
		return Customer_ID;
	}

	/**
	 * @param customer_ID the customer_ID to set
	 */
	public void setCustomer_ID(Long customer_ID) {
		Customer_ID = customer_ID;
	}
	

}
