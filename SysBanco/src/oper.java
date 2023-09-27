import java.sql.*;

public class oper {
    static Connection con;
    static {
        try {
            con = conec.open();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void criar(String NomeNota, String Nota){
        try {
            PreparedStatement InserQuery = con.prepareStatement("Insert Into Nota VALUES(codigo,?,?)");
            InserQuery.setString(1,NomeNota);
            InserQuery.setString(2,Nota);
            int ins = InserQuery.executeUpdate();
            if (ins == 1){
                System.out.println("Nota criada!");
            }else{
                System.out.println("Nota não foi criada!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void uptext(String novaNota, String NotaATT){
        try {
           PreparedStatement UpdateNota = con.prepareStatement("UPDATE Nota SET nota = ? WHERE nome = ?");
           UpdateNota.setString(1,novaNota);
           UpdateNota.setString(2, NotaATT);
           int upd = UpdateNota.executeUpdate();
           if (upd == 1){
               System.out.println("Nota atualizada!");
           }else{
               System.out.println("nota não atualizada!");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void remover(String NotaRM){
        try {
            PreparedStatement RemoveNota = con.prepareStatement("DELETE FROM Nota WHERE nome =?");
            RemoveNota.setString(1, NotaRM);
            int rm =RemoveNota.executeUpdate();
            if (rm == 1){
                System.out.println("Nota Removida!");
            }else{
                System.out.println("Nota não removida!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void lertext(String NomeNota){
        try {
            PreparedStatement selectQuery = con.prepareStatement("SELECT nome,nota FROM Nota WHERE nome =?");
            selectQuery.setString(1,NomeNota);
            ResultSet rs = selectQuery.executeQuery();
            while(rs.next()){
                System.out.println("Nome da nota: "+rs.getString("nome") + "\n" + "Nota: " + rs.getString("nota"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
