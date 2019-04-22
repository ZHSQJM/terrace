package com.terrace.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:46
 * @package: com.terrace.vo
 * @description: 定义的json返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultData {

    public Integer code;

    public String msg;

    public Object data;

    public static ResultData success(String msg,Object obj){
        ResultData rd = new  ResultData();
        rd.setCode(200).setMsg(msg).setData(obj);
        return rd;
    }

    public static ResultData success(String msg){
        ResultData rd = new  ResultData();
        rd.setCode(200).setMsg(msg);
        return rd;
    }

    public static ResultData error(String msg){
        ResultData rd = new  ResultData();
        rd.setCode(500).setMsg(msg);
        return rd;
    }
}
