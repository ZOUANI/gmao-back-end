package com.example.demo.service;

import com.example.demo.bean.Admin;
import com.example.demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;


    public Admin findByLogin(String login) {
        return adminDao.findByLogin(login);
    }


    public int save(Admin admin) {
        if (adminDao.findByLogin(admin.getLogin()) != null) {
            return -1;
        }
        else {
            adminDao.save(admin);
            return 1;
        }
    }

    public Admin SeConnecter(Admin admin) {
        Admin foundedAdmin = this.adminDao.findByLogin(admin.getLogin());
        if(foundedAdmin == null){
            return null;
        }
        if (!foundedAdmin.getPassword().equals(admin.getPassword())){
            return null;
        }else{
            return foundedAdmin;
        }
    }

}
