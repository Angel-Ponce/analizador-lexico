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
    ArrayList<String> report = new ArrayList();
    String[] tokens;
    
    public Report(File file, Txt txtFile, String[] tokens){
        this.file = file;
        this.txtFile = txtFile;
        this.tokens = tokens;
    }
    
    public ArrayList<String> getReport(){
        
        for(String line: txtFile.getLines()){
            for(String token: tokens){
                
            }
        }
        
        return this.report;
    }
    
}
