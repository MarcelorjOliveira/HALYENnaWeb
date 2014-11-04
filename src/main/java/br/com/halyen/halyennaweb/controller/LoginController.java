/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.halyen.halyennaweb.controller;

import br.com.halyen.halyennaweb.dao.JdbcUsuarioDao;
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

    
    @RequestMapping("loginForm")
    public String loginForm() {
        return "login";
    }
    
    @RequestMapping("actLogin")
    public String actLogin(User user, HttpSession session){
        if (new JdbcUsuarioDao().existUser(user)) {
        session.setAttribute("usuarioLogado", user);
        return "ok";
        }
        return "redirect:loginForm";
    }
}
