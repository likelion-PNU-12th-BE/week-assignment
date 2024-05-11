package study.likelionbeweekly.week2.beanexample;

public class Address {
	private String street;
	private int number;

	public Address(String street, int number) {
		this.street = street;
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}
}