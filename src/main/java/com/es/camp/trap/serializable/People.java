package com.es.camp.trap.serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class People /*implements Serializable */{

    private Long id;

//    public People() {
//    }

    public People(Long id) {
        this.id = id;
    }
}
