package com.tencent.wxcloudrun.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataReturnVo {
    int num;
    String account;
    String name;
    String type;
    String rmb;
    String date;


    public DataReturnVo(DataReturnVo dataReturnVo) {
        this.account=dataReturnVo.getAccount();
        this.num=dataReturnVo.getNum();
        this.name=dataReturnVo.getName();
        this.type=dataReturnVo.getType();
        this.rmb=dataReturnVo.getRmb();
        this.date=dataReturnVo.getDate();
    }
}
