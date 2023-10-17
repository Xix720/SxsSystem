package model;

public class Payrollt {
	private String bno;
	private String tno;
	private String tname;
	private String salsry;
	private String year;
	
	public Payrollt() {
		
	}
	
	public Payrollt(String bno, String tno, String tname, String salsry, String year ) {
		super();
		this.bno = bno;
		this.tno = tno;
		this.tname = tname;
		this.salsry = salsry;
		this.year = year;
	}
	
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
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
	public String getSalsry() {
		return salsry;
	}
	public void setSalsry(String salsry) {
		this.salsry = salsry;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
