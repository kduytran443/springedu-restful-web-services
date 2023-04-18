package com.duyb1906443.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.TransactionDTO;
import com.duyb1906443.service.TransactionService;

@RestController
public class TransactionAPI {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/api/transaction")
	@CrossOriginsList
	public ResponseEntity<TransactionDTO> postTransaction(@RequestBody TransactionDTO transactionDTO){
		TransactionDTO dto = transactionService.save(transactionDTO);
		System.out.println("Xong roi "+dto.getCode());
		return ResponseEntity.status(200).body(dto);
	}
	
}
