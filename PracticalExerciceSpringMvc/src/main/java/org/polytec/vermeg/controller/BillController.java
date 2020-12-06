package org.polytec.vermeg.controller;

import java.util.List;




import org.polytec.vermeg.service.BillService;
import org.polytech.vermeg.mapping.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	BillService billService;
	
	
	@RequestMapping(value = "/gettotalPrice", method = RequestMethod.POST, produces = "application/json")
	
		public double getSommeTotal(@RequestBody Bill bill) {
			return billService.getSommeTotal(bill);
	}
	
	}