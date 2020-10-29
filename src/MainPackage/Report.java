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

    public Report(File file, Txt txtFile, String[] tokens) {
        this.file = file;
        this.txtFile = txtFile;
        this.tokens = tokens;
        this.fileLines = txtFile.getLines();
    }

    public Report(File file, Txt txtFile) {
        this.file = file;
        this.txtFile = txtFile;
        this.fileLines = txtFile.getLines();
    }

    public ArrayList<String> getReport() {
        report.clear();
        return report;
    }

    public ArrayList<Object> getClassData() {
        int lineIndexOfClassName = -1;
        String className = "";

        ArrayList<Object> data = new ArrayList();
        
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).equals("class")) {
                lineIndexOfClassName = i;
                
                String[] ignoreThis = {"public", "class"};
                className = getName(fileLines.get(i),ignoreThis);
            }
        }
        
        data.add(lineIndexOfClassName);
        data.add(className);
        
        return data;
    }

    public String getName(String w, String[] ignore) {
        String word = "";
        for(String wordToReplace : ignore){
            w = w.replace(wordToReplace, " ");
        }
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != ' ' && w.charAt(i) != '{') {
                word += w.charAt(i);
            }
        }
        return word;
    }

    public ArrayList<String> getMinimalReport() {
        minimalReport.clear();

        int lineCount = 0;
        for (String line : txtFile.getLines()) {
            for (String t : tokens) {
                if (line.contains(t)) {
                    minimalReport.add("Se encontro el token\t\"" + t + "\"\ten la linea: " + lineCount + " en la posición: " + (line.indexOf(t) + 1));
                }
            }
            lineCount++;
        }
        return minimalReport;
    }

    public void setTokens(String[] t) {
        this.tokens = t;
    }

}
