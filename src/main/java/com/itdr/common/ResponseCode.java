package com.itdr.common;

public class ResponseCode<T> {
    //状态码
    private Integer status;
    private T data;
    private String msg;
    //多个构造函数
    private ResponseCode(T date){
        this.status = 200;
        this.data = date;
    }
    private ResponseCode(Integer status,String msg){
        this.status = status;
        this.msg =msg;
    }
    //成功获取数据的方法
    public static <T> ResponseCode toSuccess(T data){
        return new ResponseCode(data);
    }
    //失败返回信息的方法
    public  static ResponseCode toDefeated(Integer status,String msg){
        return new ResponseCode(status, msg);
    }
    public  static ResponseCode toDefeated(String msg){
        return new ResponseCode(100,msg);
    }

    @Override
    public String toString() {
        return "{" +
                "status:" + status +
                ", data:" + data +
                ", msg:'" + msg + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getDate() {
        return data;
    }

    public void setDate(T date) {
        this.data = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
