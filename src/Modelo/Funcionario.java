
package Modelo;
import java.sql.*;

public class Funcionario {
    public String CPF;
    public String Nome;
    public String HorasT;
    public String Salario;
    public String Telefone;
    
public Funcionario(String CPF, String Nome, String HorasT, String Salario, String Telefone){
    this.CPF = CPF;
    this.Nome = Nome;
    this.HorasT = HorasT;
    this.Salario = Salario;
    this.Telefone = Telefone;
}       

public void cadastrar (){
    
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        
        String comando;
        comando = "insert into funcionario (CPF, Nome, HorasT, Salario, Telefone) values('"+CPF+"','"+Nome+"','"+HorasT+"','"+Salario+"','"+Telefone+"')";
        System.out.println(comando);
        
        Statement Instrucao;        
        Instrucao = conexao.createStatement();  
        Instrucao.executeUpdate(comando); 
    }catch( ClassNotFoundException erro){ 
        System.out.println("Erro clase");
    }catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
 
}
    

public String listagem (){
    Connection conexao = null;
    String lista = "<html><body style='font-family:Arial; text-align:center;'>";
    lista += "<table border='1' cellspacing='0' cellpadding='5' align='center'>";
    lista += "<tr><th>CPF</th><th>Nome</th><th>Horas Trabalhadas</th><th>Salário</th><th>Telefone</th></tr>";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");

        String comando;
        comando = "select * from funcionario";
        System.out.println (comando);

        Statement Instrucao;
        Instrucao = conexao.createStatement();

        ResultSet resultado = null;
        resultado = Instrucao.executeQuery(comando);

        while(resultado.next()){
            lista = lista+ "<tr><td>"+
            resultado.getString("CPF")+" - "+"</tr></td>"+
            resultado.getString("Nome")+"</tr></td>"+
            resultado.getString("HorasT")+"</tr></td>"+
            resultado.getString("Salario")+"</tr></td>"+
            resultado.getString("Telefone")+ "</tr><td>";
        }
        lista = lista + "</table></body></html>";
        System.out.println(lista);
    } catch( ClassNotFoundException erro){
        System.out.println("Erro clase");
    } catch( SQLException erro ){
        System.out.println("Erro SQL");
    }
    return lista;
}
    
    
public boolean login (){
    boolean entrada = false;
    Connection conexao = null; 
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        comando = "select * from funcionario where CPF = '" +CPF+ "' and Nome ='" +Nome+ "'";           
        Statement Instrucao;        
        Instrucao = conexao.createStatement();   

        System.out.println(comando);
        ResultSet tatu;
        tatu = Instrucao.executeQuery(comando); 

        if(tatu.next()){
            entrada = true;
        } 

        } catch( ClassNotFoundException erro) { 
            System.out.println("Erro clase");
        } catch( SQLException erro ){
            System.out.println("Erro SQL");
        }
        return entrada;   
}
  

public void excluir (){

    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        System.out.println("tatu");
        comando = "delete from funcionario where CPF = '" +CPF+ "'";
        System.out.println(comando);
        Statement Instrucao;        
        Instrucao = conexao.createStatement();   
        Instrucao.executeUpdate(comando); 
    } catch( ClassNotFoundException erro){ 
        System.out.println("Erro clase");
    } catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
       
}
public void atualizar (){
       
    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        System.out.println("tatu");
        comando = "update funcionario set CPF = '"+CPF+"', Nome = '"+Nome+"', HorasT = '"+HorasT+"', Salario = "+Salario+", Telefone = '"+Telefone+"'   where CPF = '"+CPF+"'";
        System.out.println(comando);
        Statement Instrucao;        
        Instrucao = conexao.createStatement();  
        Instrucao.executeUpdate(comando);
    } catch( ClassNotFoundException erro){
        System.out.println("Erro clase");
    } catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
}

}
