package uz.online.springbootpractica.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.online.springbootpractica.model.Transaction;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {


    private final String URI = "http://localhost:8081/payment";

    public String getMsg() {
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.getForObject(URI + "/getMsg", String.class);
        return msg;
    }

    public ResponseEntity<Transaction> save(Transaction transaction) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Transaction> transaction1 = restTemplate.postForEntity(URI + "save", transaction, Transaction.class);
        return transaction1;

    }

    public List<Transaction> findAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List> entity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI + "/getAll", HttpMethod.GET, entity, List.class).getBody();
    }

    public Transaction saveExch(Transaction transaction) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Transaction> entity = new HttpEntity<>(transaction,httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI + "/save", HttpMethod.POST, entity, Transaction.class).getBody();
    }

    public Transaction update(Transaction transaction) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Transaction> entity = new HttpEntity<>(transaction,httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(URI + "/update", HttpMethod.PUT, entity, Transaction.class).getBody();
    }
}
