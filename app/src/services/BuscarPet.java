package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BuscarPet {
    public static void buscarPet(int filter, String elemento1, String elemento2) {
        filter--;
        File pasta = new File("petsCadastrados");
        File[] pets = pasta.listFiles();
        Integer contador = 1;

        for (File arquivo : pets) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                boolean existing = false;
                List<String> texto = Files.readAllLines(arquivo.toPath());
                    if(texto.get(filter).contains(elemento1) || texto.get(filter).contains(elemento2)) {
                        existing = true;
                    }

                if (existing == true) {
                    System.out.print(contador + " . ");
                    for (String linha : texto) {
                        System.out.print(linha + " - ");
                    }
                    System.out.println();
                    contador++;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
