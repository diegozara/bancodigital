public abstract class Conta implements IConta {

    private int agencia;
    private int numero;
    private double saldo;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta (){

        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL ++;
    }

    @Override
    public void sacar(double valor) {

        if (valor > saldo) {

            System.out.println("\n*** Operacao não realizada, saldo insuficiente ***");
            System.out.println("Saldo disponível: " + saldo);

        } else {
            saldo -= valor;
            System.out.println("\nOperacao realizada com sucesso");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void extrato (){

        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
