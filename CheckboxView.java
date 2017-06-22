package triage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxView {
 
    private String[] selectedConsole;
    private String[] selectedQuestionsRed;
    private String[] selectedQuestionsOrange;
    private String[] selectedQuestionsYellow;
    private String[] selectedQuestionsGreen;
    private List<String> red, orange, yellow, green;
    
    
    @PostConstruct
    public void init() {
        red = orange = yellow = green = new ArrayList<String>();
        
        red.add("Airway Compromise");
        red.add("Inadequate Breathing");
        red.add("Exsanguinating Haemorrhage");
        red.add("Shock");
        red.add("Unresponsive Child");
        red.add("Currently Fitting");
        
        orange.add("Uncontrollable Major Haemorrhage");
        orange.add("New Abnormal Pulse");
        orange.add("Alterate Conscious Level");
        orange.add("Very Hot");
        orange.add("Hot Baby");
        orange.add("Cold");
        orange.add("Severe Pain");
        
        yellow.add("Uncontrollable Minor Haemorrhage");
        yellow.add("History of Unconsciousness");
        yellow.add("Hot");
        yellow.add("Moderate Pain");
        
        green.add("Warmth");
        green.add("Recent Mild Pain");
        green.add("Precent Problem");
    }

    public String[] getSelectedConsole() {
        return selectedConsole;
    }


    public void setSelectedConsole(String[] selectedConsole) {
        this.selectedConsole = selectedConsole;
    }


    public String[] getSelectedQuestionsRed() {
        return selectedQuestionsRed;
    }


    public void setSelectedQuestionsRed(String[] selectedQuestionsRed) {
        this.selectedQuestionsRed = selectedQuestionsRed;
    }


    public String[] getSelectedQuestionsOrange() {
        return selectedQuestionsOrange;
    }


    public void setSelectedQuestionsOrange(String[] selectedQuestionsOrange) {
        this.selectedQuestionsOrange = selectedQuestionsOrange;
    }


    public String[] getSelectedQuestionsYellow() {
        return selectedQuestionsYellow;
    }


    public void setSelectedQuestionsYellow(String[] selectedQuestionsYellow) {
        this.selectedQuestionsYellow = selectedQuestionsYellow;
    }


    public String[] getSelectedQuestionsGreen() {
        return selectedQuestionsGreen;
    }


    public void setSelectedQuestionsGreen(String[] selectedQuestionsGreen) {
        this.selectedQuestionsGreen = selectedQuestionsGreen;
    }


    public List<String> getRed() {
        return red;
    }


    public void setRed(List<String> red) {
        this.red = red;
    }


    public List<String> getOrange() {
        return orange;
    }


    public void setOrange(List<String> orange) {
        this.orange = orange;
    }


    public List<String> getYellow() {
        return yellow;
    }


    public void setYellow(List<String> yellow) {
        this.yellow = yellow;
    }


    public List<String> getGreen() {
        return green;
    }


    public void setGreen(List<String> green) {
        this.green = green;
    }
    
 }

