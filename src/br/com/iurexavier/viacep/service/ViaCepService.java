package br.com.iurexavier.viacep.service;

import br.com.iurexavier.viacep.exception.InvalidCepException;
import br.com.iurexavier.viacep.model.Address;
import br.com.iurexavier.viacep.model.AddressRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ViaCepService {
    private static final String BASE_URL = "https://viacep.com.br/ws/";
    private final HttpClient client;
    private final Gson gson;

    public ViaCepService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public Address searchByCep(String cep) throws IOException, InterruptedException {
        String normalizedCep = normalizeCep(cep);
        validateCepFormat(normalizedCep);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + normalizedCep + "/json/"))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        AddressRecord record = gson.fromJson(response.body(), AddressRecord.class);

        if (record == null || record.cep() == null) {
            throw new InvalidCepException("CEP não encontrado.");
        }

        return new Address(record);
    }

    public List<Address> searchByStreet(String uf, String city, String street) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + uf + "/" + city.replace(" ", "+")
                        + "/" + street.replace(" ", "+") + "/json/"))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        AddressRecord[] records =
                gson.fromJson(response.body(), AddressRecord[].class);

        if (records == null || records.length == 0) {
            throw new InvalidCepException("Nenhum endereço encontrado.");
        }

        //return gson.toJson(records);

        return Arrays.stream(records)
                .map(Address::new)
                .collect(Collectors.toList());
    }

    private String normalizeCep(String cep) {
        if (cep == null) {
            throw new InvalidCepException("CEP não pode ser nulo.");
        }
        return cep.replaceAll("[^0-9]", "");
    }

    private void validateCepFormat(String cep) {
        if (!cep.matches("\\d{8}")) {
            throw new InvalidCepException("CEP deve conter exatamente 8 dígitos numéricos.");
        }
    }
}
