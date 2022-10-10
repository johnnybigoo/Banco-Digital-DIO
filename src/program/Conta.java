package program;

import utilitarios.Utils;

public class Conta {

    private static int conterConta = 1;

    private int numConta;
    private Pessoa pessoa;
    private Double saldo = 0.00;

    public Conta(Pessoa pessoa) {
        this.numConta = conterConta;
        this.pessoa = pessoa;
        conterConta += 1;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "Numero Conta:" + this.getNumConta() +
                ", Nome:" + this.pessoa.getNome() +
                ", CPF:" + this.pessoa.getCPF() +
                ", Email:" + this.pessoa.getEmail() +
                ", Saldo:" + Utils.doubleToString(this.getSaldo()) +
                '}';
    }

    public void deposita(Double value) {
        if (value > 0) {
            setSaldo(getSaldo() + value);
            System.out.println("Deposito foi realizado com sucesso!");
        } else {
            System.out.println("Nao foi possivel realizar o deposito :(");
        }
    }

    public void sacar(Double value) {
        if (value > 0 & this.getSaldo() >= value) {
            setSaldo(getSaldo() - value);
            System.out.println("Saque foi realizado com sucesso!");
        } else {
            System.out.println("Nao foi possivel realizar o saque..");
        }
    }

    public void transferir(Conta contaparaDeposito, Double value) {
        if (value > 0 & this.getSaldo() >= value) {
            setSaldo(getSaldo() - value);

            contaparaDeposito.saldo = contaparaDeposito.getSaldo() + value;
            System.out.println("Transferencia foi realizado com sucesso!");
        } else {
            System.out.println("Nao foi possivel realizar esta transferencia..");
        }
    }


}
