package ks44team02.dto;
//식단 객체
public class Menus {
	
	private String menuCode;
	private String goodsCode;
	private String menuName;
	private String menuRegDatetime;
	private String menuRegId;
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
		builder.append("Menus [menuCode=");
		builder.append(menuCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", menuRegDatetime=");
		builder.append(menuRegDatetime);
		builder.append(", menuRegId=");
		builder.append(menuRegId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
