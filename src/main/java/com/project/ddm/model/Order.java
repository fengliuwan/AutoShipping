package com.project.ddm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

//    @OneToOne
//    private Device device;
}
