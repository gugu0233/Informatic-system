package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Secretariat secretariat = new Secretariat();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/01-posteaza_medii/01-posteaza_medii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/01-posteaza_medii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        // Separăm elementele notei
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/01-posteaza_medii/01-posteaza_medii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/02-posteaza_medii_contestatii/02-posteaza_medii_contestatii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/02-posteaza_medii_contestatii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        // Separăm elementele notei
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/02-posteaza_medii_contestatii/02-posteaza_medii_contestatii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/03-posteaza_medii_contestatii/03-posteaza_medii_contestatii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/03-posteaza_medii_contestatii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/03-posteaza_medii_contestatii/03-posteaza_medii_contestatii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/04-posteaza_medii_contestatii/04-posteaza_medii_contestatii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/04-posteaza_medii_contestatii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/04-posteaza_medii_contestatii/04-posteaza_medii_contestatii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays
                                .asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/05-inroleaza_simplu";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/05-inroleaza_simplu/05-inroleaza_simplu.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays
                                .asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/06-inroleaza_ciclu_studii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/06-inroleaza_ciclu_studii/06-inroleaza_ciclu_studii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays.asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/07-inroleaza_ciclu_studii_contestatii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie(
                                "src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/07-inroleaza_ciclu_studii_contestatii/07-inroleaza_ciclu_studii_contestatii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/08-coliziuni_medie/08-coliziuni_medie.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays.asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/08-coliziuni_medie";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/08-coliziuni_medie/08-coliziuni_medie.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume, "src/main/resources/08-coliziuni_medie/08-coliziuni_medie.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/08-coliziuni_medie/08-coliziuni_medie.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays
                                .asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/09-coliziuni_ciclu_studii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/09-coliziuni_ciclu_studii/09-coliziuni_ciclu_studii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays
                                .asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/10-coliziuni_ciclu_studii_contestatii";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/10-coliziuni_ciclu_studii_contestatii/10-coliziuni_ciclu_studii_contestatii.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/11-exceptie_simplu/11-exceptie_simplu.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            try (BufferedWriter fw = new BufferedWriter(new FileWriter("src/main/resources/11-exceptie_simplu/11-exceptie_simplu.out", true))) {
                                fw.write("***\n");
                                fw.write(e.getMessage());
                                fw.write("\n");
                            }
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/11-exceptie_simplu";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/11-exceptie_simplu/11-exceptie_simplu.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.in"))) {
            secretariat.stergeContinutColectii();
            String linie;
            while ((linie = br.readLine()) != null) {
                // separ elementele comenzii dupa -
                String[] elementeComanda = linie.split(" - ");
                if (elementeComanda.length >= 3) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_student")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        try {
                            if (tip.equals("master")) {
                                StudentMaster stud = secretariat.creazaStudMaster(nume);
                                secretariat.adaugaStudent(stud);
                            } else if (tip.equals("licenta")) {
                                StudentLicenta stud = secretariat.creazaStudLicenta(nume);
                                secretariat.adaugaStudent(stud);
                            }
                        } catch (StudentDuplicatException e) {
                            try (BufferedWriter fw = new BufferedWriter(new FileWriter("src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.out", true))) {
                                fw.write("***\n");
                                fw.write(e.getMessage());
                                fw.write("\n");
                            }
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    } else if (comanda.equals("adauga_preferinte")) {
                        String nume = elementeComanda[1];
                        List<String> numeCursuri = Arrays.asList(Arrays.copyOfRange(elementeComanda, 2, elementeComanda.length));
                        secretariat.adaugaPreferinta(nume, numeCursuri);
                    }
                } else if (elementeComanda.length == 1) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("citeste_mediile")) {
                        String directorNote = "src/main/resources/12-toate_functionalitatile";
                        File director = new File(directorNote);
                        File[] fisiere = director.listFiles((dir, numeFisier) -> numeFisier.startsWith("note_"));
                        if (fisiere != null) {
                            for (File fisier : fisiere) {
                                try (BufferedReader br1 = new BufferedReader(new FileReader(fisier))) {
                                    String linie1;
                                    while ((linie1 = br1.readLine()) != null) {
                                        String[] elementeNota = linie1.split(" - ");
                                        String numeStudent = elementeNota[0];
                                        double nota = Double.parseDouble(elementeNota[1]);
                                        secretariat.adaugaNota(numeStudent, nota);
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    if (comanda.equals("posteaza_mediile")) {
                        secretariat.afisareStudentiDescrescatorMedie("src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.out");
                    } else if (comanda.equals("repartizeaza")) {
                        secretariat.repartizeaza();
                    }
                }
                if (elementeComanda.length == 4) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("adauga_curs")) {
                        String tip = elementeComanda[1];
                        String nume = elementeComanda[2];
                        int capacitate = Integer.parseInt(elementeComanda[3]);
                        if (tip.equals("master")) {
                            Curs<StudentMaster> cursMaster = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursMaster);
                        } else if (tip.equals("licenta")) {
                            Curs<StudentLicenta> cursLicenta = new Curs<>(nume, capacitate);
                            secretariat.adaugaCurs(cursLicenta);
                        }
                    } else if (comanda.equals("contestatie")) {
                        String nume = elementeComanda[1];
                        double notaNoua = Double.parseDouble(elementeComanda[2]);
                        secretariat.adaugaNota(nume, notaNoua);
                    }
                }
                if (elementeComanda.length == 2) {
                    String comanda = elementeComanda[0];
                    if (comanda.equals("posteaza_curs")) {
                        String nume = elementeComanda[1];
                        secretariat.posteazaCurs(nume,"src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.out");
                    } else if (comanda.equals("posteaza_student")) {
                        String nume = elementeComanda[1];
                        secretariat.afiseazaInFisierStudent(nume,"src/main/resources/12-toate_functionalitatile/12-toate_functionalitatile.out");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
