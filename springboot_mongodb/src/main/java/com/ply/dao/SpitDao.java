package com.ply.dao;

import com.ply.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @author ply
 * @date 2018/11/13 0013 下午 9:50
 */
public interface SpitDao extends MongoRepository<Spit,String> {
}
