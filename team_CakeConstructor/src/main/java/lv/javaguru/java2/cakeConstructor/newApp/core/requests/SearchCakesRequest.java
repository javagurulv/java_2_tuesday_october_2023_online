package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class SearchCakesRequest {

	private String cakeName;
	private Double weight;

	public SearchCakesRequest() { }

	public SearchCakesRequest(String cakeName, Double weight) {
		this.cakeName = cakeName;
		this.weight = weight;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public boolean isCakeNameProvided() {
		return this.cakeName != null && !this.cakeName.isEmpty();
	}

	public boolean isWeightProvided() {
		return this.weight != null;
	}


}
