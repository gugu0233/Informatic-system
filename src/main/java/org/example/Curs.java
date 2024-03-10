package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curs<T extends Student> {
    private String nume;
    private int capacitate;
    private List<T> studenti;

    public Curs(String nume, int capacitate) {
        this.nume = nume;
        this.capacitate = capacitate;
        this.studenti = new ArrayList<>(capacitate);
    }

    public String getNume() {
        return nume;
    }
    public int getCapacitate() {
        return capacitate;
    }

    public void adaugaStudent(T student) {
        if (studenti.size() < capacitate ) 
            studenti.add(student);
    }

    public void afisare() {
        for (T student : studenti) 
            System.out.println(student);
    }

    public boolean areLocuriDisponibile() {
        if(studenti.size() < capacitate)
            return true;
        return false;
    }


    public static void main(String[] args) {
        Curs<StudentLicenta> cursLicenta = new Curs<>("Licenta", 50);
        Curs<StudentMaster> cursMaster = new Curs<>("Master", 30);

        StudentLicenta studLicenta = new StudentLicenta("Ana");
        StudentLicenta studLicenta2 = new StudentLicenta("alex");
        StudentLicenta studLicenta3 = new StudentLicenta("maria");
        StudentMaster studMaster = new StudentMaster("Marius");

        System.out.println(cursLicenta.getNume());
        cursLicenta.adaugaStudent(studLicenta);
        cursLicenta.adaugaStudent(studLicenta2);
        cursLicenta.adaugaStudent(studLicenta3);
        //cursLicenta.adaugaStudent(studMaster);  

        cursMaster.adaugaStudent(studMaster);
        //cursMaster.adaugaStudent(studLicenta);  
        cursLicenta.afisare();
    }
}

