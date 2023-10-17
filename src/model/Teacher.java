package model;

public class Teacher {
	private String tno;
	private String tname;
	private String tsex;
	private String tage;
	private String tlogin;
	private String tpassword;
	
	public Teacher(){
		
	}
	
	public Teacher(String tno, String tname, String tsex, String tage, String tlogin, String tpassword) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tlogin = tlogin;
		this.tpassword = tpassword;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getTage() {
		return tage;
	}

	public void setTage(String tage) {
		this.tage = tage;
	}

	public String getTlogin() {
		return tlogin;
	}

	public void setTlogin(String tlogin) {
		this.tlogin = tlogin;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	
}
