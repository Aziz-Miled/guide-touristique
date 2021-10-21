/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author user
 * @param <T>
 */
public interface Service <T>{
    void insert (T object);
    void update (T object);
    void delete (int id);
    List<T> findAll ();
   
}
