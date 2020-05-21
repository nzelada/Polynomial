
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A class to represent a polynomial.
 *
 * @author Nick Zelada
 * @version 04/04/2019 I affirm that this program is entirely my own work and
 * other person's work is involved.
 */
public class Polynomial {

    LinkedList<Term> label; // creates a linkedlist

    /**
     * Constructs an empty polynomial
     */
    public Polynomial() {
        label = new LinkedList<Term>(); // assigns linkedlist
    }

    /**
     * Constructs a new polynomial with the given term
     *
     * @param t the term to initialize the polynomial with
     */
    public Polynomial(Term t) {
        label = new LinkedList<Term>(); // assigns linkedlist

        label.add(t); // puts t into linkedlist
    }

    /**
     * Adds the polynomial such that the terms are in sorted order from highest
     * power to lowest
     *
     * @param p the polynomial to add
     */
    public void add(Polynomial p) {
        int index = 0; // index of 0

        boolean add; // see if it was added or not

        Term current; //  term object

        for (Term second : p.label) { // for loop

            add = false; // assigns add false to add
// not adding a new term and there is terms in the list
            while (!add && index < label.size()) {

                current = label.get(index); // current term

                if (current.getPower() == second.getPower()) //if they are the same power
                {

                    current.addIfSamePower(second); // calls this method

                    add = true; // true then

                } else if (second.getPower() > current.getPower()) //if second term is larger
                {

                    label.add(index, new Term(second.getCoefficient(), second.getPower()));

                    add = true;

                }

                index++; // increments it

            }

            if (!add) // if not added
            {
                label.add(new Term(second.getCoefficient(), second.getPower())); //add to the list
            }
        }

    }

    /**
     * Multiplies the given polynomial with this one and returns the result
     *
     * @param p the polynomial to multiply
     * @return this * p
     */
    public Polynomial multiply(Polynomial p) {
        Polynomial b = new Polynomial();

        for (Term a1 : p.label) { // for loop

            for (Term a2 : label) { // for loop

                Term a3 = a1.multiply(a2); // multiplies and assigns it to a3

                b.add(new Polynomial(a3)); // it then adds it

            }

        }

        return b; // returns b

    }

    /**
     * Prints the polynomial "nicely" so that it reads from highest term to
     * lowest and doesn't have a leading "+" if the first term is positive.
     */
    public void print() {
        String line = "";

        for (int i = 0; i < label.size(); i++) { // for loop

            Term t = label.get(i); // gets i assigns it to t

            if (t.getCoefficient() > 0) {

                if (i != 0) { // if not equal to 0 return a plus
                    line += " + ";
                }

            } else {

                line += " - "; // if not return a -

            }

            line += t.toString(); // calls the string method

        }

        System.out.print(line); // prints the line

    }

}
