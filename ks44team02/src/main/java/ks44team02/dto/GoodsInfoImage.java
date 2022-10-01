package ks44team02.dto;

public class GoodsInfoImage {
	private String infoImageIdx;
	private String infoImageOriginalName;
	private String infoImageNewName;
	private String infoImagePath;
	private int infoImageSize;
	private int infoImageIsLocal;
	public String getInfoImageIdx() {
		return infoImageIdx;
	}
	public void setInfoImageIdx(String infoImageIdx) {
		this.infoImageIdx = infoImageIdx;
	}
	public String getInfoImageOriginalName() {
		return infoImageOriginalName;
	}
	public void setInfoImageOriginalName(String infoImageOriginalName) {
		this.infoImageOriginalName = infoImageOriginalName;
	}
	public String getInfoImageNewName() {
		return infoImageNewName;
	}
	public void setInfoImageNewName(String infoImageNewName) {
		this.infoImageNewName = infoImageNewName;
	}
	public String getInfoImagePath() {
		return infoImagePath;
	}
	public void setInfoImagePath(String infoImagePath) {
		this.infoImagePath = infoImagePath;
	}
	public int getInfoImageSize() {
		return infoImageSize;
	}
	public void setInfoImageSize(int infoImageSize) {
		this.infoImageSize = infoImageSize;
	}
	public int getInfoImageIsLocal() {
		return infoImageIsLocal;
	}
	public void setInfoImageIsLocal(int infoImageIsLocal) {
		this.infoImageIsLocal = infoImageIsLocal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoImage [infoImageIdx=");
		builder.append(infoImageIdx);
		builder.append(", infoImageOriginalName=");
		builder.append(infoImageOriginalName);
		builder.append(", infoImageNewName=");
		builder.append(infoImageNewName);
		builder.append(", infoImagePath=");
		builder.append(infoImagePath);
		builder.append(", infoImageSize=");
		builder.append(infoImageSize);
		builder.append(", infoImageIsLocal=");
		builder.append(infoImageIsLocal);
		builder.append("]");
		return builder.toString();
	}
	
}
