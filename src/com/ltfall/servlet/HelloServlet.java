package com.ltfall.servlet;

import com.alibaba.fastjson.JSON;
import com.ltfall.dao.HeroDao;
import com.ltfall.dao.impl.HeroDaoImpl;
import com.ltfall.domain.Hero;
import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/abc")
public class HelloServlet extends HttpServlet {

    private HeroDaoImpl heroDao = new HeroDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        try {
            List<Hero>list = heroDao.findAll();
            String jsonstr = JSON.toJSONString(list);
            PrintWriter out = response.getWriter();
            out.print(jsonstr);
            out.flush();
            out.close();
//            heroDao.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
