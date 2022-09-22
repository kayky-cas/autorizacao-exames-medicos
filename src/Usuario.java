public abstract class Usuario {
    private static int currentId = 0;

    private int id;
    private String nome;

    public Usuario(String nome) {
        id = currentId++;
        this.nome = nome;
    }
}
