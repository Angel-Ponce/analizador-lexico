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
        report.add("*---------------------------*Scaneo de clase*---------------------------*");
        scanClass();
        report.add("*---------------------------*Scaneo de constructores*---------------------------*");
        scanConstructors();
        report.add("*---------------------------*Scaneo de atributos*---------------------------*");
        scanAttributes();
        report.add("*---------------------------*Scaneo de metodos*---------------------------*");
        scanMethods();
        report.add("*---------------------------*Scaneo de Comentarios*---------------------------*");
        scanCommentsSingleLine();
        return report;
    }

    private void scanClass() {
        //Class
        report.add("La clase de nombre " + getClassData().get(2).toString() + " se declaro en la linea " + getClassData().get(0).toString());
        report.add("El modificador de accesso de la clase " + getClassData().get(2).toString() + " es " + getClassData().get(1).toString() + "\n");
    }

    private void scanAttributes() {
        //Attributes
        ArrayList<Object[]> properties = getClassPropertiesData();
        for (int i = 0; i < properties.size(); i++) {
            Object[] attribute = properties.get(i);
            report.add("En la linea " + attribute[0] + " se declaro un atributo de tipo: " + attribute[2]);
            report.add("Su modificador de acceso es: " + attribute[1]);

            if (attribute[3].toString().matches("^[A-Za-z]\\w*")) {
                // Es un nombre de variable valida
                report.add("El nombre del atributo es: " + attribute[3]);
            } else {
                report.add("El nombre del atributo en la linea " + attribute[0] + " no es valido.");
            }

            if (!attribute[4].equals("Sin valor asignado")) {

                if (attribute[4].toString().contains("(") && !attribute[4].toString().contains("new")) {
                    report.add("Se le asigno el metodo: " + attribute[4]);
                } else if (attribute[4].toString().contains("new")) {

                    report.add("Se instancio un nuevo objeto de tipo: " + attribute[4].toString().replace("new", ""));

                } else {
                    report.add("El valor de asignación es: " + attribute[4]);
                }

            }
            report.add("");
        }
    }
    
    private void scanConstructors(){
        ArrayList<Object[]> constructors = getClassConstructors();
        for (int i = 0; i < constructors.size(); i++) {
            Object[] constructor = constructors.get(i);
            report.add("Se declaro un constructor de la clase "+constructor[2]+" en la linea "+constructor[0]);
            if(constructor[1].toString().length()>2){
                report.add("Recibe de parámetros: "+constructor[1]);
            }
            report.add("El método finaliza en la linea "+constructor[3]);
            report.add("");
        }
    }
    
    private void scanMethods(){
        ArrayList<Object[]> methods = getClassMethods();
        for (int i = 0; i < methods.size(); i++) {
            Object[] ob = methods.get(i);
            report.add("Se declaro un metodo de nombre "+ob[3]+" en la linea "+ob[0]);
            report.add("El tipo de retorno es: "+ob[2]);
            report.add("Su modificador de acceso es: "+ob[1]);
            if(ob[4].toString().length() > 2){
                report.add("Recibe de parametros: "+ob[4]);
            }
            report.add("El método finaliza en la linea "+ob[5]);
            report.add("");
        }
    }

    private void scanCommentsSingleLine(){
        ArrayList<Object[]> comments = getClassCommentsSingleLine();
        for (int i = 0; i < comments.size(); i++) {
            Object[] comment = comments.get(i);
            report.add("Se commento la linea "+comment[0]);
            report.add("Comentario: "+comment[1]);
            report.add("");
        }
    }
    
    public ArrayList<Object> getClassData() {
        int lineIndexOfClassName = -1;
        String className = "";
        String classType = "public";

        ArrayList<Object> data = new ArrayList();

        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).contains("class")) {
                lineIndexOfClassName = i+1;

                String[] ignoreThis = {"public", "class", "{"};
                className = ignoreCharSequence(fileLines.get(i), ignoreThis);
            }
        }

        data.add(lineIndexOfClassName);
        data.add(classType);
        data.add(className);

        return data;
    }

    public ArrayList<Object[]> getClassPropertiesData() {
        ArrayList<Object[]> properties = new ArrayList();
        int lineIndexOfVariable = -1;
        String accessModifier = "";
        String typeOf = "";
        String variableName = "";
        String valueAssigned = "";
        for (String dataType : Constants.DATATYPES) {
            for (int i = 0; i < fileLines.size(); i++) {
                if (fileLines.get(i).contains(dataType) && fileLines.get(i).contains(";")) {
                    //Tenemos que validar que la nomenclatura de la declaración del objeto sea correcta
                    if (fileLines.get(i).matches("(\\s)*[a-z]{0,9}(\\s)+" + dataType + "(\\s)*.*;")) {
                        if (fileLines.get(i).contains("=")) {
                            //Variable con asignación
                            String[] divideEquals = fileLines.get(i).split("=");
                            lineIndexOfVariable = i+1;
                            accessModifier = getAccessModifier(fileLines.get(i));
                            if (accessModifier.length() == 0) {
                                accessModifier = "public";
                            }
                            typeOf = dataType;
                            String[] ignore1 = {accessModifier, typeOf, "="};
                            variableName = ignoreCharSequence(divideEquals[0], ignore1);
                            String[] ignore2 = {divideEquals[0], ";", "="};
                            valueAssigned = ignoreCharSequence(fileLines.get(i), ignore2);
                            Object[] attribute = {lineIndexOfVariable, accessModifier, typeOf, variableName, valueAssigned};
                            properties.add(attribute);
                        } else {
                            //Variable sin asignación
                            lineIndexOfVariable = i+1;
                            accessModifier = getAccessModifier(fileLines.get(i));
                            if (accessModifier.length() == 0) {
                                accessModifier = "public";
                            }
                            typeOf = dataType;
                            String[] ignore1 = {accessModifier, typeOf, ";"};
                            variableName = ignoreCharSequence(fileLines.get(i), ignore1);
                            valueAssigned = "Sin valor asignado";
                            Object[] attribute = {lineIndexOfVariable, accessModifier, typeOf, variableName, valueAssigned};
                            properties.add(attribute);
                        }
                    }
                }
            }
        }
        return properties;
    }

     public ArrayList<Object[]> getClassConstructors(){
        ArrayList<Object[]> constructors = new ArrayList();
        String className = getClassData().get(2).toString();
        int lineIndexOfConstructor = -1;
        String params = "";
        int limit = -1;
         for (int i = 0; i < fileLines.size(); i++) {
             if (fileLines.get(i).matches("(\\s)*public(\\s)+"+className+"(\\s)*(\\()(\\s)*((\\w)*(\\s)+(\\w)*(\\s)*(,)?(\\s)*)*(\\s)*(\\))(\\s)*(\\{)?(\\s)*(.)*(\\s)*(\\})?(\\s)*")) {
                //Cumple con la expresión regular de un constructor
                lineIndexOfConstructor = i+1;
                int initP = fileLines.get(i).indexOf("(");
                int initF = fileLines.get(i).indexOf(")");
                params = "";
                 for (int j = initP; j <= initF; j++) {
                     params += fileLines.get(i).charAt(j);
                 }
                 limit = getLastLineKey(i)+1;
                 Object[] constructor = {lineIndexOfConstructor,params,className,limit};
                 constructors.add(constructor);
             }
         }
        
        return constructors;
    }
    
    public ArrayList<Object[]> getClassMethods() {
        ArrayList<Object[]> methods = new ArrayList();
        int lineIndexOfMethod = -1;
        String accessModifier = "";
        String returnType = "";
        String methodName = "";
        String params = "";
        int limit = -1;
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*[a-z]{6,9}(\\s)+[A-za-z]+(\\s)+\\w+(\\s)*(\\()(\\s)*((\\w)*(\\s)+(\\w)*(\\s)*(,)?(\\s)*)*(\\s)*(\\))(\\s)*(\\{)?(\\s)*(.)*(\\s)*(\\})?(\\s)*")) {
                //metodo validado en cuanto sintaxis
                lineIndexOfMethod = i+1;
                accessModifier = getAccessModifier(fileLines.get(i));
                int initP = fileLines.get(i).indexOf("(");
                int initF = fileLines.get(i).indexOf(")");
                params = "";
                String rest = "";
                for (int j = initP; j <= initF; j++) {
                    params += fileLines.get(i).charAt(j);
                }
                for (int j = initF+1; j < fileLines.get(i).length(); j++) {
                    rest += fileLines.get(i).charAt(j);
                }
                if(params.length()>2){
                    String[] divide = fileLines.get(i).split(params);
                    returnType = getDataType(divide[0]);   
                }else{
                    returnType = getDataType(fileLines.get(i));
                }
                limit = getLastLineKey(i)+1;
                String[] ignore = {accessModifier, returnType, params,rest,"{","}"};
                methodName = ignoreCharSequence(fileLines.get(i),ignore);
                Object[] method = {lineIndexOfMethod,accessModifier,returnType,methodName,params,limit};
                methods.add(method);
            }
        }
        return methods;
    }

    public ArrayList<Object[]> getClassCommentsSingleLine(){
        ArrayList<Object[]> comments = new ArrayList();
        int lineIndexOfComment = -1;
        String comment = "";
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)+\\/\\/(.)*")) {
                //Cumple la expresión regular de un comentario de una sola linea
                lineIndexOfComment = i+1;
                comment = fileLines.get(i).replace("//", "");
                Object[] com = {lineIndexOfComment,comment};
                comments.add(com);
            }
        }
        return comments;
    }
    
    public String ignoreCharSequence(String w, String[] ignore) {
        String word = "";
        for (String wordToReplace : ignore) {
            w = w.replace(wordToReplace, " ");
        }
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != ' ') {
                word += w.charAt(i);
            }
        }
        return word;
    }

    public String getAccessModifier(String line) {
        String res = "";
        for (String modifier : Constants.ACCESSMODIFIERS) {
            if (line.contains(modifier)) {
                res = modifier;
                break;
            }
        }
        return res;
    }
    
    public String getDataType(String line){
        String res = "";
        for(String dataType: Constants.DATATYPES){
            if(line.contains(dataType)){
                res = dataType;
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
                    minimalReport.add("Se encontro el token\t\"" + t + "\"\ten la linea: " +( lineCount + 1)+ " en la posición: " + (line.indexOf(t) + 1));
                }
            }
            lineCount++;
        }
        return minimalReport;
    }

    public int getLastLineKey(int init){
        int res = -1;
        int keysOpened = 0;
        int keysClosed = 0;
        for (int i = init; i < fileLines.size(); i++) {
            char[] chars = fileLines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == '{'){
                    keysOpened++;
                }else if(chars[j] == '}'){
                    keysClosed++;
                }
            }
            if(keysOpened == keysClosed){
                res = i;
                break;
            }
        }
        return res;
    }
    
    public void setTokens(String[] t) {
        this.tokens = t;
    }

}
