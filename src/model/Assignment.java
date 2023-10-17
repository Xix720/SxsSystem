package model;

public class Assignment {
	private String ano;
	private String aname;
	private String sno;
	private String tno;
	
	public Assignment() {
		
	}

	public Assignment(String ano, String aname, String sno, String tno) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.sno = sno;
		this.tno = tno;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	
}
