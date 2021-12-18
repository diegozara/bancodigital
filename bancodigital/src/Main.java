import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        int opcao;
        Menu menu = new Menu();

        do{
            menu.exibirMenu();

            System.out.print("Escolha Opcao: ");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    menu.cadastrarBanco();
                    break;
                case 2:
                   menu.cadastrarCliente();
                    break;
                case 3:
                   menu.operacaoContaCorrente();
                    break;
                case 4:
                    menu.operacaoContaPoupanca();
                    break;
                case 5:
                    menu.listarBanco();
                    break;
                case 6:
                    menu.listarCliente();
                    break;
                default:
                    menu.exibirMenu();
            }
        }while(opcao != 9);
    }
}