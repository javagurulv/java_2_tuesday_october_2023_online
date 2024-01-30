package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class SearchClientsAndCakesRequest {

	private String firstName;
	private String lastName;
	private String cakeName;
	private Double weight;

	public SearchClientsAndCakesRequest() {
	}

	public SearchClientsAndCakesRequest(String firstName,
										String lastName,
										String cakeName,
										Double weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cakeName = cakeName;
		this.weight = weight;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
}
