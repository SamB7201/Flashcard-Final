/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardfinal;

import java.util.ArrayList;

/**
 *
 * @author roblo
 */
public class Flashcard {
    private String term;
    private String definition;
    private ArrayList <Integer> termCommas;
    private ArrayList <Integer> defCommas;
    public Flashcard() {
        termCommas = new ArrayList<Integer>();
        defCommas = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getTermCommas() {
        return termCommas;
    }

    public void setTermCommas(ArrayList<Integer> termCommas) {
        this.termCommas = termCommas;
    }

    public ArrayList<Integer> getDefCommas() {
        return defCommas;
    }

    public void setDefCommas(ArrayList<Integer> defCommas) {
        this.defCommas = defCommas;
    }

    public Flashcard(String term, String defintion) {
        this.term = term;
        this.definition = defintion;
    }
    public void addTermComma(int index){
        termCommas.add(index);
    }
    public void addDefComma(int index){
        defCommas.add(index);
    }
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return term + "," + definition;
    }
}
