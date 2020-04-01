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
    private String defintion;

    public Flashcard() {
    }

    public Flashcard(String term, String defintion) {
        this.term = term;
        this.defintion = defintion;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefintion() {
        return defintion;
    }

    public void setDefintion(String defintion) {
        this.defintion = defintion;
    }

    @Override
    public String toString() {
        return term + "," + defintion;
    }
}
