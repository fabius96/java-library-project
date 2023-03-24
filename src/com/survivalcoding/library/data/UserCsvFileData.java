package com.survivalcoding.library.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.survivalcoding.library.domain.model.User;

public class UserCsvFileData implements Data<User> {

    @Override
    public void save(List<User> items) {
        try (FileWriter fileWriter = new FileWriter("user.csv")) {
            for (User user : items) {
                fileWriter.append(String.valueOf(user.getId()));
                fileWriter.append(",");
                fileWriter.append(user.getName());
                fileWriter.append("\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> load() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void backup() {
        // TODO Auto-generated method stub

    }


}
