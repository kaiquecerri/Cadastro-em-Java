import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    MenuInicial();
  }
  
  public static void MenuInicial(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
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
            case 0:  Cadastro(); break;
        }
        
    } while(_continue);
  }
  
  public static void Cadastro() {
     System.out.print("\033[H\033[2J");
    System.out.flush();
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
            case 9: MenuInicial(); break;
        }
    } while(_continue);
  }
}
