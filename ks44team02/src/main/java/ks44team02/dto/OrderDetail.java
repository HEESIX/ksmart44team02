package ks44team02.dto;

public class OrderDetail {
	private String orderDetailCode;
	private String memberId;
	private String goodsCode;
	private int discountPrice;
	private int orderAmount;
	private int regularPriceSubtotal;
	private String orderDateTime;
	private String orderGroupCode;
	private String enterCode;
	private int gDeliveryCharge;
	
	private Enterprise enterprise;
	private Goods goods;
	private GoodsMainImage goodsMainImageInfo;
	private Delivery delivery;
	private OrderStatus orderStatus;
	private OrderStatusStandard orderStatusStandard;
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
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
	public String getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public String getOrderGroupCode() {
		return orderGroupCode;
	}
	public void setOrderGroupCode(String orderGroupCode) {
		this.orderGroupCode = orderGroupCode;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public int getgDeliveryCharge() {
		return gDeliveryCharge;
	}
	public void setgDeliveryCharge(int gDeliveryCharge) {
		this.gDeliveryCharge = gDeliveryCharge;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public GoodsMainImage getGoodsMainImageInfo() {
		return goodsMainImageInfo;
	}
	public void setGoodsMainImageInfo(GoodsMainImage goodsMainImageInfo) {
		this.goodsMainImageInfo = goodsMainImageInfo;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public OrderStatusStandard getOrderStatusStandard() {
		return orderStatusStandard;
	}
	public void setOrderStatusStandard(OrderStatusStandard orderStatusStandard) {
		this.orderStatusStandard = orderStatusStandard;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetail [orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", orderAmount=");
		builder.append(orderAmount);
		builder.append(", regularPriceSubtotal=");
		builder.append(regularPriceSubtotal);
		builder.append(", orderDateTime=");
		builder.append(orderDateTime);
		builder.append(", orderGroupCode=");
		builder.append(orderGroupCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", gDeliveryCharge=");
		builder.append(gDeliveryCharge);
		builder.append(", enterprise=");
		builder.append(enterprise);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", goodsMainImageInfo=");
		builder.append(goodsMainImageInfo);
		builder.append(", delivery=");
		builder.append(delivery);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", orderStatusStandard=");
		builder.append(orderStatusStandard);
		builder.append("]");
		return builder.toString();
	}
	
	
}

