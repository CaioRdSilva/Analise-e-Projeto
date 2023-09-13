import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operacao = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            Connection conn = Conexao.abrir();
            Statement s = conn.createStatement();
            while (operacao != 9) {
                System.out.print("Digite a operação que você deseja realizar:\n1 - Cadastrar Conta \n2- Consultar conta \n3 - Alterar conta\n4 - Remover conta\n5 - Exibe todas as contas\n9 - Sair do sistema\n Sua opção: ");
                operacao = scanner.nextInt();
                switch (operacao) {
                    case 1 -> {
                        System.out.print("Digite o nome que deseja na sua conta: ");
                        String nome = scanner.next();
                        System.out.println("Digite saldo a ser inserido, se não houver saldo, digite 0: ");
                        double saldo = scanner.nextInt();
                        PreparedStatement InsertQuery = conn.prepareStatement("INSERT INTO Conta VALUES(codigo,?,?)");
                        InsertQuery.setString(1, nome);
                        InsertQuery.setDouble(2, saldo);
                        int sucess = InsertQuery.executeUpdate();
                        if (sucess == 1) {
                            System.out.print("Conta criada!\n");
                        } else {
                            System.out.print("Não foi possível criar a conta");
                        }
                    }
                    case 2 -> {
                        System.out.print("Nome da conta: ");
                        String NomeSelect = scanner.next();
                        PreparedStatement SelectAccount = conn.prepareStatement("SELECT * FROM Conta WHERE nome =?");
                        SelectAccount.setString(1, NomeSelect);
                        ResultSet rs = SelectAccount.executeQuery();
                        while(rs.next()) {
                            System.out.println("\nCódigo: " + rs.getInt("codigo") + "\nNome do cliente: " + rs.getString("nome") + "\nSaldo: " + rs.getDouble("saldo"));
                        }
                    }
                    case 3 -> {
                        System.out.print("Digite o nome da conta que você deseja editar: ");
                        String NomeUpdate = scanner.next();
                        System.out.print("Digite o novo saldo da conta: ");
                        int NewSaldo = scanner.nextInt();
                        PreparedStatement UpdateAccount = conn.prepareStatement("UPDATE Conta SET saldo = ? WHERE nome = ?");
                        UpdateAccount.setDouble(1, NewSaldo);
                        UpdateAccount.setString(2, NomeUpdate);
                        int SucessUpdate = UpdateAccount.executeUpdate();
                        if (SucessUpdate == 1) {
                            System.out.print("Saldo atualizada com sucesso\n");
                        } else {
                            System.out.println("Não foi possível atualizar o saldo.\n");
                        }
                    }
                    case 4 -> {
                        System.out.print("Digite o nome da conta que deseja remover: ");
                        String NomeRemove = scanner.next();
                        PreparedStatement RemoveAccount = conn.prepareStatement("DELETE FROM Conta WHERE nome =?");
                        RemoveAccount.setString(1, NomeRemove);
                        int rm = RemoveAccount.executeUpdate();
                        if (rm == 1){
                            System.out.println("Conta removida!\n");
                        } else {
                            System.out.println("Não foi possível remover a conta!\n");
                        }
                    }
                     case 5 -> {
                         System.out.println("Exibir todas as contas");
                         ResultSet rs = s.executeQuery("SELECT codigo, nome, saldo FROM Conta");
                         while (rs.next()) {
                             System.out.println("\nCódigo: " + rs.getInt("codigo") + "\nNome do cliente: " + rs.getString("nome") + "\nSaldo: " + rs.getDouble("saldo"));
                         }
                     }
                     case 9 -> {
                         System.out.println("Sistema encerrado...");
                         s.close();
                         conn.close();
                     }
                    }
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hi, deu bronca...");
        }
    }
}