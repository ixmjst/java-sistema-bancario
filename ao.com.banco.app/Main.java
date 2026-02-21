import ao.com.banco.service.BancoService;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Scanner ler = new Scanner(System.in);
    int esc = 0;
try{
    do {
        System.out.println("Menu:");
        System.out.println("1-Aderir Servicos Bancarios");
        System.out.println("2-Aderir Servicos de Cliente");
        System.out.println("3-Sair(0)");
        esc = ler.nextInt();

        switch (esc) {
            case 1:
                ler.nextLine();
                BancoService.BancoServiceMenu();
                break;
            case 2:
                System.out.println("Digite o Numero da Conta:");
                int numeroConta=ler.nextInt();
                BancoService.clienteServico(numeroConta);
                break;


        }


    } while (esc != 0);} catch (InputMismatchException e) {
    throw new InputMismatchException("Apenas Valores Numericos");
}


}
