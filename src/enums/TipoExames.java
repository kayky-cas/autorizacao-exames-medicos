package enums;

public enum TipoExames {
    HEMOGRAMA("Hemograma"),
    PAPANICOLAU("Papanicolau"),
    URINA("Urina"),
    FEZES("Fezes"),
    COLESTEROL("Colesterol"),
    SANGUE("Sangue"),
    GLICEMIA("Glicemia"),
    TRANSAMINASES("Transaminases"),
    TSH("TSH"),
    UREAIA("Ureia");

    private final String nome;

    TipoExames(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
