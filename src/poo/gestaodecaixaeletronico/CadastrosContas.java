package poo.gestaodecaixaeletronico;

import poo.gestaodecontas.Contas;

public class CadastrosContas {
    private final Contas[] contas;
    private int numeroDeContas;

    public CadastrosContas(int numeroDeContas) {
        this.contas = new Contas[numeroDeContas];
    }

    public boolean adicionaConta(Contas conta) {
        if (this.numeroDeContas == this.contas.length |
                this.buscaConta(conta.getNumero()) != null) {
            return false;
        }
        this.contas[this.numeroDeContas++] = conta;
        return true;
    }

    public Contas buscaConta(int numero) {
        for (int i = 0; i < this.numeroDeContas; i++) {
            if (numero == this.contas[i].getNumero()) {
                return this.contas[i];
            }
        }
        return null;
    }
}