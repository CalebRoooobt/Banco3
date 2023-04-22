package poo.gestaodecaixaeletronico;

import poo.gestaodecontas.Contas;

public class Caixa {
    private Terminal meuTerminal;
    private CadastrosContas bdContas;
    private double saldo;
    public Caixa(Terminal terminal, CadastrosContas bd){
        this.meuTerminal = terminal;
        this.bdContas = bd;
    }
    public double consultasSaldo(int numeroDaConta, int senha){
        Contas contas;
        contas = this.bdContas.buscaConta(numeroDaConta);
        if(contas != null){
            return contas.verificaSaldo(senha);
        }
        else{
            return -1;
        }
    }
    public boolean efetuaSaque(int numeroDaConta,double valor, int senha){
        if(valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldo){
            return false;
        }
        Contas conta = bdContas.buscaConta(numeroDaConta);
        if(conta == null || !conta.debitaValor(valor,senha,"Saque Automatico")){
            return false;
        }
        this.liberaCedulas((int)(valor/50));
        this.saldo -= valor;
        if(this.saldo < 500){
            this.meuTerminal.setModo(0);
        }
        return true;
    }
    public void recarrega(){
        this.saldo = 2000;
        this.meuTerminal.setModo(1);
    }
    private void liberaCedulas(int quantidade){
        while(quantidade -- > 0){
            System.out.println("===/R$50,00 / ===");

        }
    }
}
