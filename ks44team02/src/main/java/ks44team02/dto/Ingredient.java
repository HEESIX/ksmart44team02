package ks44team02.dto;

public class Ingredient {
	private String ingredientCode;
	private String goodsCode;
	private int ingredientKCal;
	private double ingredientProtein;
	private double ingredientCarb;
	private double ingredientSugar;
	private double ingredientSodium;
	private double ingredientCholesterol;
	public String getIngredientCode() {
		return ingredientCode;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public int getIngredientKCal() {
		return ingredientKCal;
	}
	public void setIngredientKCal(int ingredientKCal) {
		this.ingredientKCal = ingredientKCal;
	}
	public double getIngredientProtein() {
		return ingredientProtein;
	}
	public void setIngredientProtein(double ingredientProtein) {
		this.ingredientProtein = ingredientProtein;
	}
	public double getIngredientCarb() {
		return ingredientCarb;
	}
	public void setIngredientCarb(double ingredientCarb) {
		this.ingredientCarb = ingredientCarb;
	}
	public double getIngredientSugar() {
		return ingredientSugar;
	}
	public void setIngredientSugar(double ingredientSugar) {
		this.ingredientSugar = ingredientSugar;
	}
	public double getIngredientSodium() {
		return ingredientSodium;
	}
	public void setIngredientSodium(double ingredientSodium) {
		this.ingredientSodium = ingredientSodium;
	}
	public double getIngredientCholesterol() {
		return ingredientCholesterol;
	}
	public void setIngredientCholesterol(double ingredientCholesterol) {
		this.ingredientCholesterol = ingredientCholesterol;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [ingredientCode=");
		builder.append(ingredientCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", ingredientKCal=");
		builder.append(ingredientKCal);
		builder.append(", ingredientProtein=");
		builder.append(ingredientProtein);
		builder.append(", ingredientCarb=");
		builder.append(ingredientCarb);
		builder.append(", ingredientSugar=");
		builder.append(ingredientSugar);
		builder.append(", ingredientSodium=");
		builder.append(ingredientSodium);
		builder.append(", ingredientCholesterol=");
		builder.append(ingredientCholesterol);
		builder.append("]");
		return builder.toString();
	}

}
