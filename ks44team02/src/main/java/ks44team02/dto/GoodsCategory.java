package ks44team02.dto;

//상품 카테고리 객체
public class GoodsCategory {
	private String goodsCategoryCode;
	private String goodsCategoryName;
	private String goodsCategoryRegDate;
	private String goodsCategoryRegId;
	private char goodsCategoryStatus;

	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}

	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}

	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getGoodsCategoryRegDate() {
		return goodsCategoryRegDate;
	}

	public void setGoodsCategoryRegDate(String goodsCategoryRegDate) {
		this.goodsCategoryRegDate = goodsCategoryRegDate;
	}

	public String getGoodsCategoryRegId() {
		return goodsCategoryRegId;
	}

	public void setGoodsCategoryRegId(String goodsCategoryRegId) {
		this.goodsCategoryRegId = goodsCategoryRegId;
	}

	public char getGoodsCategoryStatus() {
		return goodsCategoryStatus;
	}

	public void setGoodsCategoryStatus(char goodsCategoryStatus) {
		this.goodsCategoryStatus = goodsCategoryStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsCategory [goodsCategoryCode=");
		builder.append(goodsCategoryCode);
		builder.append(", goodsCategoryName=");
		builder.append(goodsCategoryName);
		builder.append(", goodsCategoryRegDate=");
		builder.append(goodsCategoryRegDate);
		builder.append(", goodsCategoryRegId=");
		builder.append(goodsCategoryRegId);
		builder.append(", goodsCategoryStatus=");
		builder.append(goodsCategoryStatus);
		builder.append("]");
		return builder.toString();
	}

}
