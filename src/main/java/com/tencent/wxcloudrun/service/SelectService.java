package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dao.SelectDao;
import com.tencent.wxcloudrun.model.vo.DataReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {
    @Autowired
    SelectDao selectDao;

    public List<DataReturnVo> selectAll(String pid)
    {
        return selectDao.selectAllByPid(pid);
    }
}
