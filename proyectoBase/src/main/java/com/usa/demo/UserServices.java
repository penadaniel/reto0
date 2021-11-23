/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lina1
 */
@Service

public class UserServices {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll(){
       return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    public User registrar(User user){
        if (user.getId() ==null){
            if(existeEmail(user.getEmail())==false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    public boolean existeEmail (String email){
        return userRepository.existeEmail(email);
    }
    
    public User autenticarUuario(String email, String password){
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
                if(!usuario.isPresent()){
                    return new User(email, password, "NO DEFINIDO");
                }else{
                    return usuario.get();
                }
                
                }
}
