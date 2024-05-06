import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarFuncionario(scanner, funcionarios);
                    break;
                case 2:
                    removerFuncionario(scanner, funcionarios);
                    break;
                case 3:
                    listarFuncionarios(funcionarios);
                    break;
                case 4:
                    buscarFuncionario(scanner, funcionarios);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Menu de opções
    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Gerenciamento de Funcionários ===");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Buscar Funcionário por Nome ou Matrícula");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para adicionar funcionário
    private static void adicionarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        System.out.println("\nEscolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Equipe sob gerência: ");
                String equipe = scanner.nextLine();
                System.out.print("Bônus Anual: ");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine();
                funcionarios.add(new Gerente(nome, matricula, equipe, bonusAnual));
                break;
            case 2:
                System.out.print("Quais tecnologias você domina? (separadas por vírgula): ");
                String[] tecnologias = scanner.nextLine().split(",");
                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.print("Horas trabalhadas (Mensais): ");
                int horasTrabalhadas = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Supervisor: ");
                String supervisor = scanner.nextLine();
                funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("Funcionário adicionado com sucesso!");
    }

    // Método para remover funcionário
    private static void removerFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        System.out.print("\nDigite a matrícula do funcionário a ser removido: ");
        int matricula = scanner.nextInt();
        boolean removido = false;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.matricula == matricula) {
                funcionarios.remove(funcionario);
                removido = true;
                break;
            }
        }

        if (removido) {
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para listar funcionários com seus salários
    private static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        System.out.println("\n=== Lista de Funcionários ===");
        for (Funcionario funcionario : funcionarios) {
            double salario = funcionario.calcularSalario();
            System.out.println(funcionario.nome + " - " + funcionario.cargo + " - Salário: R$" + salario);
        }
    }

    // Método para buscar funcionário
    private static void buscarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        System.out.print("\nDigite o nome ou a matrícula do funcionário: ");
        String busca = scanner.nextLine();
        boolean encontrado = false;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.nome.equalsIgnoreCase(busca) || Integer.toString(funcionario.matricula).equals(busca)) {
                System.out.println("Funcionário encontrado:");
                double salario = funcionario.calcularSalario();
                System.out.println(funcionario.nome + " - " + funcionario.cargo + " - Salário: R$" + salario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
