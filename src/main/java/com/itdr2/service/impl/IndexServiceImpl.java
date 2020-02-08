package com.itdr2.service.impl;

import com.itdr2.dao.IndexDao;
import com.itdr2.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
//import org.springframework.transaction.support.TransactionTemplate;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
   @Autowired
    private IndexDao indexDao;
   @Autowired
    private TransactionTemplate tt;

    public IndexDao getIndexDao() {
        return indexDao;
    }

    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    @Override
    public String tm(String aname, String bname, double money) {
        //判断bname账户是否存在，转账金额大于0
        //给A账户扣钱
       int a = indexDao.updateByName(aname,money);
       int c = 1/0;
        //给B账户加钱
        int b = indexDao.updateByName2(bname,money);
        if(a==0 || b == 0){
            return "转账失败!";
        }
        return "转账成功！";
    }

}
