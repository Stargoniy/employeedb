package com.in6k.employeedb.form;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class EmployeeForm {
    private static final String VALID_NAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_SURNAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_EMAIL_REGEXP = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$";
    private static final String VALID_PASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_CONFPASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_BIRTHDATE_REGEXP = "^[0-9]+-[0-9]+-[0-9]+$";

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String passwordConfirmation;
    protected String birhdate;

    public Set<String> validate() {
        Set<String> result = new ConcurrentSkipListSet<String>();

        if (!isValidValue(firstName, VALID_NAME_REGEXP)) {
            result.add("firstName");
        }
        if (!isValidValue(lastName, VALID_SURNAME_REGEXP)) {
            result.add("lastName");
        }
        if (!isValidValue(email, VALID_EMAIL_REGEXP)) {
            result.add("email");
        }
        if (!isValidValue(password, VALID_PASS_REGEXP)) {
            result.add("password");
        }
        if (!isValidValue(passwordConfirmation, VALID_CONFPASS_REGEXP)) {
            result.add("passwordConfirmation");
        }
        if (!isValidValue(birhdate, VALID_BIRTHDATE_REGEXP)) {
            result.add("birhdate");
        }
        return result;
    }

    private boolean isValidValue(String value, String pattern) {
        if (value == null) {
            return false;
        }
        return value.matches(pattern);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getBirhdate() {
        return birhdate;
    }

    public void setBirhdate(String birhdate) {
        this.birhdate = birhdate;
    }
}
