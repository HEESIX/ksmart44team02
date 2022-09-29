package ks44team02.dto;

public class MenuOrganize {
	private String menuGoodsCode;
	private String menuCode;
	private String goodsOfMenuCode;
	private int menuGoodsAmount;

	public String getMenuGoodsCode() {
		return menuGoodsCode;
	}

	public void setMenuGoodsCode(String menuGoodsCode) {
		this.menuGoodsCode = menuGoodsCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getGoodsOfMenuCode() {
		return goodsOfMenuCode;
	}

	public void setGoodsOfMenuCode(String goodsOfMenuCode) {
		this.goodsOfMenuCode = goodsOfMenuCode;
	}

	public int getMenuGoodsAmount() {
		return menuGoodsAmount;
	}

	public void setMenuGoodsAmount(int menuGoodsAmount) {
		this.menuGoodsAmount = menuGoodsAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuOrganize [menuGoodsCode=");
		builder.append(menuGoodsCode);
		builder.append(", menuCode=");
		builder.append(menuCode);
		builder.append(", goodsOfMenuCode=");
		builder.append(goodsOfMenuCode);
		builder.append(", menuGoodsAmount=");
		builder.append(menuGoodsAmount);
		builder.append("]");
		return builder.toString();
	}

}
