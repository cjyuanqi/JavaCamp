package com.es.camp.trap.serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class Worker extends People implements Serializable {

    private String name;
    private Integer age;

    public Worker(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }


}
