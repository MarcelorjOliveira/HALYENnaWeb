/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.halyen.halyennaweb.controller;

import br.com.halyen.halyennaweb.dao.JdbcUserDao;
import br.com.halyen.halyennaweb.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class LoginController {
    
    
    
    private JdbcUserDao userDao = new JdbcUserDao();
    
    @RequestMapping("loginForm")
    public String loginForm() {
        return "login";
    }
    
    @RequestMapping("actLogin")
    public String actLogin(User user, HttpSession session){
        if (userDao.existUser(user)) {
        session.setAttribute("usuarioLogado", user);
        return "redirect:principal";
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, "Login ou Senha estão invpalidos, por favor"
                    + "tente novamente");
        return "redirect:loginForm";
        }
    }
    
    @RequestMapping("criaLoginForm")
    public String criaLoginForm() {
        return "criaLogin";
    }
    
    @RequestMapping("actCriaLogin")
    public String actCriaLogin(User user){
        if (userDao.existUser(user)){ 
            javax.swing.JOptionPane.showMessageDialog(null, "Login ou senha já existem, favor cadastrar outro");
            return "redirect:criaLoginForm";
        }
        else {
            userDao.createUser(user);
            javax.swing.JOptionPane.showMessageDialog(null, "Usuário criado com sucesso");
            return "redirect:loginForm"; 
        }
    }
}
