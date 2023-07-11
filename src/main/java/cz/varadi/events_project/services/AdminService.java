package cz.varadi.events_project.services;

import cz.varadi.events_project.entities.UserEntity;

import java.util.List;

public interface AdminService {
    public  List<UserEntity> getUserList();

    UserEntity getUser(Integer id);
}
