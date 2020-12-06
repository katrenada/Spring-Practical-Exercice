package org.polytec.vermeg.service;

import java.util.List;


import org.polytec.vermeg.dao.BookDAO;
import org.polytech.vermeg.mapping.Bill;
import org.polytech.vermeg.mapping.LineBill;

import org.polytec.vermeg.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BillService")
public class BillService {

	@Autowired
	BookDAO bookDAO;
	
	
	
	@Transactional
	public double getSommeTotal(Bill bill) {
    double somme=0;
    
    if (bill.getLineBill()!=null && bill.getLineBill().size()>0) {
    	
    	for (LineBill ligne : bill.getLineBill()) {
    		
    		double prix=bookDAO.getBook(ligne.getIdbook()).getPrice();
    		
    		somme+=(prix*ligne.getQuantite());
    		
    		
    		
    	}
    	
    	
    	
    }

     
    
    return somme ;
	}
	
}
