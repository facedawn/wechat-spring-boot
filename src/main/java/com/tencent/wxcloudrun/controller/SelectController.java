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

    @GetMapping("/select")
    public List<DataReturnVo> selectAll(@RequestParam("pid")int pid)
    {
        if(pid==0)return null;
        return selectService.selectAll(pid);
    }
}
