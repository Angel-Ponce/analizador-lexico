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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
            
        } catch (IOException e) {
            System.err.println(e);
        }
        
        return this.lines;
    }
    
    public void addLine(String line){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(this.file,true);
            pw = new PrintWriter(fw);
            pw.append(line+"\n");
        } catch (IOException e) {
            System.err.println(e);
        }finally{
             try {
                if (null != fw)
                   fw.close();
                } catch (IOException e2) {
                   System.err.println(e2);
                }
        }
    }
    
    public void addContent(ArrayList<String> lines){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(this.file,true);
            pw = new PrintWriter(fw);
            for(String l: lines){
                pw.println(l);
            }
        } catch (IOException e) {
            System.err.println(e);
        }finally{
             try {
                if (null != fw)
                   fw.close();
                } catch (IOException e2) {
                   System.err.println(e2);
                }
        }
    }
}
