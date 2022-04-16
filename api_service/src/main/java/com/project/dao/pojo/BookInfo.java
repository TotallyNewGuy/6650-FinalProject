package com.project.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo implements Serializable {
    private Long ID;
    private String NAME;
    private Double PRICE;
}
