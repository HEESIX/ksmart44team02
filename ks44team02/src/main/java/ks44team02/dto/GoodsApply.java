package ks44team02.dto;

public class GoodsApply {
	private String goodsApplyCode;
	private String enterCode;
	private String goodsCategoryCode;
	private String goodsApplyName;
	private int goodsApplyPrice;
	private String goodsDiscountCode;
	private int goodsApplyDiscount;
	private float goodsApplyNetWeight;
	private String goodsApplyNetWeightUnit;
	private String goodsApplyProduce;
	private String goodsApplyProductionExpirationInfo;
	private String goodsApplyMainImage;
	private String goodsApplyInfoImage;
	private String goodsApplyRegDatetime;
	private int goodsApplyStock;
	private int goodsApplyDeliveryCharge;
	private String goodsApplyApproveRefuse;
	private String goodsApplyApproveDatetime;
	private String goodsApplyRefuseReason;
	
	private Enterprise enterprise;
	private GoodsDiscount goodsDiscount;
	private GoodsCategory goodsCategory;
	private Ingredient ingredient;
	private GoodsMainImage goodsMainImageInfo;
	private GoodsInfoImage goodsInfoImageInfo;
	
	
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
	public String getGoodsApplyCode() {
		return goodsApplyCode;
	}
	public void setGoodsApplyCode(String goodsApplyCode) {
		this.goodsApplyCode = goodsApplyCode;
	}
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}
	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}
	public String getGoodsApplyName() {
		return goodsApplyName;
	}
	public void setGoodsApplyName(String goodsApplyName) {
		this.goodsApplyName = goodsApplyName;
	}
	public int getGoodsApplyPrice() {
		return goodsApplyPrice;
	}
	public void setGoodsApplyPrice(int goodsApplyPrice) {
		this.goodsApplyPrice = goodsApplyPrice;
	}
	public String getGoodsDiscountCode() {
		return goodsDiscountCode;
	}
	public void setGoodsDiscountCode(String goodsDiscountCode) {
		this.goodsDiscountCode = goodsDiscountCode;
	}
	public int getGoodsApplyDiscount() {
		return goodsApplyDiscount;
	}
	public void setGoodsApplyDiscount(int goodsApplyDiscount) {
		this.goodsApplyDiscount = goodsApplyDiscount;
	}
	public float getGoodsApplyNetWeight() {
		return goodsApplyNetWeight;
	}
	public void setGoodsApplyNetWeight(float goodsApplyNetWeight) {
		this.goodsApplyNetWeight = goodsApplyNetWeight;
	}
	public String getGoodsApplyNetWeightUnit() {
		return goodsApplyNetWeightUnit;
	}
	public void setGoodsApplyNetWeightUnit(String goodsApplyNetWeightUnit) {
		this.goodsApplyNetWeightUnit = goodsApplyNetWeightUnit;
	}
	public String getGoodsApplyProduce() {
		return goodsApplyProduce;
	}
	public void setGoodsApplyProduce(String goodsApplyProduce) {
		this.goodsApplyProduce = goodsApplyProduce;
	}
	public String getGoodsApplyProductionExpirationInfo() {
		return goodsApplyProductionExpirationInfo;
	}
	public void setGoodsApplyProductionExpirationInfo(String goodsApplyProductionExpirationInfo) {
		this.goodsApplyProductionExpirationInfo = goodsApplyProductionExpirationInfo;
	}
	public String getGoodsApplyMainImage() {
		return goodsApplyMainImage;
	}
	public void setGoodsApplyMainImage(String goodsApplyMainImage) {
		this.goodsApplyMainImage = goodsApplyMainImage;
	}
	public String getGoodsApplyInfoImage() {
		return goodsApplyInfoImage;
	}
	public void setGoodsApplyInfoImage(String goodsApplyInfoImage) {
		this.goodsApplyInfoImage = goodsApplyInfoImage;
	}
	public String getGoodsApplyRegDatetime() {
		return goodsApplyRegDatetime;
	}
	public void setGoodsApplyRegDatetime(String goodsApplyRegDatetime) {
		this.goodsApplyRegDatetime = goodsApplyRegDatetime;
	}
	public int getGoodsApplyStock() {
		return goodsApplyStock;
	}
	public void setGoodsApplyStock(int goodsApplyStock) {
		this.goodsApplyStock = goodsApplyStock;
	}
	public int getGoodsApplyDeliveryCharge() {
		return goodsApplyDeliveryCharge;
	}
	public void setGoodsApplyDeliveryCharge(int goodsApplyDeliveryCharge) {
		this.goodsApplyDeliveryCharge = goodsApplyDeliveryCharge;
	}
	public String getGoodsApplyApproveRefuse() {
		return goodsApplyApproveRefuse;
	}
	public void setGoodsApplyApproveRefuse(String goodsApplyApproveRefuse) {
		this.goodsApplyApproveRefuse = goodsApplyApproveRefuse;
	}
	public String getGoodsApplyApproveDatetime() {
		return goodsApplyApproveDatetime;
	}
	public void setGoodsApplyApproveDatetime(String goodsApplyApproveDatetime) {
		this.goodsApplyApproveDatetime = goodsApplyApproveDatetime;
	}
	public String getGoodsApplyRefuseReason() {
		return goodsApplyRefuseReason;
	}
	public void setGoodsApplyRefuseReason(String goodsApplyRefuseReason) {
		this.goodsApplyRefuseReason = goodsApplyRefuseReason;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsApply [goodsApplyCode=");
		builder.append(goodsApplyCode);
		builder.append(", enterCode=");
		builder.append(enterCode);
		builder.append(", goodsCategoryCode=");
		builder.append(goodsCategoryCode);
		builder.append(", goodsApplyName=");
		builder.append(goodsApplyName);
		builder.append(", goodsApplyPrice=");
		builder.append(goodsApplyPrice);
		builder.append(", goodsDiscountCode=");
		builder.append(goodsDiscountCode);
		builder.append(", goodsApplyDiscount=");
		builder.append(goodsApplyDiscount);
		builder.append(", goodsApplyNetWeight=");
		builder.append(goodsApplyNetWeight);
		builder.append(", goodsApplyNetWeightUnit=");
		builder.append(goodsApplyNetWeightUnit);
		builder.append(", goodsApplyProduce=");
		builder.append(goodsApplyProduce);
		builder.append(", goodsApplyProductionExpirationInfo=");
		builder.append(goodsApplyProductionExpirationInfo);
		builder.append(", goodsApplyMainImage=");
		builder.append(goodsApplyMainImage);
		builder.append(", goodsApplyInfoImage=");
		builder.append(goodsApplyInfoImage);
		builder.append(", goodsApplyRegDatetime=");
		builder.append(goodsApplyRegDatetime);
		builder.append(", goodsApplyStock=");
		builder.append(goodsApplyStock);
		builder.append(", goodsApplyDeliveryCharge=");
		builder.append(goodsApplyDeliveryCharge);
		builder.append(", goodsApplyApproveRefuse=");
		builder.append(goodsApplyApproveRefuse);
		builder.append(", goodsApplyApproveDatetime=");
		builder.append(goodsApplyApproveDatetime);
		builder.append(", goodsApplyRefuseReason=");
		builder.append(goodsApplyRefuseReason);
		builder.append(", enterprise=");
		builder.append(enterprise);
		builder.append(", goodsDiscount=");
		builder.append(goodsDiscount);
		builder.append(", goodsCategory=");
		builder.append(goodsCategory);
		builder.append(", ingredient=");
		builder.append(ingredient);
		builder.append(", goodsMainImageInfo=");
		builder.append(goodsMainImageInfo);
		builder.append(", goodsInfoImageInfo=");
		builder.append(goodsInfoImageInfo);
		builder.append("]");
		return builder.toString();
	}
	
}
