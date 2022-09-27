package ks44team02.dto;
//상품 객체
public class Goods {
	private String goodsCode;
	private String enterCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsDiscountCode;
	private int discountPrice;
	private String goodsProduce;
	private String goodsProductionDate;
	private String goodsExpirationDate;
	private String goodsInfoImage;
	private String goodsMainImage;
	private String goodsRegDatetime;
	private int goodsStock;
	private int goodsDeliveryCharge;
	private char goodsActivation;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsDiscountCode() {
		return goodsDiscountCode;
	}
	public void setGoodsDiscountCode(String goodsDiscountCode) {
		this.goodsDiscountCode = goodsDiscountCode;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getGoodsProduce() {
		return goodsProduce;
	}
	public void setGoodsProduce(String goodsProduce) {
		this.goodsProduce = goodsProduce;
	}
	public String getGoodsProductionDate() {
		return goodsProductionDate;
	}
	public void setGoodsProductionDate(String goodsProductionDate) {
		this.goodsProductionDate = goodsProductionDate;
	}
	public String getGoodsExpirationDate() {
		return goodsExpirationDate;
	}
	public void setGoodsExpirationDate(String goodsExpirationDate) {
		this.goodsExpirationDate = goodsExpirationDate;
	}
	public String getGoodsInfoImage() {
		return goodsInfoImage;
	}
	public void setGoodsInfoImage(String goodsInfoImage) {
		this.goodsInfoImage = goodsInfoImage;
	}
	public String getGoodsMainImage() {
		return goodsMainImage;
	}
	public void setGoodsMainImage(String goodsMainImage) {
		this.goodsMainImage = goodsMainImage;
	}
	public String getGoodsRegDatetime() {
		return goodsRegDatetime;
	}
	public void setGoodsRegDatetime(String goodsRegDatetime) {
		this.goodsRegDatetime = goodsRegDatetime;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public int getGoodsDeliveryCharge() {
		return goodsDeliveryCharge;
	}
	public void setGoodsDeliveryCharge(int goodsDeliveryCharge) {
		this.goodsDeliveryCharge = goodsDeliveryCharge;
	}
	public char getGoodsActivation() {
		return goodsActivation;
	}
	public void setGoodsActivation(char goodsActivation) {
		this.goodsActivation = goodsActivation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsCode=");
		builder.append(goodsCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsDiscountCode=");
		builder.append(goodsDiscountCode);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append(", goodsProduce=");
		builder.append(goodsProduce);
		builder.append(", goodsProductionDate=");
		builder.append(goodsProductionDate);
		builder.append(", goodsExpirationDate=");
		builder.append(goodsExpirationDate);
		builder.append(", goodsInfoImage=");
		builder.append(goodsInfoImage);
		builder.append(", goodsMainImage=");
		builder.append(goodsMainImage);
		builder.append(", goodsRegDatetime=");
		builder.append(goodsRegDatetime);
		builder.append(", goodsStock=");
		builder.append(goodsStock);
		builder.append(", goodsDeliveryCharge=");
		builder.append(goodsDeliveryCharge);
		builder.append(", goodsActivation=");
		builder.append(goodsActivation);
		builder.append("]");
		return builder.toString();
	}
	
	
}
