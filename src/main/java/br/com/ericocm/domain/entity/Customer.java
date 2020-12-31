package br.com.ericocm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Customer extends PanacheEntity {
    private String name;

    @CPF
    private String cpf;

    public Customer(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
}
