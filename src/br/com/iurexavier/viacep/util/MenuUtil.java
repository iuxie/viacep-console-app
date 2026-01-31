package br.com.iurexavier.viacep.util;

import java.util.Scanner;

public class MenuUtil {

    public static void showMainMenu() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("== AdressFinder - ViaCEP ==");
            System.out.println("1. Consultar endereço por CEP");
            System.out.println("2. Consultar endereço pela rua");
            System.out.print("Escolha uma opção: ");

            int option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Opção buscar por CEP selecionada!");
                    break;
                case 2:
                    System.out.println("Opção buscar por endereço selecionada!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!");
        }
    }
}
