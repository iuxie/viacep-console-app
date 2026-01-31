package br.com.iurexavier.viacep.model;

public record AddressRecord(String cep, String logradouro, String bairro,
                            String localidade, String uf) {
}
