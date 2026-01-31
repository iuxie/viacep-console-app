package br.com.iurexavier.viacep.util;

import br.com.iurexavier.viacep.model.Address;
import br.com.iurexavier.viacep.service.ViaCepService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuUtil {

    public static int showMainMenu(Scanner input) {
        System.out.println("== AddressFinder - ViaCEP ==");
        System.out.println("1. Consultar endereço por CEP");
        System.out.println("2. Consultar endereço pela rua");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        return Integer.parseInt(input.nextLine());
    }

    public static void handleCepSearch(Scanner input, ViaCepService service)
            throws IOException, InterruptedException {

        System.out.print("Informe o CEP: ");
        String cep = input.nextLine();

        Address address = service.searchByCep(cep);

        System.out.println("\nResultado:");
        System.out.println(address);
    }

    public static void handleStreetSearch(Scanner input, ViaCepService service)
            throws IOException, InterruptedException {

        System.out.print("Informe o estado (UF): ");
        String uf = input.nextLine();

        System.out.print("Informe a cidade: ");
        String city = input.nextLine();

        System.out.print("Informe a rua: ");
        String street = input.nextLine();

        List<Address> addresses = service.searchByStreet(uf, city, street);

        System.out.println("\nResultados:");
        for (Address address : addresses) {
            System.out.println("- " + address);
        }
    }
}
