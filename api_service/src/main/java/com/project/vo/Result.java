package com.project.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    // unify Json data format
    private boolean success;

    private int code;

    private String msg;

    private Object data;

    // process success
    public static Result success(Object data) {
        Result res = new Result();
        res.setSuccess(true);
        res.setCode(200);
        res.setMsg("success");
        res.setData(data);
        return res;
    }

    // process fail
    public static Result fail(int code, String msg) {
        Result res = new Result();
        res.setSuccess(false);
        res.setCode(code);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
}
