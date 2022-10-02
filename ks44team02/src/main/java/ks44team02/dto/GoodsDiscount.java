package ks44team02.dto;

//상품별 할인 혜택 객체
public class GoodsDiscount {
	private String goodsDiscountCode;
	private int goodsDiscountPrice;
	private int goodsDiscountRate;
	private String goodsDiscountName;
	private String goodsDiscountExpirationDate;
	private String goodsDiscountRegistrant;
	private String goodsDiscountRegDatetime;
	private String enterCode;
	
	private Enterprise enterprise;
	
	

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getGoodsDiscountCode() {
		return goodsDiscountCode;
	}

	public void setGoodsDiscountCode(String goodsDiscountCode) {
		this.goodsDiscountCode = goodsDiscountCode;
	}

	public int getGoodsDiscountPrice() {
		return goodsDiscountPrice;
	}

	public void setGoodsDiscountPrice(int goodsDiscountPrice) {
		this.goodsDiscountPrice = goodsDiscountPrice;
	}

	public int getGoodsDiscountRate() {
		return goodsDiscountRate;
	}

	public void setGoodsDiscountRate(int goodsDiscountRate) {
		this.goodsDiscountRate = goodsDiscountRate;
	}

	public String getGoodsDiscountName() {
		return goodsDiscountName;
	}

	public void setGoodsDiscountName(String goodsDiscountName) {
		this.goodsDiscountName = goodsDiscountName;
	}

	public String getGoodsDiscountExpirationDate() {
		return goodsDiscountExpirationDate;
	}

	public void setGoodsDiscountExpirationDate(String goodsDiscountExpirationDate) {
		this.goodsDiscountExpirationDate = goodsDiscountExpirationDate;
	}

	public String getGoodsDiscountRegistrant() {
		return goodsDiscountRegistrant;
	}

	public void setGoodsDiscountRegistrant(String goodsDiscountRegistrant) {
		this.goodsDiscountRegistrant = goodsDiscountRegistrant;
	}

	public String getGoodsDiscountRegDatetime() {
		return goodsDiscountRegDatetime;
	}

	public void setGoodsDiscountRegDatetime(String goodsDiscountRegDatetime) {
		this.goodsDiscountRegDatetime = goodsDiscountRegDatetime;
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
		builder.append("GoodsDiscount [goodsDiscountCode=");
		builder.append(goodsDiscountCode);
		builder.append(", goodsDiscountPrice=");
		builder.append(goodsDiscountPrice);
		builder.append(", goodsDiscountRate=");
		builder.append(goodsDiscountRate);
		builder.append(", goodsDiscountName=");
		builder.append(goodsDiscountName);
		builder.append(", goodsDiscountExpirationDate=");
		builder.append(goodsDiscountExpirationDate);
		builder.append(", goodsDiscountRegistrant=");
		builder.append(goodsDiscountRegistrant);
		builder.append(", goodsDiscountRegDatetime=");
		builder.append(goodsDiscountRegDatetime);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", enterprise=");
		builder.append(enterprise);
		builder.append("]");
		return builder.toString();
	}

}
