package com.itlize.project.resourceManagement.Service;

import com.itlize.project.resourceManagement.Entity.Project;
import com.itlize.project.resourceManagement.Entity.Resource;
import com.itlize.project.resourceManagement.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public User findOneById(Integer id);
    public User save(User user);
    public void delete(Integer id);

}
