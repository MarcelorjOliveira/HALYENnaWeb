/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.halyen.halyennaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.halyen.halyennaweb.controller.MainController;
import br.com.halyen.halyennaweb.model.Exercise;
import br.com.halyen.halyennaweb.model.ExerciseChooser;
import org.springframework.ui.Model;

/**
 *
 * @author marcelo
 */

@Controller
public class BasicExercisesController {
   
    public static final String dirBasicExercises = MainController.dirMain+"basicexercises/";
    
    private ExerciseChooser chooser;
    private Exercise exercise;
    
    @RequestMapping("exerciciosbasicos")
    public String exercise() {
        chooser = new ExerciseChooser();
        return "redirect:exerciciosbasicos/novo";
   }
    
    @RequestMapping("exerciciosbasicos/novo")
    public String newExercise(Model model){
        exercise = chooser.chooseExercise();
        model.addAttribute("title", exercise.title() );
        return dirBasicExercises+"basicexercises";
    }
}
