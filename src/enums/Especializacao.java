package enums;

public enum Especializacao {

    CARDIOLOGISTA("cardiologista"),
    ACUPUNTURA("acupuntura"),
    CIRURGIAO_PLASTICO("cirurgiao plastico"),
    OTORRINOLARINGOLOGISTA("otorrinolaringologista"),
    OFTALMOLOGISTA("oftalmologista"),
    GINECOLOGISTA("ginecologista");

    private String nome;

    private Especializacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
