//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Scanner ler=new Scanner(System.in);
    int esc=0;

    do{
        System.out.println("Menu:");
        System.out.printf("1-Aceder Servicos Bancarios");
        System.out.printf("2.Sair(0)");
        esc=ler.nextInt();

        switch (esc){
            case 1:
                System.out.println("1-Criar Conta");
                System.out.println("2-Mostrar Clientes");
                System.out.println("3-Remover Clientes");
                System.out.println("4-Buscar por Clientes pelo Num. da Conta");
                System.out.println("5-Transferir pelo Num. da Conta");
                System.out.println("(0).sair");
                int op = ler.nextInt();
                if (op == 1) {
                    BancoService.criarConta();
                } else if (op == 2) {
                    BancoService.mostrarClientes();
                } else if (op == 3) {
                    System.out.println("Digite o ID:");
                    int id=ler.nextInt();
                    BancoService.removerCliente(id);
                } else if (op == 4) {
                    System.out.println("Digite o numero da Conta:");
                    int numero=ler.nextInt();
                    BancoService.buscarPorNumero(numero);
                }else if (op == 5){
                    System.out.println("Digite a conta Origem:");
                    int numContaOrigem=ler.nextInt();
                    System.out.println("Digite a contaDestino:");
                    int numContaDestino= ler.nextInt();
                    System.out.println("Digite o valor:");
                    double valor= ler.nextDouble();
                    BancoService.transferirPorNumo(numContaOrigem,numContaDestino,valor);
                }
                else {
                    System.out.println("Opcao Indisponivel");
                }


                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

        }


    }while(esc!=0);


}
