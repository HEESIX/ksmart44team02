package ks44team02.dto;

public class OrderManagement {
	private String orderCode;
	private int regularPriceSubtotal;
	private String orderDiscountCode;
	private int addDiscountPrice;
	private int finalPrice;
	private String orderGroupCode;
	private int usedMileage;
	private int gDeliveryCharge;
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getRegularPriceSubtotal() {
		return regularPriceSubtotal;
	}
	public void setRegularPriceSubtotal(int regularPriceSubtotal) {
		this.regularPriceSubtotal = regularPriceSubtotal;
	}
	public String getOrderDiscountCode() {
		return orderDiscountCode;
	}
	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}
	public int getAddDiscountPrice() {
		return addDiscountPrice;
	}
	public void setAddDiscountPrice(int addDiscountPrice) {
		this.addDiscountPrice = addDiscountPrice;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getOrderGroupCode() {
		return orderGroupCode;
	}
	public void setOrderGroupCode(String orderGroupCode) {
		this.orderGroupCode = orderGroupCode;
	}
	public int getUsedMileage() {
		return usedMileage;
	}
	public void setUsedMileage(int usedMileage) {
		this.usedMileage = usedMileage;
	}
	public int getgDeliveryCharge() {
		return gDeliveryCharge;
	}
	public void setgDeliveryCharge(int gDeliveryCharge) {
		this.gDeliveryCharge = gDeliveryCharge;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderManagement [orderCode=");
		builder.append(orderCode);
		builder.append(", regularPriceSubtotal=");
		builder.append(regularPriceSubtotal);
		builder.append(", orderDiscountCode=");
		builder.append(orderDiscountCode);
		builder.append(", addDiscountPrice=");
		builder.append(addDiscountPrice);
		builder.append(", finalPrice=");
		builder.append(finalPrice);
		builder.append(", orderGroupCode=");
		builder.append(orderGroupCode);
		builder.append(", usedMileage=");
		builder.append(usedMileage);
		builder.append(", gDeliveryCharge=");
		builder.append(gDeliveryCharge);
		builder.append("]");
		return builder.toString();
	}
	
}
