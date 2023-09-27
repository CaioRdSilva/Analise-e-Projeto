import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int logedIn = 0;
        try {
            Connection conn  = conec.open();
            while (logedIn == 0){
                System.out.println("Digite o login: ");
                String login = scanner.nextLine();
                System.out.println("Digite a senha :");
                String senha = scanner.nextLine();
                PreparedStatement SelectAccount = conn.prepareStatement("SELECT * FROM User WHERE login = ? and senha = ?");
                SelectAccount.setString(1, login);
                SelectAccount.setString(2, senha);
                ResultSet rs = SelectAccount.executeQuery();
                while (rs.next()) {
                    if(login.equals(rs.getString("login")) && senha.equals(rs.getString("senha"))){
                        System.out.println("Login feito com sucesso!\n");

                        int desejada = 9;

                        while(desejada != 0){
                            System.out.println("Digite a operação desejada - 1-inserir nota, 2- alterar notas, 3- checar nota, 4- deletar nota, 0- Sair");
                            desejada = scanner.nextInt();
                            scanner.nextLine();
                            switch (desejada){
                                case 0-> {
                                    System.out.println("Sistema encerrado!");
                                }
                                case 1-> {
                                    System.out.println("Nome da nota: ");
                                    String NomeNota = scanner.nextLine();
                                    System.out.println("Digite o texto da nota: ");
                                    String Nota = scanner.nextLine();
                                    oper.criar(NomeNota, Nota);
                                }
                                case 2->{
                                    System.out.println("\nQual nome da nota a atualizar?: ");
                                    String NotaATT = scanner.nextLine();
                                    System.out.println("\nDigite o novo texto: ");
                                    String novaNota = scanner.nextLine();
                                    oper.uptext(novaNota, NotaATT);
                                }
                                case 3-> {
                                    System.out.println("Digite o nome da nota que deseja ler: ");
                                    String NomeNota = scanner.nextLine();
                                    oper.lertext(NomeNota);
                                }
                                case 4->{
                                    System.out.println("Nome da Nota que deseja remover: ");
                                    String NotaRM = scanner.nextLine();
                                    oper.remover(NotaRM);
                                }
                            }
                        }
                        logedIn = 1;
                    }else{
                        System.out.println("O login falhou!");
                    }
                }
            }
            conn.close();
        } catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("erro");
    }
    }
}