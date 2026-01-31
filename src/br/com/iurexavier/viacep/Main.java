package br.com.iurexavier.viacep;

import br.com.iurexavier.viacep.exception.InvalidCepException;
import br.com.iurexavier.viacep.service.ViaCepService;
import br.com.iurexavier.viacep.util.MenuUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ViaCepService service = new ViaCepService();

        boolean running = true;

        while (running) {
            try {
                int option = MenuUtil.showMainMenu(input);

                switch (option) {
                    case 1 -> MenuUtil.handleCepSearch(input, service);
                    case 2 -> MenuUtil.handleStreetSearch(input, service);
                    case 0 -> {
                        System.out.println("Encerrando aplicação...");
                        running = false;
                    }
                    default -> System.out.println("Opção inválida!");
                }

            } catch (InvalidCepException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao consultar o ViaCEP. Tente novamente mais tarde.");
            }

            System.out.println();
        }

        input.close();
    }
}
