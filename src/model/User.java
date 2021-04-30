package model;

public class User {
	private String fullName;
	private int birthYear;
	private String username;
	private String password;
	private int role;

	public User(String fullName, int birthYear, String username, String password, int role) {
		this.fullName = fullName;
		this.birthYear = birthYear;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
