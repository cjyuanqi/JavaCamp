package com.es.camp.trap.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppleComputer extends Computer {

    private Long price;
    private String color;

    public AppleComputer(Integer id, String name, Long price, String color) {
        super(id, name);
        this.price = price;
        this.color = color;
    }
}
