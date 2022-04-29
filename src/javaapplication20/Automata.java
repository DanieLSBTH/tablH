/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mutsu
 */
public class Automata {
    Pattern[] afd = new Pattern[7];
    
    public Automata(){
    afd[0] = Pattern.compile("\\s+");
    afd[1] = Pattern.compile("([A-Za-z]|_)([A-Za-z]|_|[0-9])*");
    afd[2] = Pattern.compile("[\\+\\-\\*/]=|=");
    afd[3] = Pattern.compile("[\\+\\-\\*/]");
    afd[4] = Pattern.compile("[0-9]+");
    afd[5] = Pattern.compile("\\(|\\)");
    afd[6] = Pattern.compile("\\;");
    }
    
    public boolean Reconoce(String texto, int iniToken, int[] i, int noAuto){
    Matcher m = afd[noAuto].matcher(texto);
    if (m.find(iniToken))
        if (m.start()== iniToken){
        i[0] = m.end();
        return true;
        }
        else 
            return false;
    else 
        return false;
    
    }
    
}
