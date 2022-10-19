package ks44team02.dto;

import java.util.List;

//식단 객체
public class MenuInformation {
	
	private String menuCode;
	private String goodsCode;
	private String menuName;
	private String menuRegDatetime;
	private String menuRegId;
	private int menuPrice;
	
	private List<MenuOrganize> menuOrganizeList;
	private Ingredient ingredient;
	
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public List<MenuOrganize> getMenuOrganizeList() {
		return menuOrganizeList;
	}
	public void setMenuOrganizeList(List<MenuOrganize> menuOrganizeList) {
		this.menuOrganizeList = menuOrganizeList;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuRegDatetime() {
		return menuRegDatetime;
	}
	public void setMenuRegDatetime(String menuRegDatetime) {
		this.menuRegDatetime = menuRegDatetime;
	}
	public String getMenuRegId() {
		return menuRegId;
	}
	public void setMenuRegId(String menuRegId) {
		this.menuRegId = menuRegId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuInformation [menuCode=");
		builder.append(menuCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuRegDatetime=");
		builder.append(menuRegDatetime);
		builder.append(", menuRegId=");
		builder.append(menuRegId);
		builder.append(", menuPrice=");
		builder.append(menuPrice);
		builder.append(", menuOrganizeList=");
		builder.append(menuOrganizeList);
		builder.append(", ingredient=");
		builder.append(ingredient);
		builder.append("]");
		return builder.toString();
	}
	
	

}
