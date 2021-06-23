package com.codeclan.folder_service.components;

import com.codeclan.folder_service.models.User;
import com.codeclan.folder_service.repositories.FileRepository;
import com.codeclan.folder_service.repositories.FolderRepository;
import com.codeclan.folder_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepo;

    @Autowired
    FolderRepository shipRepo;

    @Autowired
    UserRepository userRepo;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User colin = new User("Colin");
        User roosa = new User("Roosa");
        User hannah = new User("Hannah");
        User sky = new User("Sky");

        userRepo.save(colin);
        userRepo.save(roosa);
        userRepo.save(hannah);
        userRepo.save(sky);


    }
}
