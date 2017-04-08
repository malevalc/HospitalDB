/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module_connexion;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 
 * Connexion a votre BDD via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat requete
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    private SSHTunnel ssh;
    private String type_connexion;
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<String>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<String>(); // liste des requêtes de MAJ

    /**
     * Constructeur avec 4 paramètres : username et password ECE, login et password de la BDD
     */
    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase,boolean local) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");
    type_connexion="";

        // Connexion via le tunnel SSH avec le username et le password ECE
        ssh = new SSHTunnel(usernameECE, passwordECE);
System.out.print("okkk");
        if ((!local)&&(ssh.connect())) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
             type_connexion="Distant connexion successfull.";
            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();

            // initialisation de la liste des requetes de selection et de MAJ
            remplirRequetes();
            remplirRequetesMaj();
        }
        else{//par défaut on prévoit la connexion locale
             
         System.out.println(" Connexion au serveur en locale au serveur Wamp!");

           try{
            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost/test";//:80/

            //créatio   n d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase,loginDatabase,"");
            type_connexion="Local connexion successfull.";
            if(conn==null)
                System.out.print("C'est vide!");
            
            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();
           System.out.println("Connexion reussie");
           }
           catch(Exception exp)
           {System.out.println("Erreur lors de la connexion locale!");}

        }
    }
    public void disconnect() throws SQLException
    {
       //ajouter les results... rsetMeta.close() rset.close()
        if(rset!=null)
            rset.close();
        
        if(stmt!=null)
        stmt.close();
        
        if(conn!=null)
        conn.close();
        
        if(ssh!=null)
       ssh.disconnect();
        
        System.out.println("Deconnection reussie !");
        
        
    
    }
    
   
    //pour cyril
    public String typeConnection()
    {
    return type_connexion;
    }
    
    public boolean isConnectionEstablished()
    {
    if(conn!=null)
        return true;
    
    return false;
    }
    
    //Getters
    public Connection getConnection()
    {
    return conn;
    }
    
    public Statement getStatement()
    {
    return stmt;
    }
    
    public ResultSet getResultset()
    {
    
    return rset;
    }

    public ResultSetMetaData getResultSetMetaData()
    {return rsetMeta;
    }
    public SSHTunnel getSSHTunnel()
    {
    return ssh;
    }
    
    //Setters
    public void setConnection(Connection connection)
    {
    conn=connection;
    }
    public void setStatement(Statement stmt)
    {
    this.stmt=stmt;
    }
    
    public void setResultset(ResultSet rset)
    {
    this.rset=rset;
    }
    public void setResultSetMetaData(ResultSetMetaData rsetMeta)
    {
    this.rsetMeta=rsetMeta;
    }
    /**
     * Méthode privée qui ajoute la requete de selection en parametre dans son ArrayList
     */
    private void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode privée qui initialise la liste des requetes de selection
     */
    private void remplirRequetes() {
        ajouterRequete("SELECT ename, sal FROM Emp ORDER BY sal;");
        ajouterRequete("SELECT Dept.*, Emp.*, Mission.* FROM Dept, Emp, Mission WHERE Dept.deptno=Emp.deptno AND Emp.empno=Mission.empno;");
        ajouterRequete("SELECT AVG (Emp.sal) FROM Emp, Mission WHERE Emp.empno = Mission.empno;");
        ajouterRequete("SELECT Dept.*, Emp.* FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND comm>0;");
        ajouterRequete("SELECT hiredate, empno, ename FROM Emp WHERE (((hiredate)>='1981-05-01' And (hiredate)<'1981-05-31'))ORDER BY hiredate;");
        ajouterRequete("SELECT ename, job FROM Emp ORDER BY job;");
        ajouterRequete("SELECT DISTINCT dname, job FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND job='Clerk';");
    }

    /**
     * Méthode privée qui ajoute la requete de MAJ en parametre dans son ArrayList
     */
    private void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode privée qui initialise la liste des requetes de MAJ
     */
    private void remplirRequetesMaj() {
        // Requêtes d'insertion
        ajouterRequeteMaj("INSERT INTO Dept (deptno,dname,loc) VALUES (50,'ECE','Paris');");

        // Requêtes de modification
        ajouterRequeteMaj("UPDATE Dept SET loc='Eiffel' WHERE loc='Paris';");

        // Requêtes de suppression
        ajouterRequeteMaj("DELETE FROM Dept WHERE loc='Eiffel';");

    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            liste.add(rsetMeta.getColumnLabel(i + 1));
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i+1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
}
