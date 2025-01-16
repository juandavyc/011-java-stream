package org.juandavyc.models;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString

public class ProductX implements Serializable, Comparable<ProductX> {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name,promotionCode,material;
    private LocalDate expirationDate;
    private float price;

    @Override
    public int compareTo(ProductX o) {
        return price > o.getPrice() ? 1 : price == o.getPrice() ? name.compareToIgnoreCase(o.getName()) : -1;
    }
}
