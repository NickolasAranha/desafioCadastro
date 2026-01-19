package services;
import application.Program;
import exceptions.PetException;
import model.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CadastrarPet {
    public static final Scanner sc = new Scanner(System.in);
    public static void cadastrarPet() {
        List<String> perguntas = new ArrayList<>();
        InputStream caminhoPerguntas = Program.class.getResourceAsStream("/archives/cadastro.txt");
        //Procurei uma forma de "modularizar o lugar do arquivo de forma que não funcione só no meu pc e acabei vendo esse jeito
        try (BufferedReader br = new BufferedReader(new InputStreamReader(caminhoPerguntas))) {

            /* Passei 1 hora tentando descobrir um metodo que eu pudesse ler as perguntas um por uma para
            separar e ler uma por uma e recebendo o valor certo no objeto, mas por enquanto parece impossível no console
             */

            String linha = br.readLine();
            while (linha != null) {
                perguntas.add(linha);
                linha = br.readLine();
            }

            System.out.print(perguntas.getFirst() + " ");
            String name = sc.nextLine();
            Pet pet = new Pet(name);

            System.out.print(perguntas.get(1) + " ");
            String typeString = sc.nextLine().toLowerCase();
            pet.setType(Pet.typeEnum.valueOf(typeString));

            System.out.print(perguntas.get(2) + " ");
            String sexString = sc.nextLine().toLowerCase();
            pet.setSex(Pet.sexEnum.valueOf(sexString));

            System.out.println(perguntas.get(3) + " ");
            System.out.print("Número: ");
            String numberHouse = sc.nextLine();
            System.out.print("Cidade: ");
            String city = sc.nextLine();
            System.out.print("Rua: ");
            String road = sc.nextLine();
            pet.setAddress(road, city, numberHouse);
            System.out.println(pet.getAddress());


            System.out.print(perguntas.get(4) + " ");
            String age = sc.nextLine();
            if(!age.isBlank()) {
                pet.setAge(Double.valueOf(age));
            }

            System.out.print(perguntas.get(5) + " ");
            String weight = sc.nextLine();
            if(!weight.isBlank()) {
                pet.setWeight(Double.valueOf(weight));
            }
            System.out.println(perguntas.get(6) + " ");
            String race = sc.nextLine();

            if (race != null) {
                pet.setRace(race);
            }
        } catch (IOException | PetException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
