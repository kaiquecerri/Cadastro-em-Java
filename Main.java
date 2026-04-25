import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static String users[][] = new String[0][3];
  static Scanner input = new Scanner(System.in);
  public static void main(String args[]) {
    MenuInicial();
  }
  
  public static void MenuInicial(){
    boolean _continue = true; //DEFINE VARIAVEL PARA ENCERRAR O WHILE
    
    do {
        System.out.println("------------ ConnectArt ------------");
        System.out.println("SELECIONE UMA DAS OPÇÕES A SEGUIR:  ");
        System.out.println("1 - CADASTRO ");
        System.out.println("2 - EXIBIR USUARIOS");
        System.out.println("0 - FINALIZAR ");
        
        String inputValue = input.nextLine(); //RECEBE O VALOR DIGITADO
        
        switch (inputValue) {
            case "1": LimparConsole(); MenuCadastro(); break;
            case "2": LimparConsole(); ExibirUsuarios(); break;
            case "0": LimparConsole(); System.exit(0); break;
        }
        
    } while(_continue);

    input.close();
  }
  
  public static void MenuCadastro() {
    boolean _continue = true; //DEFINE VARIAVEL PARA ENCERRAR O WHILE
    
    do {
        System.out.println("------------ ConnectArt ------------");
        System.out.println("************* CADASTRO *************");
        System.out.println("SELECIONE UMA DAS OPÇÕES A SEGUIR: ");
        System.out.println("1 - CADASTRO PROFESSOR");
        System.out.println("2 - CADASTRO ALUNO");
        System.out.println("0 - VOLTAR");

        String inputValue = input.nextLine(); //RECEBE O VALOR DIGITADO
        
        switch(inputValue) {
            case "1": LimparConsole(); Cadastro('P'); break;
            case "2": LimparConsole(); Cadastro('A'); break;
            case "0": LimparConsole(); MenuInicial(); break;
        }
    } while(_continue);

  }

  public static void Cadastro(char type) {
    boolean _continue = true;                                        //DEFINE VARIAVEL PARA ENCERRAR O WHILE
    String username = "";
    String password = "";
    do {                                                             //LOOPING DO NOME DE USUARIO
      System.out.println("INSIRA O NOME DE USUÁRIO:           ");
      username = input.nextLine().toLowerCase();                     //RECEBE O NOME DE USUARIO E DEIXA TUDO MINUSCULO
      boolean usernameExists = false;                                //VARIAVEL PARA VERIFICAR SE O NOME DE USUARIO E UNICO
      if(username.length() < 3) {                                    //TAMANHO MINIMO PARA O NOME DO USUARIO: 3
        LimparConsole();
        System.out.println("O NOME DE USUARIO PRECISA TER PELO MENOS 3 DIGITOS");                                                      //SE NAO TIVER PELO MENOS 3 DE TAMANHO REINICIA O LOOPING
        Esperar(2);
      } else {
        for(int _temp = 0; _temp < users.length; _temp++) {          //VERIFICA SE O NOME JA FOI UTILIZADO PASSANDO PELO ARRAY
          if(users[_temp][0] != null && users[_temp][0].equals(username)) {
            usernameExists = true;
          }
        }

        if(usernameExists) {                                         //SE TIVER SIDO UTILIZADO REINICIA O LOOPING
          LimparConsole();
          System.out.println("ESTE NOME DE USUÁRIO JÁ FOI UTILIZADO");
          Esperar(2);
        } else 
          _continue = false;        
      }
    } while(_continue);


    _continue = true;                                                //REINICIA VARIAVEL PARA ENCERRAR O WHILE
    do {
    System.out.println("INSIRA A SENHA:                     ");
    password = input.nextLine();
    System.out.println("CONFIRME A SENHA:                   ");
    String repeatPassword = input.nextLine();

    if(password.length() < 8) {
      LimparConsole();
      System.out.println("A SENHA PRECISA TER PELO MENOS 8 DIGITOS");
      Esperar(2);
    } else {
      if(!(password.equals(repeatPassword))) {
        LimparConsole();
        System.out.println("AS SENHAS SÃO DIFERENTES");
        Esperar(2);
      } else {
        _continue = false;
      }
    }
    } while(_continue);

    SalvarUsuario(username, password, type);
    LimparConsole();
    MenuInicial();
  }

  public static void SalvarUsuario(String username, String password, char type) {
    String old_users[][] = users;                                //SALVA O ANTIGO ARRAY
    users = new String[old_users.length+1][3];                   //CRIA UM ARRAY MAIOR
    for (int i = 0; i < old_users.length; i++) {                 //SALVA OS VALORES NO NOVO ARRAY
      users[i] = old_users[i];
    }
    users[users.length-1][0] = username;                         //SALVA O USUARIO NO ULTIMO VALOR
    users[users.length-1][1] = password;
    users[users.length-1][2] = String.valueOf(type);
    LimparConsole();
    System.out.println("USUARIO CRIADO COM SUCESSO");
    Esperar(2);
    return;
  }

  public static void ExibirUsuarios() {
    LimparConsole();
    System.out.println(Arrays.deepToString(users));
    System.out.println("PRESSIONE ENTER PARA RETORNAR");
    input.nextLine();
    LimparConsole();
  }

  public static void LimparConsole(){
    System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  public static void Esperar(int time) {
    try {
        Thread.sleep(time * 1000);
        } catch(InterruptedException e) {}
      }
}
