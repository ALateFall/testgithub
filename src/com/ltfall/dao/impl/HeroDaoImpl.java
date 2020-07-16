package com.ltfall.dao.impl;

import com.ltfall.dao.HeroDao;
import com.ltfall.domain.Hero;
//import com.ltfall.domain.vo.HeroWeapon;
import com.ltfall.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class HeroDaoImpl implements HeroDao {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource())  ;

    @Override
    public List<Hero> findAll()  throws Exception{
        String sql = "select * from hero";
        List<Hero> list = qr.query(sql,new BeanListHandler<Hero>(Hero.class));
        return list;
    }

    @Override
    public Hero findById(int id)  throws Exception{
        String sql = "select * from hero where id = " + id;
        Hero hero = qr.query(sql,new BeanHandler<Hero>(Hero.class));
        return hero;
    }

    @Override
    public int insert(Hero hero)  throws Exception{
        String sql = "insert into hero(id,name,hp,damage) values (?,?,?,?)";
        return qr.update(sql,hero.getId(),hero.getName(),hero.getHp(),hero.getDamage());
    }

    @Override
    public int update(Hero hero) throws Exception {
        String sql = "update hero set name = ?, damage = ?, hp = ? where id = ?";
        return qr.update(sql,hero.getName(),hero.getDamage(),hero.getHp(),hero.getId());
    }

    @Override
    public int delete(int id)  throws Exception{
        String sql = "delete from hero where id = ?";
        return qr.update(sql,id);
    }

    public void test(){
        System.out.println("yes!!");
    }

//    @Override
//    public List<HeroWeapon> findNameAndWeapon() throws Exception {
//        String sql = "SELECT name,wname FROM hero,weapon \n" +
//                "WHERE hero.id=weapon.hid \n" +
//                "AND hero.name='提莫'";
//        List<HeroWeapon>list = qr.query(sql,new BeanListHandler<HeroWeapon>(HeroWeapon.class));
//        return list;
//    }

    public static void main(String[] args) throws Exception {
        HeroDaoImpl hdi = new HeroDaoImpl();

        /*
        实现对Hero表的增删改查
         */

//        // 增
//        Hero h = new Hero(11,"卡莎",400,100);
//        hdi.insert(h);
//        System.out.println(hdi.findById(3));
//        System.out.println(hdi.findById(11));
//
//        //删
//        hdi.delete(3);
//        System.out.println(hdi.findAll());
//
//        //改
//        System.out.println(hdi.update(new Hero(2,"安妮",600,300)));
//
//        //查 上面好多个了
//
//        //vo对象多表联查
//        System.out.println(hdi.findNameAndWeapon());
        System.out.println("hello");
        System.out.println(hdi.findAll());
    }
}
