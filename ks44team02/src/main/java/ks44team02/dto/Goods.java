package ks44team02.dto;

import java.util.Arrays;

//상품 객체
public class Goods {
	private String goodsCode;
	private String enterCode;
	private String goodsCateCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsDiscountCode;
	private int goodsDiscountedPrice;
	private float goodsNetWeight;
	private String goodsNetWeightUnit;
	private String goodsProduce;
	private String goodsProductionExpirationInfo;
	private String goodsInfoImageCode;
	private String goodsMainImageCode;
	private int goodsStock;
	private int goodsDeliveryCharge;
	private String goodsRegDatetime;
	private int goodsActivation;
	
	private Enterprise enterprise;
	private GoodsDiscount goodsDiscount;
	private GoodsCategory goodsCategory;
	private Ingredient ingredient;
	private MenuInformation menuInformation;
	private MenuOrganize[] menuOrganizes;
	private GoodsMainImage goodsMainImageInfo;
	private GoodsInfoImage goodsInfoImageInfo;
	
	public MenuOrganize[] getMenuOrganizes() {
		return menuOrganizes;
	}
	public void setMenuOrganizes(MenuOrganize[] menuOrganizes) {
		this.menuOrganizes = menuOrganizes;
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
	public int getGoodsDiscountedPrice() {
		return goodsDiscountedPrice;
	}
	public void setGoodsDiscountedPrice(int goodsDiscountedPrice) {
		this.goodsDiscountedPrice = goodsDiscountedPrice;
	}
	public float getGoodsNetWeight() {
		return goodsNetWeight;
	}
	public void setGoodsNetWeight(float goodsNetWeight) {
		this.goodsNetWeight = goodsNetWeight;
	}
	public String getGoodsNetWeightUnit() {
		return goodsNetWeightUnit;
	}
	public void setGoodsNetWeightUnit(String goodsNetWeightUnit) {
		this.goodsNetWeightUnit = goodsNetWeightUnit;
	}
	public String getGoodsProduce() {
		return goodsProduce;
	}
	public void setGoodsProduce(String goodsProduce) {
		this.goodsProduce = goodsProduce;
	}
	public String getGoodsProductionExpirationInfo() {
		return goodsProductionExpirationInfo;
	}
	public void setGoodsProductionExpirationInfo(String goodsProductionExpirationInfo) {
		this.goodsProductionExpirationInfo = goodsProductionExpirationInfo;
	}
	
	public String getGoodsInfoImageCode() {
		return goodsInfoImageCode;
	}
	public void setGoodsInfoImageCode(String goodsInfoImageCode) {
		this.goodsInfoImageCode = goodsInfoImageCode;
	}
	public String getGoodsMainImageCode() {
		return goodsMainImageCode;
	}
	public void setGoodsMainImageCode(String goodsMainImageCode) {
		this.goodsMainImageCode = goodsMainImageCode;
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
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public GoodsDiscount getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(GoodsDiscount goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(GoodsCategory goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public MenuInformation getMenuInformation() {
		return menuInformation;
	}
	public void setMenuInformation(MenuInformation menuInformation) {
		this.menuInformation = menuInformation;
	}
	public GoodsMainImage getGoodsMainImageInfo() {
		return goodsMainImageInfo;
	}
	public void setGoodsMainImageInfo(GoodsMainImage goodsMainImageInfo) {
		this.goodsMainImageInfo = goodsMainImageInfo;
	}
	public GoodsInfoImage getGoodsInfoImageInfo() {
		return goodsInfoImageInfo;
	}
	public void setGoodsInfoImageInfo(GoodsInfoImage goodsInfoImageInfo) {
		this.goodsInfoImageInfo = goodsInfoImageInfo;
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
		builder.append(", goodsDiscountedPrice=");
		builder.append(goodsDiscountedPrice);
		builder.append(", goodsNetWeight=");
		builder.append(goodsNetWeight);
		builder.append(", goodsNetWeightUnit=");
		builder.append(goodsNetWeightUnit);
		builder.append(", goodsProduce=");
		builder.append(goodsProduce);
		builder.append(", goodsProductionExpirationInfo=");
		builder.append(goodsProductionExpirationInfo);
		builder.append(", goodsInfoImageCode=");
		builder.append(goodsInfoImageCode);
		builder.append(", goodsMainImageCode=");
		builder.append(goodsMainImageCode);
		builder.append(", goodsStock=");
		builder.append(goodsStock);
		builder.append(", goodsDeliveryCharge=");
		builder.append(goodsDeliveryCharge);
		builder.append(", goodsRegDatetime=");
		builder.append(goodsRegDatetime);
		builder.append(", goodsActivation=");
		builder.append(goodsActivation);
		builder.append(", enterprise=");
		builder.append(enterprise);
		builder.append(", goodsDiscount=");
		builder.append(goodsDiscount);
		builder.append(", goodsCategory=");
		builder.append(goodsCategory);
		builder.append(", ingredient=");
		builder.append(ingredient);
		builder.append(", menuInformation=");
		builder.append(menuInformation);
		builder.append(", menuOrganizes=");
		builder.append(Arrays.toString(menuOrganizes));
		builder.append(", goodsMainImageInfo=");
		builder.append(goodsMainImageInfo);
		builder.append(", goodsInfoImageInfo=");
		builder.append(goodsInfoImageInfo);
		builder.append("]");
		return builder.toString();
	}
	
}
