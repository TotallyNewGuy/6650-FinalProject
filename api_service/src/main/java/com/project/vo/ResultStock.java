package com.project.vo;

import com.project.dao.pojo.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultStock implements Serializable {
    // unify Json data format
    private boolean success;

    private int code;

    private String msg;

    private Integer data;

    // process success
    public static ResultStock success(Integer data) {
        ResultStock res = new ResultStock();
        res.setSuccess(true);
        res.setCode(200);
        res.setMsg("success");
        res.setData(data);
        return res;
    }

    // process fail
    public static ResultStock fail(int code, String msg) {
        ResultStock res = new ResultStock();
        res.setSuccess(false);
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
}
