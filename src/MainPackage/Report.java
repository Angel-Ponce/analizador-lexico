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
        scanClass();
        scanAttributes();
        getClassMethods();
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
                            lineIndexOfVariable = i;
                            accessModifier = getAccessModifier(fileLines.get(i));
                            if (accessModifier.length() == 0) {
                                accessModifier = "public";
                            }
                            typeOf = dataType;
                            String[] ignore1 = {accessModifier, typeOf, "="};
                            variableName = ignoreCharSequence(divideEquals[0], ignore1);
                            System.out.println(variableName);
                            String[] ignore2 = {divideEquals[0], ";", "="};
                            valueAssigned = ignoreCharSequence(fileLines.get(i), ignore2);
                            Object[] attribute = {lineIndexOfVariable, accessModifier, typeOf, variableName, valueAssigned};
                            properties.add(attribute);
                        } else {
                            //Variable sin asignación
                            lineIndexOfVariable = i;
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

    public ArrayList<Object[]> getClassMethods() {
        ArrayList<Object[]> methods = new ArrayList();
        int lineIndexOfMethod = -1;
        
        for (int i = 0; i < fileLines.size(); i++) {
            if (fileLines.get(i).matches("(\\s)*[a-z]{6,9}(\\s)+[A-za-z]+(\\s)+\\w+(\\s)*(\\()(\\s)*((\\w)*(\\s)+(\\w)*(\\s)*(,)?(\\s)*)*(\\s)*(\\))(\\s)*(\\{)?(\\s)*")) {
                //metodo validado en cuanto sintaxis
            }
        }
        return methods;
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
