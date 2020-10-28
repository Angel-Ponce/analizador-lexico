/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class Report {
    File file;
    Txt txtFile;
    ArrayList<String> fileLines;
    ArrayList<String> report = new ArrayList();
    ArrayList<String> minimalReport = new ArrayList();
    String[] tokens;
    
    public Report(File file, Txt txtFile, String[] tokens){
        this.file = file;
        this.txtFile = txtFile;
        this.tokens = tokens;
    }
    
    public Report(File file, Txt txtFile){
        this.file = file;
        this.txtFile = txtFile;
        this.fileLines = txtFile.getLines();
    }
    
    public ArrayList<String> getReport(){
        report.clear();
        int lineCount = 0;
        for(String line: fileLines){
            if(line.contains("class")){
                String[] words = line.split(" ");
                String className = getWord(words[1]);
                int lastLine = indexOfLastToken("}");
                report.add("En la linea "+lineCount+" se instancia una clase de nombre: "+className);
                report.add("La clase "+className+" termina en la linea: "+(lastLine+1));
            }
            
            lineCount++;
        }
        
        return this.report;
    }
    
    public ArrayList<String> getMinimalReport(){
        minimalReport.clear();
        
        int lineCount = 0;
        for(String line: txtFile.getLines()){
            for(String t: tokens){
                if(line.contains(t)){
                    minimalReport.add("Se encontro el token "+t+" en la linea: "+lineCount+" en la posición: "+(line.indexOf(t)+1));
                }
            }
            lineCount++;
        }
        return minimalReport;
    }
    
    public String getWord(String w){
        String word = "";
        if(w.indexOf("{") == -1){
            return w;
        }else{
            for(int i=0; i<w.length()-1; i++){
                word += w.charAt(i);
            }
            return word;
        }
    }
    
    public int indexOfLastToken(String token){
        int posLine = -1;
        int countLine = 0;
        for(String s: fileLines){
            if(s.contains(token)){
                posLine = countLine;
            }
            countLine++;
        }
        return posLine;
    }
    
    public void setTokens(String[] t){
        this.tokens = t;
    }
    
}
