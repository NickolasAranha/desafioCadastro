package model;

import exceptions.PetException;

public class Pet {
    public static enum sexEnum {macho, femea}
    public static enum typeEnum {cachorro, gato};

    private String name;
    private typeEnum type;
    private sexEnum sex;
    private String address;
    private Double age;
    private Double weight;
    private String race;

    public Pet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String rua, String cidade, String numero) {
        if (numero != null) {
            this.address = rua + numero + ", " + cidade;
        } else {
            this.address = rua + " Não Informado, " + cidade;
        }
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) throws PetException {
        if (age > 20) {
            throw new PetException("Idade não pode ser maior do que 20 anos");
        }
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) throws PetException {
        if (weight >= 60.0 | weight < 0.5) {
            throw new PetException("Peso deve ser entre 0.5 e 60kg");
        }
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public typeEnum getType() {
        return type;
    }

    public void setType(typeEnum type) {
        this.type = type;
    }

    public sexEnum getSex() {
        return sex;
    }

    public void setSex(sexEnum sex) {
        this.sex = sex;
    }

}
