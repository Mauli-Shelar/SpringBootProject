package requestModel;

import lombok.NonNull;

public class UserRequestModel {

	private String password;

	private String username;

	private String mobile;

	private String email;

	@Override
	public String toString() {
		return "UserRequestModel [password=" + password + ", username=" + username + ", mobile=" + mobile + ", email="
				+ email + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRequestModel(@NonNull String password, @NonNull String username, @NonNull String mobile,
			@NonNull String email) {
		super();
		this.password = password;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
	}

	public UserRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
