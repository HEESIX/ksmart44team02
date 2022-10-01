package ks44team02.dto;

public class GoodsMainImage {
	
	private String mainImageIdx;
	private String mainImageOriginalName;
	private String mainImageNewName;
	private String mainImagePath;
	private int mainImageSize;
	private int mainImageIsLocal;
	public String getMainImageIdx() {
		return mainImageIdx;
	}
	public void setMainImageIdx(String mainImageIdx) {
		this.mainImageIdx = mainImageIdx;
	}
	public String getMainImageOriginalName() {
		return mainImageOriginalName;
	}
	public void setMainImageOriginalName(String mainImageOriginalName) {
		this.mainImageOriginalName = mainImageOriginalName;
	}
	public String getMainImageNewName() {
		return mainImageNewName;
	}
	public void setMainImageNewName(String mainImageNewName) {
		this.mainImageNewName = mainImageNewName;
	}
	public String getMainImagePath() {
		return mainImagePath;
	}
	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
	}
	public int getMainImageSize() {
		return mainImageSize;
	}
	public void setMainImageSize(int mainImageSize) {
		this.mainImageSize = mainImageSize;
	}
	public int getMainImageIsLocal() {
		return mainImageIsLocal;
	}
	public void setMainImageIsLocal(int mainImageIsLocal) {
		this.mainImageIsLocal = mainImageIsLocal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MainImage [mainImageIdx=");
		builder.append(mainImageIdx);
		builder.append(", mainImageOriginalName=");
		builder.append(mainImageOriginalName);
		builder.append(", mainImageNewName=");
		builder.append(mainImageNewName);
		builder.append(", mainImagePath=");
		builder.append(mainImagePath);
		builder.append(", mainImageSize=");
		builder.append(mainImageSize);
		builder.append(", mainImageIsLocal=");
		builder.append(mainImageIsLocal);
		builder.append("]");
		return builder.toString();
	}
	
}
