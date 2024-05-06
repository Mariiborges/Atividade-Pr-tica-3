interface Trabalhavel {
    void trabalhar();
    void relatarProgresso();
}

abstract class Funcionario implements Trabalhavel {
    protected String nome;
    protected int matricula;
    protected String cargo;

    public Funcionario(String nome, int matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public abstract double calcularSalario();
}
