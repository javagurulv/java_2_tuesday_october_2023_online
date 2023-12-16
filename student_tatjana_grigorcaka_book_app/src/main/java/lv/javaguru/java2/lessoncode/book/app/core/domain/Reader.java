package lv.javaguru.java2.lessoncode.book.app.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "readers")
public class Reader {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "personal_code", nullable = false)
	private String personalCode;

	public Reader() {
	}

	public Reader(String firstName, String lastName, String personalCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalCode = personalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Reader reader)) return false;
		return Objects.equals(getId(), reader.getId()) && Objects.equals(getFirstName(), reader.getFirstName()) && Objects.equals(getLastName(), reader.getLastName()) && Objects.equals(getPersonalCode(), reader.getPersonalCode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getPersonalCode());
	}

	@Override
	public String toString() {
		return "Reader{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", personalCode=" + personalCode +
				'}';
	}
}

