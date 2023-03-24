package com.survivalcoding.library.data;

import java.util.List;

public interface Data<T> {
    void save(List<T> items);

    List<T> load();

    void backup();
}
