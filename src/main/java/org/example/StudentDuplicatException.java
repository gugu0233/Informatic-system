package org.example;

public class StudentDuplicatException extends Exception {
    public StudentDuplicatException(String numeStudent) {
        super("Student duplicat: " + numeStudent);
    }
}
