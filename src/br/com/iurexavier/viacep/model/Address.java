package br.com.iurexavier.viacep.model;

public class Address {
    private final String cep;
    private final String street;
    private final String neighborhood;
    private final String city;
    private final String uf;

    public Address(String cep, String street, String neighborhood, String city, String uf) {
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.uf = uf;
    }

    public Address(AddressRecord addressRecord) {
        this.cep = addressRecord.cep();
        this.street = addressRecord.logradouro();
        this.neighborhood = addressRecord.bairro();
        this.city = addressRecord.localidade();
        this.uf = addressRecord.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return this.street + ", " + this.neighborhood + " - " + this.city + ", "
                + this.uf + " (" + this.cep + ")";
    }
}
