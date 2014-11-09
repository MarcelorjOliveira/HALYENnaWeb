/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.halyen.halyennaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**     
 *
 * @author marcelo
 */
@Controller
public class MainController {
    @RequestMapping("principal")
    public String actMain(){
        return "main/main";
    }
    
}
