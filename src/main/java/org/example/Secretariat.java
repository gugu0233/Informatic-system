package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Secretariat {
    private Map<String, Student> studenti = new HashMap<>();
    private Map<String, Student> studentiContestatie = new HashMap<>();
    private List<Curs<?>> cursuri = new ArrayList<>();
    private Map<String, List<String>> preferinteStudenti = new HashMap<>();
    private Map<String, List<String>> repartizareCursuriStudenti = new HashMap<>();

    public Secretariat() {
        this.studenti = new HashMap<>();
        this.studentiContestatie = new HashMap<>();
        this.cursuri = new ArrayList<>();
    }

    public StudentLicenta creazaStudLicenta(String nume) throws StudentDuplicatException {
        verificaDuplicat(nume);
        StudentLicenta stud = new StudentLicenta(nume);
        return stud;
    }

    public StudentMaster creazaStudMaster(String nume) throws StudentDuplicatException {
        verificaDuplicat(nume);
        StudentMaster stud = new StudentMaster(nume);
        return stud;
    }

    public void adaugaStudent(Student student) {
        studenti.put(student.getNume(), student);
        studentiContestatie.put(student.getNume(), student);
    }

    public List<Student> SortareStudentiDescrescatorMedie() {
        List<Student> studentiList = new ArrayList<>(studenti.values());
        studentiList.sort((s1, s2) -> {
            int val = Double.compare(s2.getMedie(), s1.getMedie());
            if (val == 0)
                return s1.getNume().compareTo(s2.getNume());
            return val;
        });

        return studentiList;
    }

    public void afisareStudentiDescrescatorMedie(String filename) {
        List<Student> studentiSortati = SortareStudentiDescrescatorMedie();

        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filename, true))) {
            fw.write("***\n");
            for (Student student : studentiSortati) {
                String linie = student.getNume() + " - " + student.getMedie();
                fw.write(linie + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void verificaDuplicat(String nume) throws StudentDuplicatException {
        if (studenti.containsKey(nume)) {
            throw new StudentDuplicatException(nume);
        }
    }

    public void adaugaNota(String numeStud, double nota) {
        Student student = studenti.get(numeStud);
        student.setMedie(nota);
    }

    public void adaugaCurs(Curs<?> curs) {
        cursuri.add(curs);
    }

    public void adaugaPreferinta(String nume, List<String> numeCursuri) {
        preferinteStudenti.put(nume, numeCursuri);
    }

    public int gasesteCapacitateCurs(String numeCurs) {
        for (Curs<?> curs : cursuri) {
            if (curs.getNume().equals(numeCurs))
                return curs.getCapacitate();
        }
        return 0;
    }

    public double gasesteMedie(String nume) {
        if (studenti.containsKey(nume)) {
            Student student = studenti.get(nume);
            return student.getMedie();
        }
        return 0;
    }

    private double gasesteMedieMinimaLaCurs(String numeCurs) {
        List<String> contentvect = repartizareCursuriStudenti.get(numeCurs);
        double mediemin = Double.MAX_VALUE;
        for (String student : contentvect) {
            double medieStudent = gasesteMedie(student);
            if (medieStudent < mediemin) {
                mediemin = medieStudent;
            }
        }
        return mediemin;
    }

    public void repartizeaza() {
        for (Curs<?> curs : cursuri) {
            String numeCurs = curs.getNume();
            List<String> contentvect = new ArrayList<>();
            repartizareCursuriStudenti.put(numeCurs, contentvect);
        }
        List<Map.Entry<String, List<String>>> preferinteSortate = new ArrayList<>(preferinteStudenti.entrySet());
        preferinteSortate.sort(Comparator
                .comparingDouble(entry -> gasesteMedie(((Entry<String, List<String>>) entry).getKey())).reversed());
        for (Map.Entry<String, List<String>> entry : preferinteSortate) {
            String numeStudent = entry.getKey();
            List<String> preferinteStudent = entry.getValue();
            boolean studentAdaugat = false;
            for (String preferinta : preferinteStudent) {
                List<String> contentvect = repartizareCursuriStudenti.get(preferinta);
                if (contentvect.size() < gasesteCapacitateCurs(preferinta)
                        || gasesteMedieMinimaLaCurs(preferinta) == gasesteMedie(numeStudent)) {
                    contentvect.add(numeStudent);
                    studentAdaugat = true;
                    break; 
                }
            }

            // daca studentul nu a fost adaugat la niciun curs, il adaug la cursul cu cea mai mica medie minima
            if (!studentAdaugat) {
                String cursMinMedie = gasesteCursCuMinimaMedie();
                repartizareCursuriStudenti.get(cursMinMedie).add(numeStudent);
            }
        }
    }

    private String gasesteCursCuMinimaMedie() {
        double medieMinima = Double.MAX_VALUE;
        String cursMinMedie = "";
        for (String numeCurs : repartizareCursuriStudenti.keySet()) {
            double medieCurs = gasesteMedieMinimaLaCurs(numeCurs);
            if (medieCurs < medieMinima) {
                medieMinima = medieCurs;
                cursMinMedie = numeCurs;
            }
        }
        return cursMinMedie;
    }

    public void posteazaCurs(String numeCurs, String numeFisier) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(numeFisier, true))) {
            if (repartizareCursuriStudenti.containsKey(numeCurs)) {
                List<String> studentiRepartizati = repartizareCursuriStudenti.get(numeCurs);
                // sortare alfabetica
                Collections.sort(studentiRepartizati);
                fw.write("***\n");
                fw.write(numeCurs + " (" + gasesteCapacitateCurs(numeCurs) + ")\n");
                for (String numeStudent : studentiRepartizati) {
                    double medieStudent = gasesteMedie(numeStudent);
                    fw.write(numeStudent + " - " + medieStudent + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stergeContinutColectii() {
        studenti.clear();
        studentiContestatie.clear();
        cursuri.clear();
        preferinteStudenti.clear();
        repartizareCursuriStudenti.clear();

    }

    public void afiseazaInFisierStudent(String numeStudent, String numeFisier) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(numeFisier, true))) {
            fw.write("***\n");
            if (studenti.containsKey(numeStudent)) {
                Student student = studenti.get(numeStudent);
                String tipStudent = null;
                if(student instanceof StudentLicenta) 
                    tipStudent = "Licenta" ;
                else 
                    tipStudent = "Master";
                String numeCurs = gasesteCursStudent(numeStudent);
                fw.write("Student " + tipStudent + ": " + student.getNume() + " - " +
                        student.getMedie() + " - " + numeCurs + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String gasesteCursStudent(String numeStudent) {
        for (Map.Entry<String, List<String>> entry : repartizareCursuriStudenti.entrySet()) {
            String numeCurs = entry.getKey();
            List<String> studentiRepartizati = entry.getValue();
            if (studentiRepartizati.contains(numeStudent)) {
                return numeCurs;
            }
        }
        return "nerepartizat";
    }

}
