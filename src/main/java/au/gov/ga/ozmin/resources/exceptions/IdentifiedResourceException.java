package au.gov.ga.ozmin.resources.exceptions;


public class IdentifiedResourceException extends Throwable {
    public IdentifiedResourceException(String s) {



        System.out.println("Bad units symbol" + s);
    }
}
