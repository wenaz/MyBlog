package com.tencent.latke.demo.repository;

import org.b3log.latke.repository.AbstractRepository;
import org.b3log.latke.repository.annotation.Repository;
import org.b3log.latke.repository.jdbc.util.JdbcRepositories;

/**
 * Created by ansonwen on 2017/8/30.
 */
@Repository
public class UserRepository extends AbstractRepository{
    public UserRepository(String name) {
        super("user");
        //Generates database tables
        JdbcRepositories.initAllTables();
    }
}
