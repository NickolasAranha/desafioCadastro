package services;
import model.Pet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class SalvarPet {
    public static void salvarPet(Pet pet) throws IOException {
        LocalDateTime d = LocalDateTime.now();
        String path = String.valueOf(+ d.getYear() + d.getMonthValue() + d.getDayOfMonth() + "T" + d.getHour() + d.getMinute()
                + pet.getName().replaceAll(" ", "").toUpperCase() + ".txt");
        Path pathArquivo = Paths.get("petsCadastrados", path);
        Files.createDirectories(pathArquivo.getParent());

        try (BufferedWriter bw = Files.newBufferedWriter(pathArquivo))  {
            bw.write("1 - " + primeiraLetraMaiuscula(pet.getName()));
            bw.newLine();
            bw.write("2 - " + primeiraLetraMaiuscula(String.valueOf(pet.getType())));
            bw.newLine();
            bw.write("3 - " + primeiraLetraMaiuscula(String.valueOf(pet.getSex())));
            bw.newLine();
            bw.write("4 - " + pet.getAddress());
            bw.newLine();
            if (pet.getAge() < 1) {
                bw.write("5 - " + pet.getAge() + " anos");
            } else {
                bw.write("5 - " + pet.getAge().intValue() + " anos");
            }
            bw.newLine();
            bw.write("6 - " + pet.getWeight() + " kg");
            bw.newLine();
            bw.write("7 - " + primeiraLetraMaiuscula(pet.getRace()));
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static String primeiraLetraMaiuscula(String palavra) {
        return  palavra.substring(0,1).toUpperCase() + palavra.substring(1);
    }
}
