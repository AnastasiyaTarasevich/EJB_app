package com.example.laba_6;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
@Stateless
public class MyEjb {
    private Map<String, Integer[]> gradesMap= new HashMap<>();
    private Map<String, String[]> gradesWithErrorsMap= new HashMap<>();


    public void addStudentGrades(String surname, String[] gradesArray) {
        Integer[] grades = new Integer[gradesArray.length];

        boolean hasErrors = false;

        if (gradesArray.length != 5) {
            hasErrors = true;
        } else {
            for (int j = 0; j < gradesArray.length; j++) {
                String gradeStr = gradesArray[j].trim();
                try {
                    int grade = Integer.parseInt(gradeStr);
                    if (grade < 0 || grade > 10) {
                        hasErrors = true;
                        break;
                    }
                    grades[j] = grade;
                } catch (NumberFormatException e) {
                    hasErrors = true;
                    break;
                }
            }
        }

        if (hasErrors) {
            gradesWithErrorsMap.put (surname, gradesArray);
        } else {
            gradesMap.put(surname, grades);
        }

    }

    public Map<String, String[]> getGradesWithErrorsMap() {
        return gradesWithErrorsMap;
    }



}


