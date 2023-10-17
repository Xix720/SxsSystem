package model;

public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private String sage;
	private String slogin;
	private String spassword;
	
	public Student() {
		
	}
	
	public Student(String sno, String sname, String ssex, String sage, String slogin, String spassword) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.slogin = slogin;
		this.spassword = spassword;
	}


	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSage() {
		return sage;
	}

	public void setSage(String sage) {
		this.sage = sage;
	}

	public String getSlogin() {
		return slogin;
	}

	public void setSlogin(String slogin) {
		this.slogin = slogin;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

}
	
	


