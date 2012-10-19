package dev.amb.report.data;


public class Term implements Comparable<Term> {

    Term() {
    }

    Term(String term, long frequency) {
        if (term != null && frequency != 0) {
            this.term = term;
            this.frequency = frequency;
        }
    }
    private String term;
    private long frequency;

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Term) {
            Term obj = (Term) o;

            if (obj.getTerm().equals(this.getTerm())
                    && obj.getFrequency() == this.getFrequency()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int compareTo(Term o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (o.getFrequency() == this.getFrequency()) {
            return EQUAL;
            
        } else {
            if (o.getFrequency() > this.getFrequency()) {
                return AFTER;
                
            } else {
                // if not equal or less, than must be greater
                return BEFORE;
            }
        }
    }
}
