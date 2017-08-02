/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import service.UserFacade;

/**
 *
 * @author Papy
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {
    User user = new User();
    List<User> users = new ArrayList<>();
    @EJB
    UserFacade userfacade;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public String create(){
        userfacade.create(user);
        return "List";
    }
    public String editView(User user){
        this.user = user;
        return "Edit";
    }
    public String edit(){
        userfacade.edit(user);
        return "Edit";
    }
    public List<User> findAll(){
        return userfacade.findAll();
    }
    
    public void remove(User user){
        userfacade.remove(user);
        users.remove(user);
    }
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserFacade getUserfacade() {
        return userfacade;
    }

    public void setUserfacade(UserFacade userfacade) {
        this.userfacade = userfacade;
    }
    
    
    
}
