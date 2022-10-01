package ks44team02.dto;

//상품 객체
public class Goods {
	private String goodsCode;
	private String enterCode;
	private String goodsCateCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsDiscountCode;
	private int goodsDiscountPrice;
	private float goodsNetWeight;
	private String goodsNetWeightUnit;
	private String goodsProduce;
	private String goodsProductionExpirationDate;
	private String goodsInfoImage;
	private String goodsMainImage;
	private int goodsStock;
	private int goodsDeliveryCharge;
	private String goodsRegDatetime;
	private int goodsActivation;
	
	private Enterprise enterprise;
	private GoodsDiscount goodsDiscount;
	private GoodsCategory goodsCategory;
	private Ingredient ingredient;
	private Menus menu;
	private GoodsMainImage goodsMainImageInfo;
	private GoodsInfoImage goodsInfoImageInfo;
	

	public String getGoodsNetWeightUnit() {
		return goodsNetWeightUnit;
	}

	public void setGoodsNetWeightUnit(String goodsNetWeightUnit) {
		this.goodsNetWeightUnit = goodsNetWeightUnit;
	}

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

	public String getGoodsCateCode() {
		return goodsCateCode;
	}

	public void setGoodsCateCode(String goodsCateCode) {
		this.goodsCateCode = goodsCateCode;
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

	public int getGoodsDiscountPrice() {
		return goodsDiscountPrice;
	}

	public void setGoodsDiscountPrice(int goodsDiscountPrice) {
		this.goodsDiscountPrice = goodsDiscountPrice;
	}

	public float getGoodsNetWeight() {
		return goodsNetWeight;
	}

	public void setGoodsNetWeight(float goodsNetWeight) {
		this.goodsNetWeight = goodsNetWeight;
	}

	public String getGoodsProduce() {
		return goodsProduce;
	}

	public void setGoodsProduce(String goodsProduce) {
		this.goodsProduce = goodsProduce;
	}

	public String getGoodsProductionExpirationDate() {
		return goodsProductionExpirationDate;
	}

	public void setGoodsProductionExpirationDate(String goodsProductionExpirationDate) {
		this.goodsProductionExpirationDate = goodsProductionExpirationDate;
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

	public String getGoodsRegDatetime() {
		return goodsRegDatetime;
	}

	public void setGoodsRegDatetime(String goodsRegDatetime) {
		this.goodsRegDatetime = goodsRegDatetime;
	}

	public int getGoodsActivation() {
		return goodsActivation;
	}

	public void setGoodsActivation(int goodsActivation) {
		this.goodsActivation = goodsActivation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsCode=");
		builder.append(goodsCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", goodsCateCode=");
		builder.append(goodsCateCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsDiscountCode=");
		builder.append(goodsDiscountCode);
		builder.append(", goodsDiscountPrice=");
		builder.append(goodsDiscountPrice);
		builder.append(", goodsNetWeight=");
		builder.append(goodsNetWeight);
		builder.append(", goodsNetWeightUnit=");
		builder.append(goodsNetWeightUnit);
		builder.append(", goodsProduce=");
		builder.append(goodsProduce);
		builder.append(", goodsProductionExpirationDate=");
		builder.append(goodsProductionExpirationDate);
		builder.append(", goodsInfoImage=");
		builder.append(goodsInfoImage);
		builder.append(", goodsMainImage=");
		builder.append(goodsMainImage);
		builder.append(", goodsStock=");
		builder.append(goodsStock);
		builder.append(", goodsDeliveryCharge=");
		builder.append(goodsDeliveryCharge);
		builder.append(", goodsRegDatetime=");
		builder.append(goodsRegDatetime);
		builder.append(", goodsActivation=");
		builder.append(goodsActivation);
		builder.append("]");
		return builder.toString();
	}

}
