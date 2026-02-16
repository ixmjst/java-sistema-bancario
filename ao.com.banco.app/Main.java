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
                System.out.println("");

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
