package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.*;

import org.example.Model;
import org.example.ModelDao;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ModelDao modelDao = ac.getBean(ModelDao.class);

        Model model = new Model();
        model.setModelName("tmp1");

        int count = modelDao.insert(model);
        System.out.println("Inserted num : " + count);

        List<Model> list = modelDao.selectAll();
        System.out.println("모델 이름 목록");
        for(Model model1:list){
            System.out.println(model1.getModelName());
        }

        Model model2 = modelDao.selectByModelName("tmp1");
        System.out.println(model2);

        int deleteCount = modelDao.deleteByModelName("tmp1");
        System.out.println("Deleted num : " + deleteCount);

    }
}
