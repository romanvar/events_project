package cz.varadi.events_project.services;

import cz.varadi.events_project.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    public static List<UserEntity> getUserList() {
        return new ArrayList<UserEntity>();
    }
}
