package com.survivalcoding.library.presentation;

import java.util.Random;
import java.util.Scanner;
import com.survivalcoding.library.domain.model.User;
import com.survivalcoding.library.domain.repository.UserRepository;

public class UserContoller {
    private UserRepository userRepository;
    
    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);
    
    private User recentDeletedUser = null;
    
    public UserContoller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void printMenu() {
        while (!isExit) {
            System.out.println("1. 유저등록, 2. 유저목록, 3. 유저수정, 4. 유저삭제, 5. 삭제취소 0. 뒤로");
            int target = scanner.nextInt();
            if (target == 1) {
                addUser();
            } else if (target == 2) {
                printUserList();
            } else if (target == 0) {
                isExit = true;
            } else if (target == 4) {
                removeUser();
            } else if (target == 5) {
                restoreUser();
            }
        }
    }
    
    public void printUserList() {
        System.out.println(userRepository.findAll());
    }
    
    public void addUser() {
        // 쭉 받고
        String name = String.valueOf(new Random().nextInt(1000));
        userRepository.addUser(new User(name));
    }
    
    public void removeUser() {
        System.out.println("몇 번 id 삭제?");
        int target = scanner.nextInt();
        
        recentDeletedUser = userRepository.findById(target);
        userRepository.deleteUser(recentDeletedUser);
        System.out.println(target + " 이 지워졌습니다");
    }
    
    public void updateUser() {
        
    }
    
    public void restoreUser() {
        userRepository.addUser(recentDeletedUser);
        System.out.println("id : " + recentDeletedUser.getId() + "인 유저가 복구 됐어요");
    }
    
    public void exit() {
        
    }
}
