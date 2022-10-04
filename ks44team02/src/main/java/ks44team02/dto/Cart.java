package ks44team02.dto;

public class Cart {
	private String cartListCode;
	private String memberId;
	private String goodsCode;
	private int regularPrice;
	private int discountPrice;
	private int orderAmount;
	private int regularPriceSubtotal;
	private String orderDatetime;
	private String enterCode;
	public String getCartListCode() {
		return cartListCode;
	}
	public void setCartListCode(String cartListCode) {
		this.cartListCode = cartListCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public int getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getRegularPriceSubtotal() {
		return regularPriceSubtotal;
	}
	public void setRegularPriceSubtotal(int regularPriceSubtotal) {
		this.regularPriceSubtotal = regularPriceSubtotal;
	}
	public String getOrderDatetime() {
		return orderDatetime;
	}
	public void setOrderDatetime(String orderDatetime) {
		this.orderDatetime = orderDatetime;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart [cartListCode=");
		builder.append(cartListCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", regularPrice=");
		builder.append(regularPrice);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", orderAmount=");
		builder.append(orderAmount);
		builder.append(", regularPriceSubtotal=");
		builder.append(regularPriceSubtotal);
		builder.append(", orderDatetime=");
		builder.append(orderDatetime);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append("]");
		return builder.toString();
	}
	
}
