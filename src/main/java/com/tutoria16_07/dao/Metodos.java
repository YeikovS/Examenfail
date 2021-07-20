
package com.tutoria16_07.dao;

import java.util.List;
import java.util.Map;

public interface Metodos<T> {
    int create(T t);
    int update(T t);
    int delete(int id);
    T read(int id);
    List<T> readAll();
    List<Map<String, Object>> readAll2();
}
