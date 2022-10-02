package ks44team02.dto;

public class Launching {
	private String sellerCode;
	private String sellerId;
	private String sellerBrand;
	private String sellerEnter;
	private String sellerNum;
	private String sellerManager;
	private String sellerPhone;
	private String sellerAdd;
	private String sellerContent;
	private String sellerHwp;
	private String sellerUrl;
	private String sellerFile;
	private String sellerDate;
	private String sellerApp;
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerBrand() {
		return sellerBrand;
	}
	public void setSellerBrand(String sellerBrand) {
		this.sellerBrand = sellerBrand;
	}
	public String getSellerEnter() {
		return sellerEnter;
	}
	public void setSellerEnter(String sellerEnter) {
		this.sellerEnter = sellerEnter;
	}
	public String getSellerNum() {
		return sellerNum;
	}
	public void setSellerNum(String sellerNum) {
		this.sellerNum = sellerNum;
	}
	public String getSellerManager() {
		return sellerManager;
	}
	public void setSellerManager(String sellerManager) {
		this.sellerManager = sellerManager;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerAdd() {
		return sellerAdd;
	}
	public void setSellerAdd(String sellerAdd) {
		this.sellerAdd = sellerAdd;
	}
	public String getSellerContent() {
		return sellerContent;
	}
	public void setSellerContent(String sellerContent) {
		this.sellerContent = sellerContent;
	}
	public String getSellerHwp() {
		return sellerHwp;
	}
	public void setSellerHwp(String sellerHwp) {
		this.sellerHwp = sellerHwp;
	}
	public String getSellerUrl() {
		return sellerUrl;
	}
	public void setSellerUrl(String sellerUrl) {
		this.sellerUrl = sellerUrl;
	}
	public String getSellerFile() {
		return sellerFile;
	}
	public void setSellerFile(String sellerFile) {
		this.sellerFile = sellerFile;
	}
	public String getSellerDate() {
		return sellerDate;
	}
	public void setSellerDate(String sellerDate) {
		this.sellerDate = sellerDate;
	}
	public String getSellerApp() {
		return sellerApp;
	}
	public void setSellerApp(String sellerApp) {
		this.sellerApp = sellerApp;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellerCompanyAdd [sellerCode=");
		builder.append(sellerCode);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", sellerBrand=");
		builder.append(sellerBrand);
		builder.append(", sellerEnter=");
		builder.append(sellerEnter);
		builder.append(", sellerNum=");
		builder.append(sellerNum);
		builder.append(", sellerManager=");
		builder.append(sellerManager);
		builder.append(", sellerPhone=");
		builder.append(sellerPhone);
		builder.append(", sellerAdd=");
		builder.append(sellerAdd);
		builder.append(", sellerContent=");
		builder.append(sellerContent);
		builder.append(", sellerHwp=");
		builder.append(sellerHwp);
		builder.append(", sellerUrl=");
		builder.append(sellerUrl);
		builder.append(", sellerFile=");
		builder.append(sellerFile);
		builder.append(", sellerDate=");
		builder.append(sellerDate);
		builder.append(", sellerApp=");
		builder.append(sellerApp);
		builder.append("]");
		return builder.toString();
	}
}
