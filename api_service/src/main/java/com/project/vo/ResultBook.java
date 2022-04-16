package com.project.vo;

import com.project.dao.pojo.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBook implements Serializable {
    // unify Json data format
    private boolean success;

    private int code;

    private String msg;

    private BookInfo data;

    // process success
    public static ResultBook success(BookInfo data) {
        ResultBook res = new ResultBook();
        res.setSuccess(true);
        res.setCode(200);
        res.setMsg("success");
        res.setData(data);
        return res;
    }

    // process fail
    public static ResultBook fail(int code, String msg) {
        ResultBook res = new ResultBook();
        res.setSuccess(false);
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
}
