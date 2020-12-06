package org.polytech.vermeg.mapping;

public class LineBill {

	private int quantite ;

	 private long idbook;

	 private Bill bill;

	

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public long getIdbook() {
		return idbook;
	}

	public void setIdbook(long idbook) {
		this.idbook = idbook;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public LineBill(int quantite, long idbook) {
		super();
		this.quantite = quantite;
		this.idbook = idbook;
		
	}

	public LineBill() {
		
	}


		
	

}
