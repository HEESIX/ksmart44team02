package ks44team02.dto;

public class Mileage {

	private String memberId;
	private int usedMileage;
	private int earnedMileage;
	private int currentMileage;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getUsedMileage() {
		return usedMileage;
	}
	public void setUsedMileage(int usedMileage) {
		this.usedMileage = usedMileage;
	}
	public int getEarnedMileage() {
		return earnedMileage;
	}
	public void setEarnedMileage(int earnedMileage) {
		this.earnedMileage = earnedMileage;
	}
	public int getCurrentMileage() {
		return currentMileage;
	}
	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mileage [memberId=");
		builder.append(memberId);
		builder.append(", usedMileage=");
		builder.append(usedMileage);
		builder.append(", earnedMileage=");
		builder.append(earnedMileage);
		builder.append(", currentMileage=");
		builder.append(currentMileage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
