package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.vo.DataReturnVo;
import com.tencent.wxcloudrun.service.SelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
public class SelectController {
    @Autowired
    SelectService selectService;

   public void sort(List<DataReturnVo> dataReturnVoList)
   {
       int len=dataReturnVoList.size();
       for(int i=0;i<len;i++)
       {
           for(int j=i+1;j<len;j++)
           {
               if(dataReturnVoList.get(i).getDate().compareTo(dataReturnVoList.get(j).getDate())>0)
               {
                   DataReturnVo temp=new DataReturnVo(dataReturnVoList.get(i));
                   dataReturnVoList.set(i,new DataReturnVo(dataReturnVoList.get(j)));
                   dataReturnVoList.set(j,new DataReturnVo(temp));
               }
           }
       }
   }

    @GetMapping("/select")
    public List<DataReturnVo> selectAll(@RequestParam("pid")String pid)
    {
        if(pid==null)return null;
        List<DataReturnVo> dataReturnVoList=selectService.selectAll(pid);
        sort(dataReturnVoList);
        return dataReturnVoList;
    }
}
