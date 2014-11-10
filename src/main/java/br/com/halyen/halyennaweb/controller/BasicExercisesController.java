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
import javax.servlet.http.HttpServletRequest;
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
        return dirBasicExercises+"new";
    }
    
    @RequestMapping("exerciciosbasicos/roda")
    public String runExercise(HttpServletRequest request){
        exercise.buildGrading(request.getParameter("resolution"));
        if (exercise.hasCompileErrors != true) {
            //exercicio.salvarBancoDeDados(codigoUsuario, conexao);
            if (chooser.canDoNextExercise() == true) {
                //botaoProximoExercicio.setVisible(true);
                //botaoSalvar.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Teste de próximo exercício");
                return "redirect:exerciciosbasicos/novo";
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Parabéns. Você passou no teste!");
                return "redirect:principal";
            }
        } else {
            //exercicio.salvarBancoErroDeCompilacao(codigoUsuario, conexao);
            if (exercise.endOfAttempts == true) {
                if (chooser.canDoNextExercise() == true) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Estouro de "
                            + "quantidade de tentativas atingido. "
                            + "Por favor, fazer o próximo exercício");
                    return "redirect:exerciciosbasicos/novo";
                    //botaoProximoExercicio.setVisible(true);
                    //botaoSalvar.setVisible(false);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Você foi reprovado no teste");
                    return "redirect:principal";
                }
            }
        }
        return "redirect:exerciciosbasicos/novo";
    }
}
