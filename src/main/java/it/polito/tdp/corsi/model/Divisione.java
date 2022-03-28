package it.polito.tdp.corsi.model;

public class Divisione  implements Comparable <Divisione>{
	private String cds; 
	private Integer n;
	
	public Divisione(String cds, Integer n) {
		super();
		this.cds = cds;
		this.n = n;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	@Override
	public int compareTo(Divisione o) {
		return -o.getCds().compareTo(this.cds);
	}
	
	
}
