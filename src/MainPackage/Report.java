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
        this.fileLines = txtFile.getLines();
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
                String className = getName(line,"class");
                int lastLine = indexOfLastToken("}");
                report.add("En la linea "+lineCount+" se instancia una clase de nombre: "+className);
                report.add("La clase "+className+" termina en la linea: "+(lastLine+1));
            }
            else if(line.contains("fun")){
                String[] words = line.split("fun");
                String type = getTypeFunction(words[0]);
                String functionName = getName(line.replace("fun", " "),type);
                int firstParentheses = line.indexOf("(");
                int secondParentheses = line.indexOf(")");
                String onParentheses = getLineByInterval(line,firstParentheses,secondParentheses);
                report.add("La clase contiene un método de tipo "+type+" y de nombre: "+functionName);
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
                    minimalReport.add("Se encontro el token\t\""+t+"\"\ten la linea: "+lineCount+" en la posición: "+(line.indexOf(t)+1));
                }
            }
            lineCount++;
        }
        return minimalReport;
    }
    
    public String getName(String w, String ignore){
        String word = "";
        w = w.replace(ignore, " ");
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i) != ' '  && w.charAt(i) != '{'){
                word+=w.charAt(i);
            }
        }
        return word;
    }
    
    public String getLineByInterval(String line, int i, int f){
        String res = "";
        
        for (int j = i; j <= f; j++) {
            res+=line.charAt(j);
        }
        
        return res;
    }
    
    public int indexOfWord(String[] words){
      return 0;
    }
    
    public String getTypeFunction(String line){
        String res = "";
        for(String type: Constants.TYPESDATES){
            if(line.contains(type)){
                res = type;
                break;
            }
        }
        return res;
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
