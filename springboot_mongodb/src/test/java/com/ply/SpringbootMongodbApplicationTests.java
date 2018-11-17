package com.ply;

import com.ply.dao.SpitDao;
import com.ply.pojo.Spit;
import com.ply.pojo.Student;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void jpaFind(){
        List<Spit> list = spitDao.findAll();
        for (Spit spit : list) {
            System.out.println(spit);
        }
    }

    @Test
    public void mongoTemplateFind(){
        Query query = new Query();
        List<JSONObject> list = mongoTemplate.find(query, JSONObject.class, "spit");
        for (JSONObject spit : list) {
            System.out.println(spit);
        }
    }

    @Test
    public void save(){
        Spit spit = new Spit();
        spit.set_id("8");
        spit.setComment(8888);
        spit.setContent("我要上春晚");
        spit.setNickname("郭德纲");
        spit.setUserid("3333");
        spitDao.save(spit);
    }

    @Test
    public void update1(){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("5"));
        Update update = Update.update("nickname","小猪佩奇");
        //可以看出步骤是先查询，后修改，没有查询出来的话就插入新记录
        mongoTemplate.upsert(query,update,"spit");
    }

    @Test
    public void update2(){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("1"));
        Student student = new Student("zhangsan",18,"male",1);
        Update update = new Update();
        update.addToSet("studentss",student);
        //可以看出步骤是先查询，后修改，没有查询出来的话就插入新记录
        mongoTemplate.upsert(query,update,"spit");
    }
    /**
     * { "_id" : "1", "content" : "我还是没有想明白", "student" : { "_id" : 1, "name" :
     *  "zhangsan", "age" : 18, "sex" : "male", "_class" : "com.ply.pojo.Student" } }
     */

    /**
     * { "_id" : "1", "content" : "我还是没有想明白", "student" : { "_id" : 1, "name" :
     *  "zhangsan", "age" : 18, "sex" : "male", "_class" : "com.ply.pojo.Student" }, "s
     * tudents" : [ { "_id" : 1, "name" : "zhangsan", "age" : 18, "sex" : "male", "_cla
     * ss" : "com.ply.pojo.Student" } ] }
     */

    /**
     * { "_id" : "1", "content" : "我还是没有想明白", "student" : { "_id" : 1, "name" :
     *  "zhangsan", "age" : 18, "sex" : "male", "_class" : "com.ply.pojo.Student" }, "s
     * tudents" : [ { "_id" : 1, "name" : "zhangsan", "age" : 18, "sex" : "male", "_cla
     * ss" : "com.ply.pojo.Student" } ], "studentss" : [ { "name" : "zhangsan", "age" :
     *  18, "sex" : "male", "idd" : 1, "_class" : "com.ply.pojo.Student" } ] }
     */

}
