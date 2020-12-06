package org.polytech.vermeg.mapping;

import java.sql.Date;
import java.util.List;

public class Bill {
	
	private Long idCommande;
	private int num;
	private Date dateCmd;
	
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	
	
	public Bill(Long idCommande, int num, Date dateCmd, List<LineBill> lineBill) {
		super();
		this.idCommande = idCommande;
		this.num = num;
		this.dateCmd = dateCmd;
		this.lineBill = lineBill;
	}
	public Bill() {
		
	}

     private List<LineBill> lineBill;

	public List<LineBill> getLineBill() {
		return lineBill;
	}
	public void setLineBill(List<LineBill> lineBill) {
		this.lineBill = lineBill;
	}
	
	
	
}

