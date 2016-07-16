package com.example.hanshu.pull;

/**
 * Created by HanShu on 2016/7/15.
 */
public class XmlBean {
    Long data;
    int type;
    String body;
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "内容如下" + '\n' +
                "发件人的电话'" + address + '\n' +
                "时间" + data +'\n' +
                "类型(1 代表接收，2 代表发送)" + type +'\n' +
                "短信内容" + '\n'+ body + '\n'
                ;
    }
}
