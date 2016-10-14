package model;

public class Pokemon {
    private int pokemonID;
    private String pokemonName;
    private String pokemonType;
    private double weight;
    private double height;
    private int CP;

    public Pokemon() {
        this.pokemonID = 0;
        this.pokemonName = "";
        this.pokemonType = "";
        this.weight = 0;
        this.height = 0;
        this.CP = 0;
    }
    
    public Pokemon(int pokemonID, String pokemonName, String pokemonType, double weight, double height, int CP) {
        this.pokemonID = pokemonID;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.weight = weight;
        this.height = height;
        this.CP = CP;
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "pokemonID=" + pokemonID + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType + ", weight=" + weight + ", height=" + height + ", CP=" + CP + '}';
    }
    
    
    
}
