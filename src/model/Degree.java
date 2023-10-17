package model;

public class Degree {
	private String ano;
	private String sno;
	private String aname;
	private String rank;
	private String tno;

	public Degree() {
		
	}

	public Degree(String ano, String sno, String aname, String rank, String tno) {
		super();
		this.ano = ano;
		this.sno = sno;
		this.aname = aname;
		this.rank = rank;
		this.tno = tno;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	
}
