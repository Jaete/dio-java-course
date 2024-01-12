package BankAccount;
import java.util.Scanner;

public class BankAccount {

    private String client_name;
    private int account_number;
    private String branch_number;
    private float balance;
    private Scanner scan = new Scanner(System.in);

    public void create_account(){
        System.out.print("Olá, seja bem vindo ao Banco!\n" +
        "\nComece criando sua conta:\n" +
        "Insira o seu nome:\n");
        client_name = scan.nextLine();
        System.out.print("\n\nAgora que temos o seu nome, por favor insira o número da sua agência:\n");
        branch_number = scan.nextLine();
        System.out.print("\n\nAgora que temos a sua agência, insira o número da conta bancária:\n");
        account_number = scan.nextInt();
        System.out.print("\n\nSomos um banco mágico. Portanto, escolha com quanto dinheiro irá começar em sua conta:\n");
        balance = scan.nextFloat();
        System.out.printf("\n\nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %f já está disponível para saque\n\n", client_name, branch_number, account_number, balance);
    }

    public boolean menu(){
        System.out.print("O que deseja fazer em sua nova conta? \n1 - Sacar \n2- Depositar\n");
        int choice = scan.nextInt();
        if(choice == 1){
            withdraw();
        }else{
            deposit();
        }
        System.out.print("Continuar operações?\n1 - Sim \n2 - Não");
        choice = scan.nextInt();
        if(choice == 1){
            return true;
        }
        return false;
    }

    public void withdraw(){
        System.out.print("\n\n Quanto deseja sacar?\n");
        float amount = scan.nextFloat();
        if (amount > balance){
            System.out.print("\n\nVocê não tem saldo suficiente.\n\n");
        }else{
            balance -= amount;
            System.out.printf("\n\nSaque concluido! Seu novo saldo é de %f\n\n", balance);
        }
    }

    public void deposit(){
        System.out.print("\n\n Quanto deseja depositar?\n");
        float amount = scan.nextFloat();
            balance += amount;
            System.out.printf("\n\nDepósito concluido! Seu novo saldo é de %f\n\n", balance);
    }

    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        bank.create_account();
        boolean operate = true;
        while(operate == true){
            operate = bank.menu();
        }
        System.out.print("Encerrando operações!");
        System.out.print("Até a próxima!");
    }
}
