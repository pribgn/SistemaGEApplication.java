package org.educadventista.Sistema.GE.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String status;

    @OneToMany
    private List<Produto> produtos;

    public void setId(Long id) {
    }
}
