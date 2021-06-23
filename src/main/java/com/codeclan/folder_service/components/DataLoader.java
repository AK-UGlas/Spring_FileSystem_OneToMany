package com.codeclan.folder_service.components;

import com.codeclan.folder_service.models.File;
import com.codeclan.folder_service.models.Folder;
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
    FolderRepository folderRepo;

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

        Folder images = new Folder("images", colin);
        Folder project1 = new Folder("class project lessons", colin);
        Folder music = new Folder("metallica songs", colin);

        Folder project2 = new Folder("codeclan project", roosa);
        Folder pics = new Folder("Holiday pictures", roosa);

        File image1 = new File("cats", ".jpg", 250.0, images);
        File image2 = new File("dogs", ".jpg", 350.0, images);
        File song1 = new File("Nothing Else Matters", ".mp3", 4122.0, images);
        File song2 = new File("Enter Sandman", ".wav", 3612.2, images);
        File project_desc1 = new File("project_outline", ".docx", 75.0, images);
        File project_desc2 = new File("project_description", ".docx", 54.2, images);
        File holiday_img1 = new File("0019212", ".jpg", 250.0, images);
        File holiday_img2 = new File("0019330", ".jpg", 250.0, images);
        File holiday_img3 = new File("0019454", ".jpg", 250.0, images);

        images.addFile(image1);
        images.addFile(image2);
        project1.addFile(project_desc1);
        music.addFile(song1);
        music.addFile(song2);

        project2.addFile(project_desc2);
        pics.addFile(holiday_img1);
        pics.addFile(holiday_img2);
        pics.addFile(holiday_img3);

        folderRepo.save(images);
        folderRepo.save(project1);
        folderRepo.save(music);
        folderRepo.save(project2);
        folderRepo.save(pics);

        fileRepo.save(image1);
        fileRepo.save(image2);
        fileRepo.save(song1);
        fileRepo.save(song2);
        fileRepo.save(project_desc1);
        fileRepo.save(project_desc2);
        fileRepo.save(holiday_img1);
        fileRepo.save(holiday_img2);
        fileRepo.save(holiday_img3);
    }
}
