package com.project.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private String ID;
    private String NAME;
    private String ADDRESS;
    private String PURCHASE;
    private Integer COUNT;
    private String TIME;
}
