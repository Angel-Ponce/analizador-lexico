/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author Angel
 */
public class Txt {
    
    ArrayList<String> lines =  new ArrayList();
    File file;
    
    public Txt(File file){
        this.file = file;
    }
    
    public ArrayList<String> getLines(){
        lines.clear();
        try {
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
        
        return this.lines;
    }
    
    
}
