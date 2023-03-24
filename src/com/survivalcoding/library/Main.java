package com.survivalcoding.library;

import java.util.List;
import java.util.Scanner;
import com.survivalcoding.library.data.UserCsvFileData;
import com.survivalcoding.library.data.UserRepositoryImpl;
import com.survivalcoding.library.domain.model.User;
import com.survivalcoding.library.domain.repository.UserRepository;
import com.survivalcoding.library.presentation.UserContoller;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        UserContoller userContoller = new UserContoller(
                new UserRepositoryImpl(new UserCsvFileData())
        );

        boolean isExit = false;
        while (!isExit) {
            System.out.println("기능을 선택해주세요. 1. 회원관리 2. 도서관리 3. 종료");
            int target = sc.nextInt();

            if (target == 1) {
                userContoller.printMenu();
            } else if (target == 3) {
                System.exit(0);
            }
        }
    }
}
