package uz.online.springbootpractica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.springbootpractica.model.Transaction;
import uz.online.springbootpractica.service.TransactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/getAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity save(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.saveExch(transaction));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.update(transaction));
    }

}
