/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.halyen.halyennaweb.model;

import java.util.ArrayList;

/**
 *
 * @author marcelo
 */
public class ExerciseChooser {
    ArrayList<Exercise> exerciciosAFazer = new ArrayList<Exercise>();
    ArrayList<Exercise> exerciciosFeitos = new ArrayList<Exercise>();
    boolean fazerProximoExercicio;
    
    public ExerciseChooser()
    {
        adicionarExercicios();
    }
    
    public void adicionarExercicios() {
        exerciciosAFazer.add(new FactorialExercise());
        exerciciosAFazer.add(new FibonnaciExercise());
        exerciciosAFazer.add(new SpotExercise());
        exerciciosAFazer.add(new MultipleExercise());
        exerciciosAFazer.add(new SumExercise());
        exerciciosAFazer.add(new MultipleSumExercise());
        exerciciosAFazer.add(new SummationExercise());
        exerciciosAFazer.add(new MultiplicandExercise());
    }
    
    public Exercise escolherExercicio()
    {
        double random = Math.random() * exerciciosAFazer.size();
        
        Exercise exercicio = exerciciosAFazer.get((int)random);
        exerciciosAFazer.remove(exercicio);
        exerciciosFeitos.add(exercicio);
        
        return exercicio;
    } 
    
    private double media() {
        double notaTotal=0,media;
        for(Exercise exercicio : exerciciosFeitos)
        {
            notaTotal += exercicio.notaExercicio();
        }
        
        media = notaTotal/exerciciosFeitos.size();
        javax.swing.JOptionPane.showMessageDialog(null, "Média : " + media);
        return media;
    }
    
    public boolean fazerProximoExercicio() {
         if(exerciciosFeitos.size() >= 3)
            {
            if(exerciciosFeitos.size() <= 7)
            {
                if(media() >= 8.0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    } 
}
