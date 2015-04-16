package javabean;

public class Patient {
	private int userid;
	private String fullname;   
    private int age;
    private String sex;
    private String birthdate;
    private String mobile;
	public Patient(int userid, String fullname, int age, String sex,
			String birthdate, String mobile) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.fullname = fullname;
		this.age = age;
		this.sex = sex;
		this.birthdate = birthdate;
		this.mobile = mobile;
	}
	public int getUserid() {
		return userid;
	}
	
	public String getFullname() {
		return fullname;
	}

	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getMobile() {
		return mobile;
	}
	
}
