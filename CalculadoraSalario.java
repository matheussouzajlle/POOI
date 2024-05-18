import java.util.Scanner;

class Funcionario {
    String nome;
    double valorHora;
    double horasTrabalhadas;

    public Funcionario(String nome, double valorHora, double horasTrabalhadas) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularSalario() {
        return valorHora * horasTrabalhadas;
    }
}

class Lider extends Funcionario {
    public Lider(String nome, double valorHora, double horasTrabalhadas) {
        super(nome, valorHora, horasTrabalhadas);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 1.02; // Incrementa 2% para líderes
    }

}

class Gerente extends Funcionario {
    public Gerente(String nome, double valorHora, double horasTrabalhadas) {
        super(nome, valorHora, horasTrabalhadas);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 1.05; // Incrementa 5% para gerentes
    }
}

public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Informe o valor da hora trabalhada:");
        double valorHora = scanner.nextDouble();

        System.out.println("Informe a quantidade de horas trabalhadas no mês:");
        double horasTrabalhadas = scanner.nextDouble();

        System.out.println("Informe o cargo (funcionario, lider ou gerente):");
        String cargo = scanner.next();

        Funcionario funcionario;

        if (cargo.equalsIgnoreCase("lider")) {
            funcionario = new Lider(nome, valorHora, horasTrabalhadas);
        } else if (cargo.equalsIgnoreCase("gerente")) {
            funcionario = new Gerente(nome, valorHora, horasTrabalhadas);
        } else {
            funcionario = new Funcionario(nome, valorHora, horasTrabalhadas);
        }

        double salario = funcionario.calcularSalario();

        System.out.println("O salário do funcionário " + funcionario.nome + " é: R$" + salario);

        scanner.close();
    }
}