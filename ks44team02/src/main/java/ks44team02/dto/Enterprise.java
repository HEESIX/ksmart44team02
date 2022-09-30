package ks44team02.dto;

public class Enterprise {
	private String enterCode;
	private String enterId;
	private String enterBrand;
	private String enterName;
	private String enterAdd;
	private String enterNum;
	private String enterDate;
	private String enterBusinessNum;
	private String enterLevelCode;
	private String enterProducts;
	private String enterWithdraw;
	public String getEnterCode() {
		return enterCode;
	}
	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
	}
	public String getEnterId() {
		return enterId;
	}
	public void setEnterId(String enterId) {
		this.enterId = enterId;
	}
	public String getEnterBrand() {
		return enterBrand;
	}
	public void setEnterBrand(String enterBrand) {
		this.enterBrand = enterBrand;
	}
	public String getEnterName() {
		return enterName;
	}
	public void setEnterName(String enterName) {
		this.enterName = enterName;
	}
	public String getEnterAdd() {
		return enterAdd;
	}
	public void setEnterAdd(String enterAdd) {
		this.enterAdd = enterAdd;
	}
	public String getEnterNum() {
		return enterNum;
	}
	public void setEnterNum(String enterNum) {
		this.enterNum = enterNum;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getEnterBusinessNum() {
		return enterBusinessNum;
	}
	public void setEnterBusinessNum(String enterBusinessNum) {
		this.enterBusinessNum = enterBusinessNum;
	}
	public String getEnterLevelCode() {
		return enterLevelCode;
	}
	public void setEnterLevelCode(String enterLevelCode) {
		this.enterLevelCode = enterLevelCode;
	}
	public String getEnterProducts() {
		return enterProducts;
	}
	public void setEnterProducts(String enterProducts) {
		this.enterProducts = enterProducts;
	}
	public String getEnterWithdraw() {
		return enterWithdraw;
	}
	public void setEnterWithdraw(String enterWithdraw) {
		this.enterWithdraw = enterWithdraw;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enterprise [enterCode=");
		builder.append(enterCode);
		builder.append(", enterId=");
		builder.append(enterId);
		builder.append(", enterBrand=");
		builder.append(enterBrand);
		builder.append(", enterName=");
		builder.append(enterName);
		builder.append(", enterAdd=");
		builder.append(enterAdd);
		builder.append(", enterNum=");
		builder.append(enterNum);
		builder.append(", enterDate=");
		builder.append(enterDate);
		builder.append(", enterBusinessNum=");
		builder.append(enterBusinessNum);
		builder.append(", enterLevelCode=");
		builder.append(enterLevelCode);
		builder.append(", enterProducts=");
		builder.append(enterProducts);
		builder.append(", enterWithdraw=");
		builder.append(enterWithdraw);
		builder.append("]");
		return builder.toString();
	}
}
