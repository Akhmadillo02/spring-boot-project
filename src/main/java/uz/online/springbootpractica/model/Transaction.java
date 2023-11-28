package uz.online.springbootpractica.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {

    private Long id;
    private String reasons;

    private Long userId;

    private Double amount;
}
