package services;

import util.Constantes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BuscarPet {

    public static void buscarPet() {
        System.out.println("Escolha o primeiro critério: ");
        System.out.println("1 - Nome, 2 - Raça, 3 - Sexo, 4 - Endereço, 5 - Idade, 6 - Peso, 7 - Raça");
        System.out.print("Critério: ");
        Integer criterio1 = Constantes.sc.nextInt() - 1;
        Constantes.sc.nextLine();
        System.out.print("Dado: ");
        String elemento1 = Constantes.sc.nextLine();

        System.out.println("Você deseja adicionar mais um critério? Digite 'sim' ou 'não'");
        System.out.print("Escolha: ");
        if (Constantes.sc.nextLine().toUpperCase().equals("SIM")) {
            System.out.println();
            System.out.print("Segundo Critério: ");
            Integer criterio2 = Constantes.sc.nextInt() - 1;
            Constantes.sc.nextLine();
            System.out.print("Dado: ");
            String elemento2 = Constantes.sc.nextLine();
            buscarPet(criterio1, elemento1, criterio2, elemento2);
        } else {
            buscarPet(criterio1, elemento1);
        }
    }
    public static void buscarPet(Integer criterio, String elemento) {
        File pasta = new File("petsCadastrados");
        File[] pets = pasta.listFiles();
        Integer contador = 1;
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println(" --------------- LISTA DE PETS:  ---------------");


        for (File arquivo : pets) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                boolean existing = false;
                List<String> texto = Files.readAllLines(arquivo.toPath());
                    if(texto.get(criterio).contains(elemento)) {
                        existing = true;
                    }

                if (existing == true) {
                    System.out.print(contador + " . ");
                    for (String linha : texto) {
                        System.out.print(linha.substring(4) + " - ");
                    }
                    System.out.println();
                    contador++;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        System.out.println(" --------------- Fim da Lista ---------------");
        while (true) {
            System.out.println("Você deseja voltar ao menu? Digite 1 quando quiser");
            if (Constantes.sc.nextInt() == 1) {
                break;
            }
            Constantes.sc.next();
        }
        Constantes.sc.next();
    }

    public static void buscarPet(Integer criterio1, String elemento1, Integer criterio2, String elemento2) {
        File pasta = new File("petsCadastrados");
        File[] pets = pasta.listFiles();
        Integer contador = 1;
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println(" --------------- LISTA DE PETS:  ---------------");

        for (File arquivo : pets) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                boolean existing = false;
                List<String> texto = Files.readAllLines(arquivo.toPath());
                if(texto.get(criterio1).contains(elemento1) && texto.get(criterio2).contains(elemento2)) {
                    existing = true;
                }

                if (existing == true) {
                    System.out.print(contador + " . ");
                    for (String linha : texto) {
                        System.out.print(linha.substring(4) + " - ");
                    }
                    System.out.println();
                    contador++;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        System.out.println(" --------------- Fim da Lista ---------------");
        while (true) {
            System.out.println("Você deseja voltar ao menu? Digite 1 quando quiser");
            if (Constantes.sc.nextInt() == 1) {
                break;
            }
        }
    }
}
