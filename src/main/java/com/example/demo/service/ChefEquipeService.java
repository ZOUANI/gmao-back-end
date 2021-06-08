package com.example.demo.service;


import com.example.demo.bean.ChefEquipe;
import com.example.demo.dao.ChefEquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChefEquipeService  {

    @Autowired
    private ChefEquipeService chefEquipeService;
    @Autowired
    private ChefEquipeDao chefEquipeDao;

    public ChefEquipe findByLogin(String login) {
        return chefEquipeDao.findByLogin(login);
    }

    public ChefEquipe seconnecter(ChefEquipe chefEquipe) {
        ChefEquipe foundedChefEquipe = this.chefEquipeDao.findByLogin(chefEquipe.getLogin());
        if(foundedChefEquipe  == null){
            return null;
        }
        else if (!foundedChefEquipe.getPassword().equals(chefEquipe.getPassword())){
            return null;
        }else{
            return foundedChefEquipe;
        }
    }



    public ChefEquipe findByCode(String code) {
        return chefEquipeDao.findByCode(code);
    }

    public Optional<ChefEquipe> findById(Long id) {
        return chefEquipeDao.findById(id);
    }

    @Transactional
    public int deleteByCode(String code) {
        return chefEquipeDao.deleteByCode(code);
    }

    public List<ChefEquipe> findAll() {
        return chefEquipeDao.findAll();
    }

    public ChefEquipe  save(ChefEquipe chefEquipe) {
        if(findByCode(chefEquipe.getCode())!= null){
            return  null;
        }else{
           chefEquipeDao.save(chefEquipe);
           return chefEquipe;

        }
    }




   public ChefEquipe update(ChefEquipe chefEquipe){
     chefEquipeDao.save(chefEquipe);
     return chefEquipe;
   }


}
