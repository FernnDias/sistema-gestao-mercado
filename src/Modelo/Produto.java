package Modelo;
import java.sql.*;

public class Produto {
    public String Codigo;
    public String Nome;
    public String Marca;
    public int Quantidade;
    public String Valor;

    
public Produto(String Codigo, String Nome, String Marca, int Quantidade, String Valor){
    this.Codigo = Codigo;
    this.Nome = Nome;
    this.Marca = Marca;
    this.Quantidade = Quantidade;
    this.Valor = Valor;
}

public void cadastrar (){

    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        comando = "insert into produto (Codigo, Nome, Marca, Quantidade, Valor) values('"+Codigo+"','"+Nome+"','"+Marca+"',"+Quantidade+",'"+Valor+"')";
        System.out.println(comando);
        Statement Instrucao;        
        Instrucao = conexao.createStatement();   
        Instrucao.executeUpdate(comando); 
    } catch( ClassNotFoundException erro){ 
        System.out.println("Erro clase: " + erro);
    } catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
}


public String listagem (){

    Connection conexao = null;
    String lista = "<html><body style='font-family:Arial; text-align:center;'>";
    lista += "<table border='1' cellspacing='0' cellpadding='5' align='center'>";
    lista += "<tr><th>Código</th><th>Nome</th><th>Marca</th><th>Quantidade</th><th>Valor</th></tr>";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        comando = "select * from produto";
        System.out.println (comando);
        Statement Instrucao;
        Instrucao = conexao.createStatement();
        ResultSet resultado = null;
        resultado = Instrucao.executeQuery(comando);
        lista = lista + "<table border=1>";

        while(resultado.next()){
            lista = lista+ "<tr><td>"+
            resultado.getString("Codigo")+" - "+"</tr></td>"+
            resultado.getString("Nome")+"</tr></td>"+
            resultado.getString("Marca")+"</tr></td>"+
            resultado.getString("Quantidade")+"</tr></td>"+
            resultado.getString("Valor")+ "</tr><td>";
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
        
        
public void excluir (){

    Connection conexao = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        System.out.println("tatu");
        comando = "delete from produto where Codigo = '" +Codigo+ "'";
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
        comando = "update produto set Codigo = '"+Codigo+"', Nome = '"+Nome+"', Marca = '"+Marca+"', Quantidade = "+Quantidade+", Valor = '"+Valor+"'   where Codigo = '"+Codigo+"'";
        System.out.println(comando);
        Statement Instrucao;
        System.out.println(comando);
        Instrucao = conexao.createStatement();  
        Instrucao.executeUpdate(comando);
    } catch( ClassNotFoundException erro){
        System.out.println("Erro clase");
    } catch( SQLException erro ){
        System.out.println("Erro SQL: " + erro);
    }
}

public String visualizar (){
    boolean entrada = false;
    Connection conexao = null; 
    String lista = "<html><body style='font-family:Arial; text-align:center;'>";
    lista += "<table border='1' cellspacing='0' cellpadding='5' align='center'>";
    lista += "<tr><th>Código</th><th>Nome</th><th>Marca</th><th>Quantidade</th><th>Valor</th></tr>";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/caixamercado", "root","");
        String comando;
        comando = "select * from produto where Codigo = '"+Codigo+"'";           
        Statement Instrucao;        
        Instrucao = conexao.createStatement();   
        ResultSet resultado = null;
        resultado = Instrucao.executeQuery(comando);
        System.out.println(comando);

         if (!resultado.next()){
        
           lista += "<tr><td> O codigo informado não pertence a nenhum produto </tr></td>";
            
        } else { 
             
          do{
            lista = lista + "<table border=1>";
            lista = lista+ "<tr><td>"+
            resultado.getString("Codigo")+" - "+"</tr></td>"+
            resultado.getString("Nome")+"</tr></td>"+
            resultado.getString("Marca")+"</tr></td>"+
            resultado.getString("Quantidade")+"</tr></td>"+
            resultado.getString("Valor")+ "</tr><td>";
        }  while(resultado.next());
        
        }
    
        } catch( ClassNotFoundException erro) { 
            System.out.println("Erro clase" + erro);
        } catch( SQLException erro ){
            System.out.println("Erro SQL" + erro);
        }
        return lista;   
}

}









