import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Banco> listaBancos = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();

    private Conta contaCorrente = new ContaCorrente();
    private Conta contaPoupanca = new ContaPoupanca();

    public void exibirMenu() {

        System.out.println("\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|            Operacoes Bancarias            |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 01 - Cadastrar Banco                      |");
        System.out.println("| 02 - Cadastrar Cliente                    |");
        System.out.println("| 03 - Operacoes Conta Corrente             |");
        System.out.println("| 04 - Operacoes Conta Poupanca             |");
        System.out.println("|                                           |");
        System.out.println("| 05 - Listar Bancos                        |");
        System.out.println("| 06 - Listar Clientes                      |");
        System.out.println("|                                           |");
        System.out.println("| 09 - Sair                                 |");
        System.out.println("+-------------------------------------------+");
    }

    public void cadastrarBanco() throws InterruptedException {

        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do Banco: ");
        banco.setNome(sc.nextLine());

        System.out.print("Agência do Banco: ");
        banco.setAgencia(sc.nextInt());

        listaBancos.add(banco);

        System.out.println("\nBanco Cadastrado com Sucesso");

        Thread.sleep(3 * 1000);

    }

    public void cadastrarCliente() throws InterruptedException {

        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do Cliente: ");
        cliente.setNome(sc.nextLine());

        System.out.print("Digite o Banco do Cliente: ");
        cliente.setBanco(sc.nextLine());

        listaClientes.add(cliente);

        System.out.println("\nCliente Cadastrado com Sucesso");

        Thread.sleep(3 * 1000);
    }

    public void operacaoContaCorrente() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|      Menu de Opções - Conta Corrente      |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 01 - Depositar                            |");
        System.out.println("| 02 - Sacar                                |");
        System.out.println("| 03 - Transferir para Poupanca             |");
        System.out.println("| 04 - Extrato                              |");
        System.out.println("|                                           |");
        System.out.println("| 09 - Sair                                 |");
        System.out.println("+-------------------------------------------+");

        System.out.print("Digite a Opcao: ");
        int opcao = sc.nextInt();
        double valor;

        switch (opcao) {

            case 1:

                System.out.print("Valor a ser depositado: ");
                valor = sc.nextDouble();

                contaCorrente.depositar(valor);

                System.out.print("\nDeposito realizado com sucesso");

                Thread.sleep(3 * 1000);

                break;

            case 2:

                System.out.print("Valor do Saque: ");
                valor = sc.nextDouble();

                contaCorrente.sacar(valor);

                Thread.sleep(3 * 1000);

                break;

            case 3:

                System.out.print("Valor da Transferencia: ");
                valor = sc.nextDouble();

                contaCorrente.transferir(valor, contaPoupanca);

                Thread.sleep(3 * 1000);

                break;

            case 4:

                contaCorrente.extrato();

                Thread.sleep(3 * 1000);

                break;

            default:

                exibirMenu();
        }

    }

    public void operacaoContaPoupanca() throws InterruptedException {

        System.out.println("\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|      Menu de Opções - Conta Poupanca      |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 01 - Depositar                            |");
        System.out.println("| 02 - Sacar                                |");
        System.out.println("| 03 - Transferir para Conta Corrente       |");
        System.out.println("| 04 - Extrato                              |");
        System.out.println("|                                           |");
        System.out.println("| 09 - Sair                                 |");
        System.out.println("+-------------------------------------------+");

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a Opcao: ");
        int opcao = sc.nextInt();
        double valor;

        switch (opcao) {

            case 1:

                System.out.print("Valor a ser depositado: ");
                valor = sc.nextDouble();

                contaPoupanca.depositar(valor);

                System.out.print("\nDeposito realizado com sucesso");

                Thread.sleep(3 * 1000);

                break;

            case 2:

                System.out.print("Valor do Saque: ");
                valor = sc.nextDouble();

                contaPoupanca.sacar(valor);

                Thread.sleep(3 * 1000);

                break;

            case 3:

                System.out.print("Valor da Transferencia: ");
                valor = sc.nextDouble();

                contaPoupanca.transferir(valor, contaCorrente);

                Thread.sleep(3 * 1000);

                break;

            case 4:

                contaPoupanca.extrato();

                Thread.sleep(3 * 1000);

                break;

            default:

                exibirMenu();
        }


    }

    public void listarCliente() throws InterruptedException {

        System.out.println("\n\n*****  Clientes Cadastrados: *****");
        for (Cliente cliente : listaClientes) {
            System.out.println("\nNome: " + cliente.getNome());
            System.out.println("Banco: " + cliente.getBanco());
        }
        Thread.sleep(5 * 1000);
    }

    public void listarBanco () throws InterruptedException {

        System.out.println("\n\n*****  Bancos Cadastrados: *****");
        for (Banco banco : listaBancos) {
            System.out.println("\nNome: " + banco.getNome());
            System.out.println("Agência: " + banco.getAgencia());
        }

        Thread.sleep(5 * 1000);
    }
}
