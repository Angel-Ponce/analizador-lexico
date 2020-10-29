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
        //Class
        report.add("La clase de nombre "+getClassData().get(2).toString()+" se declaro en la linea "+getClassData().get(0).toString());
        report.add("El modificador de accesso de la clase "+getClassData().get(2).toString()+" es "+getClassData().get(1).toString() + "\n");
        //Atributes
        ArrayList<Object[]> properties = getClassPropertiesData();
        for (int i = 0; i < properties.size(); i++) {
            Object[] atribute = properties.get(i);
            report.add("En la linea "+atribute[0]+" se declaro un atributo de tipo: "+atribute[2]+"\n");
            report.add("Su modificador de acceso es: "+atribute[1]+"\n");
            report.add("El nombre del atributo es: "+atribute[3]+"\n");
            report.add("El valor de asignación es: "+atribute[4]+"\n----------------------------------------------------------");
        }
        return report;
    }

    public ArrayList<Object> getClassData() {
        int lineIndexOfClassName = -1;
        String className = "";
        String classType = "public";

        ArrayList<Object> data = new ArrayList();

        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).contains("class")) {
                lineIndexOfClassName = i;

                String[] ignoreThis = {"public", "class", "{"};
                className = ignoreCharSequence(fileLines.get(i), ignoreThis);
            }
        }

        data.add(lineIndexOfClassName);
        data.add(classType);
        data.add(className);

        return data;
    }
    
    public ArrayList<Object[]> getClassPropertiesData(){
        ArrayList<Object[]> properties = new ArrayList();
        int lineIndexOfVariable = -1;
        String accessModifier = "";
        String typeOf = "";
        String variableName = "";
        String valueAssigned = "";
        for(String dataType : Constants.DATATYPES){
            for (int i = 0; i<fileLines.size(); i++) {
                if(fileLines.get(i).contains(dataType) && fileLines.get(i).contains(";")){
                    //Tenemos que validar que la nomenclatura de la declaración del objeto sea correcta
                    if(fileLines.get(i).matches("(\\s)*[a-z]{0,9}(\\s)+"+dataType+"(\\s)*.*;")){
                        if(fileLines.get(i).contains("=")){
                            //Variable con asignación
                            String[] divideEquals  = fileLines.get(i).split("=");
                            lineIndexOfVariable = i;
                            accessModifier = getAccessModifier(fileLines.get(i));
                            if(accessModifier.length() == 0){
                                accessModifier = "public";
                            }
                            typeOf = dataType;
                            String[] ignore1 = {accessModifier,typeOf,"=",divideEquals[1]};
                            variableName = ignoreCharSequence(fileLines.get(i),ignore1);
                            String[] ignore2 = {divideEquals[0],";","="};
                            valueAssigned = ignoreCharSequence(fileLines.get(i),ignore2);
                            Object[] atribute = {lineIndexOfVariable,accessModifier,typeOf,variableName,valueAssigned};
                            properties.add(atribute);
                        }else{
                            //Variable sin asignación
                            lineIndexOfVariable = i;
                            accessModifier = getAccessModifier(fileLines.get(i));
                            if(accessModifier.length() == 0){
                                accessModifier = "public";
                            }
                            typeOf = dataType;
                            String[] ignore1 = {accessModifier,typeOf,";"};
                            variableName = ignoreCharSequence(fileLines.get(i),ignore1);
                            valueAssigned = "Sin valor asignado";
                            Object[] atribute = {lineIndexOfVariable,accessModifier,typeOf,variableName,valueAssigned};
                            properties.add(atribute);
                        }
                    }
                }
            }
        }  
        return properties;
    }

    public String ignoreCharSequence(String w, String[] ignore) {
        String word = "";
        for (String wordToReplace : ignore) {
            w = w.replace(wordToReplace, " ");
        }
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i) != ' '){
                word += w.charAt(i);
            }
        }
        return word;
    }
    
    public String getAccessModifier(String line){
        String res = "";
        for(String modifier: Constants.ACCESSMODIFIERS){
            if(line.contains(modifier)){
                res = modifier;
                break;
            }
        }
        return res;
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
