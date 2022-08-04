package com.project.ddm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deviceId;

}