package program;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("============================================================");
        System.out.println("================ Bem vindos ao DIO bank ====================");
        System.out.println("============================================================");
        System.out.println("======== Selecione uma operacao que deseja realizar ========");
        System.out.println("============================================================");
        System.out.println("|   Opcao 1 - Criar conta   |");
        System.out.println("|   Opcao 2 - Depositar     |");
        System.out.println("|   Opcao 3 - Sacar         |");
        System.out.println("|   Opcao 4 - Transferir    |");
        System.out.println("|   Opcao 5 - Listar        |");
        System.out.println("|   Opcao 6 - Sair          |");

        int operacao = input.nextInt();

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigado por acessar nosso banco");
                System.exit(0);
            default:
                System.out.println("Opcao invalida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");

        operacoes();
    }

    private static Conta encontraConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumConta() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontraConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual o valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.deposita(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println(" == Conta nao encontrada! == ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontraConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println(" == Conta nao encontrada! == ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da conta origem: ");
        int numeroContaOrigem = input.nextInt();

        Conta contaOrigem = encontraConta(numeroContaOrigem);

        if(contaOrigem != null) {
            System.out.println("Numero da conta destinatario: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontraConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Informe o valor a ser transferido: ");
                Double valor = input.nextDouble();

                contaOrigem.transferir(contaDestinatario, valor);
            }
        }
        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }

        } else {
            System.out.println("Nao ha contas cadastradas...");
        }
        operacoes();
    }
}
