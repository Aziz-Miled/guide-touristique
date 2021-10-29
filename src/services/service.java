/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author houss
 * @param <T>
 */
public interface service<T> {
    void insert(T object);
    void update(T object);
    void delete(T object);
    void login(T object) throws SQLException;
    List<T> findAll() throws SQLException;
    
}
