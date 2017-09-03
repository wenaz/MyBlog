package com.tencent.latke.demo.service;

import com.tencent.latke.demo.repository.UserRepository;
import org.b3log.latke.ioc.inject.Inject;
import org.b3log.latke.logging.Level;
import org.b3log.latke.logging.Logger;
import org.b3log.latke.repository.RepositoryException;
import org.b3log.latke.repository.annotation.Transactional;
import org.b3log.latke.service.annotation.Service;
import org.json.JSONObject;

/**
 * Created by ansonwen on 2017/8/30.
 */
@Service
public class UserService {
    private static final Logger LOGGER=Logger.getLogger(UserService.class.getName());

    @Inject
    private UserRepository userRepository;

    @Transactional
    public void saveUser(final String name, final int age) {
        final JSONObject user=new JSONObject();
        user.put("name",name);
        user.put("age",age);
        String userId;

        try {
            userId=userRepository.add(user);
        } catch (RepositoryException e) {
            LOGGER.log(Level.ERROR,"save user failed",e);
            //throw an exception to rollback transaction
            throw new IllegalStateException("save user failed");
        }

        LOGGER.log(Level.INFO,"save a user successfully [userId={0}]",userId);
    }
}
