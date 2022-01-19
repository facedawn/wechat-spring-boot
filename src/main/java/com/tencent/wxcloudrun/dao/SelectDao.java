package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.mapper.DataPoMapper;
import com.tencent.wxcloudrun.model.DataPo;
import com.tencent.wxcloudrun.model.DataPoExample;
import com.tencent.wxcloudrun.model.vo.DataReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SelectDao {
    @Autowired
    DataPoMapper dataPoMapper;

    public List<DataReturnVo> selectAllByPid(String pid){
        DataPoExample dataPoExample=new DataPoExample();
        DataPoExample.Criteria criteria=dataPoExample.createCriteria();
        criteria.andPidEqualTo(pid);
        try {
            List<DataPo> dataPoList = dataPoMapper.selectByExample(dataPoExample);
            List<DataReturnVo>dataReturnVoList=new ArrayList<>();
            int len=dataPoList.size();
            for(int i=0;i<len;i++)
            {
                DataReturnVo temp=new DataReturnVo(i, (String) dataPoList.get(i).getName(),(String) dataPoList.get(i).getType(),(String) dataPoList.get(i).getActualamount(),(String)dataPoList.get(i).getIssuedate());
                dataReturnVoList.add(temp);
            }
            return dataReturnVoList;
        }
        catch(Exception e)
        {
            List<DataReturnVo>dataReturnVoList=new ArrayList<>();
            DataReturnVo temp=new DataReturnVo(-1,"","","","");
            return dataReturnVoList;
        }
    }
}
