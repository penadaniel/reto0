/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lina1
 */
public interface UserInterface extends CrudRepository <User, Integer>{
   
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}

