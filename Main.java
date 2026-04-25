import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    MenuInicial();
  }
  
  public static void MenuInicial(){
    Scanner input = new Scanner(System.in);
    boolean _continue = true; //DEFINE VARIAVEL PARA ENCERRAR O WHILE
    
    do {
        System.out.println("------------ ConnectArt ------------");
        System.out.println("SELECIONE UMA DAS OPÇÕES A SEGUIR:  ");
        System.out.println("0 - CADASTRO ");
        System.out.println("1 - LOGIN ");
        System.out.println("2 - FINALIZAR ");
        
        var inputValue = input.nextInt(); //RECEBE O VALOR DIGITADO
        
        switch (inputValue) {
            case 0:  MenuCadastro(); break;
        }
        
    } while(_continue);

    input.close();
  }
  
  public static void MenuCadastro() {
    Scanner input = new Scanner(System.in);
    boolean _continue = true; //DEFINE VARIAVEL PARA ENCERRAR O WHILE
    
    do {
        System.out.println("------------ ConnectArt ------------");
        System.out.println("************* CADASTRO *************");
        System.out.println("SELECIONE UMA DAS OPÇÕES A SEGUIR: ");
        System.out.println("0 - CADASTRO PROFESSOR");
        System.out.println("1 - CADASTRO ALUNO");
        System.out.println("9 - VOLTAR");

        var inputValue = input.nextInt(); //RECEBE O VALOR DIGITADO
        
        switch(inputValue) {
            case 0: Cadastro('P');
            case 9: MenuInicial(); break;
        }
    } while(_continue);

    input.close();
  }

  public static void Cadastro(char type) {
    Scanner input = new Scanner(System.in);
    boolean _continue = true;
    do {
    System.out.println("------------ ConnectArt ------------");
    System.out.println("INSIRA O NOME DE USUÁRIO:           ");
    String username = input.nextLine();
    if(username.length < 3)

    System.out.println("INSIRA A SENHA:                     ");
    String password = input.nextLine();
    System.out.println("CONFIRME A SENHA:                     ");
    String repeatPassword = input.nextLine();
    } while(_continue);
    input.close();
  }
}
