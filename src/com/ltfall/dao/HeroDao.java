package com.ltfall.dao;

import com.ltfall.domain.Hero;

import java.util.List;

public interface HeroDao {

    public List<Hero> findAll() throws Exception;

    public Hero findById(int id) throws Exception;

    public int insert(Hero hero) throws Exception;

    public int update(Hero hero) throws Exception;

    public int delete(int id) throws Exception;

//    public List<HeroWeapon> findNameAndWeapon() throws Exception;
}
