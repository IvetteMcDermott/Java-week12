package Lab;

public class Validation {
    // ANSI escape codes for colors
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    // vars
    private String email;
    private String[] validExtensions = { "com", "edu", "org" };
    private boolean arroba = false;
    private boolean extValid = false;
    private boolean dot = false;
    private String result;
    private String extension;

    // set
    public void Setters(String email, String extension) {
        this.email = email;
        this.extension = extension;
    }

    public String computeValidate(String email, String extension) {
        // https://www.w3schools.com/java/ref_string_contains.asp
        if (email.contains("@")) {
            arroba = true;
        }
        // extension
        for (int i = 0; i < validExtensions.length; i++) {

            if (validExtensions[i].equals(extension)) {
                extValid = true;
            }
        }
        // dot
        if (email.charAt(email.length() - 4) == '.') {
            dot = true;
        }
        // what is missing validation
        if (extValid && arroba && dot) {
            result = green + "\nValid email address.\n" + reset;
        } else {
            result = red + "\nInvalid email:\n";
            if (!arroba) {
                result = result + "- there is no arroba.\n";
            }
            if (!dot) {
                result = result + "- there is no extension's dot or it is misplaced\n";
            }
            if (!extValid) {
                result = result + "- extension is not valid, should be .com, .edu or .org\n";
            }
            result = result + reset;
            ;
        }

        return result;
    }
}

// Create an application that takes in 2 pieces of information from a user;
// a single email address
// and an array of 3 character domain extensions (eg com,edu, org).
// These should be taken in as parameters into a single method. This
// application only needs 2 methods; 1 that sets and computes and 1 that returns
// information.

// The method should then do the following to validate the email address:
// -Check that there is an @ symbol in the email address
// -Check that there is a . before the 3 character extension
// -Ensure that the domain extension is one of the 3 character Strings from the
// array
// The method should return a String that states whether or not the email
// address is valid, and why.