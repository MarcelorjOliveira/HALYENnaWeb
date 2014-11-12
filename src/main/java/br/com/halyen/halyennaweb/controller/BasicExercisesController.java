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
    
    @RequestMapping(Routes.exerciciosbasicos)
    public String exercise() {
        chooser = new ExerciseChooser();
        return "redirect:"+Routes.exerciciosbasicosNovo;
   }
    
    @RequestMapping(Routes.exerciciosbasicosNovo)
    public String newExercise(Model model){
        exercise = chooser.chooseExercise();
        model.addAttribute("title", exercise.title() );
        return dirBasicExercises+"new";
    }
    
    @RequestMapping(Routes.exerciciosbasicosRoda)
    public String runExercise(HttpServletRequest request, Model model){
        exercise.buildGrading(request.getParameter("resolution"));
        javax.swing.JOptionPane.showMessageDialog(null, "Problema de compilação : " + exercise.hasCompileErrors);
        if (exercise.hasCompileErrors != true) {
            //exercicio.salvarBancoDeDados(codigoUsuario, conexao);
            javax.swing.JOptionPane.showMessageDialog(null, "Fazer próximo exercicio : " + chooser.canDoNextExercise());
            if (chooser.canDoNextExercise() == true) {
                //botaoProximoExercicio.setVisible(true);
                //botaoSalvar.setVisible(false);
                javax.swing.JOptionPane.showMessageDialog(null, "Teste de próximo exercício");
                return "redirect:"+Routes.exerciciosbasicosNovo;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Parabéns. Você passou no teste!");
                return "redirect:"+Routes.principal;
            }
        } else {
            //exercicio.salvarBancoErroDeCompilacao(codigoUsuario, conexao);
            if (exercise.endOfAttempts == true) {
                if (chooser.canDoNextExercise() == true) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Estouro de "
                            + "quantidade de tentativas atingido. "
                            + "Por favor, fazer o próximo exercício");
                    return "redirect:"+Routes.exerciciosbasicosNovo;
                    //botaoProximoExercicio.setVisible(true);
                    //botaoSalvar.setVisible(false);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Você foi reprovado no teste");
                    return "redirect:"+Routes.principal;
                }
            }
            else {
                //model.addAttribute("resolution", request.getParameter("resolution"));
                return "redirect:"+Routes.exerciciosbasicosNovo;
            }
        }
        
    }
}
