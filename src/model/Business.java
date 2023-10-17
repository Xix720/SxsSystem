
package model;

public class Business {
	private String bno;
	private String bname;
	private String blogin;
	private String bpassword;

	public Business() {

	}

	public Business(String bno, String bname, String blogin, String bpassword) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.blogin = blogin;
		this.bpassword = bpassword;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String sno) {
		this.bno = sno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBlogin() {
		return blogin;
	}

	public void setBlogin(String slogin) {
		this.blogin = slogin;
	}

	public String getBpassword() {
		return bpassword;
	}

	public void setBpassword(String spassword) {
		this.bpassword = spassword;
	}

}

