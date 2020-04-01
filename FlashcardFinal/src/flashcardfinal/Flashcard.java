/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcardfinal;

/**
 *
 * @author roblo
 */
public class Flashcard {
    private String term;
    private String definition;

    public Flashcard() {
    }

    public Flashcard(String term, String defintion) {
        this.term = term;
        this.definition = defintion;
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
