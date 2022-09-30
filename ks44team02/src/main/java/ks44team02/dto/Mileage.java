package ks44team02.dto;

public class Mileage {

	private String mMileageCode;
	private String memberId;
	private String orderDetailCode;
	private int currentMileage;
	private String mileageDistinct;
	private int addedUsedMileage;
	private int mileageSubtotal;
	private String mUpdateDatetime;
	private String orderGroupCode;
	public String getmMileageCode() {
		return mMileageCode;
	}
	public void setmMileageCode(String mMileageCode) {
		this.mMileageCode = mMileageCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public int getCurrentMileage() {
		return currentMileage;
	}
	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}
	public String getMileageDistinct() {
		return mileageDistinct;
	}
	public void setMileageDistinct(String mileageDistinct) {
		this.mileageDistinct = mileageDistinct;
	}
	public int getAddedUsedMileage() {
		return addedUsedMileage;
	}
	public void setAddedUsedMileage(int addedUsedMileage) {
		this.addedUsedMileage = addedUsedMileage;
	}
	public int getMileageSubtotal() {
		return mileageSubtotal;
	}
	public void setMileageSubtotal(int mileageSubtotal) {
		this.mileageSubtotal = mileageSubtotal;
	}
	public String getmUpdateDatetime() {
		return mUpdateDatetime;
	}
	public void setmUpdateDatetime(String mUpdateDatetime) {
		this.mUpdateDatetime = mUpdateDatetime;
	}
	public String getOrderGroupCode() {
		return orderGroupCode;
	}
	public void setOrderGroupCode(String orderGroupCode) {
		this.orderGroupCode = orderGroupCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mileage [mMileageCode=");
		builder.append(mMileageCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", orderDetailCode=");
		builder.append(orderDetailCode);
		builder.append(", currentMileage=");
		builder.append(currentMileage);
		builder.append(", mileageDistinct=");
		builder.append(mileageDistinct);
		builder.append(", addedUsedMileage=");
		builder.append(addedUsedMileage);
		builder.append(", mileageSubtotal=");
		builder.append(mileageSubtotal);
		builder.append(", mUpdateDatetime=");
		builder.append(mUpdateDatetime);
		builder.append(", orderGroupCode=");
		builder.append(orderGroupCode);
		builder.append("]");
		return builder.toString();
	}
	
}