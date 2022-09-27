package enums;

public enum TipoExames {
    HEMOGRAMA("hemograma"),
    PAPANICOLAU("papanicolau"),
    URINA("urina"),
    FEZES("fezes"),
    COLESTEROL("colesterol"),
    SANGUE("sangue");
    
    private String nome;

    private TipoExames(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
