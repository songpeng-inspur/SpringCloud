package com.gettop.webfinal.demo.service;


import com.gettop.webfinal.demo.dao.TestDao;
import com.gettop.webfinal.demo.modal.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
1.接收Controller层数据
2.与DAO层交互，处理业务逻辑
3.生成responseDTO数据并返回Controller层
*/

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public Test getById(int id){
        return testDao.selectByPrimaryKey(id);
    }

}
