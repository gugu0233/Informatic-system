package org.example;

class Student {
    private String nume;
    private double medie;

    Student(String nume){
        this.nume=nume;
    }

    public String getNume(){
        return nume;
    }
    public double getMedie(){
        return medie;
    }
    public void setMedie(double medie){
        this.medie=medie;
    }

    public String toString(){
        return this.getNume();
    }
    public static void main(String[] args) {
        Student stud = new Student("andrei");
        System.out.println(stud);
    }
}
