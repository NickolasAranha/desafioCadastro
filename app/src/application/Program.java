package application;
import services.BuscarPet;
import services.CadastrarPet;
import java.util.Scanner;

import services.SalvarPet;
import util.Constantes;

public class Program {
    public static void main(String[] args) {
            while (true) {
                System.out.printf(
                        "Menu:%n" + "1. Cadastrar novo Pet %n" + "2. Alterar os dados do pet cadastrado%n" +
                                "3. Deletar um pet cadastrado%n" + "4. Listar todos os pets cadastrados%n" +
                                "5. Listar pets por algum critério (idade, nome, raça)%n" + "6. Sair%n");

                System.out.print("Escolha: ");
                String opcao = Constantes.sc.nextLine();

                try {
                    Integer valor = Integer.parseInt(opcao);

                    if (valor <= 0) {
                        throw new NumberFormatException("Deve ser acima de 0");
                    }
                    switch (Integer.parseInt(opcao)) {
                        case 1:
                            CadastrarPet.cadastrarPet();
                            break;
                        case 5:
                            BuscarPet.buscarPet();
                            break;
                        case 6:
                            System.out.println("Você encerrou o programa!");
                            Constantes.sc.close();
                            return;

                        default:
                            System.out.println("Opção inválida!");
                            break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

