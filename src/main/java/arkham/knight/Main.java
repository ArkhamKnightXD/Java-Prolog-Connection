package arkham.knight;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

public class Main {

    public static void main(String[] args) {

        //Aqui verifico si la conexion con el archivo fue exitosa
        Query query = new Query("consult", new Term[] {new Atom("test.pl")});

        System.out.println( "consult " + (query.hasSolution() ? "succeeded" : "failed"));


        //Realizo la consulta es ralf hijo de joe directamente al hecho child_of
        Query query1 = new Query("child_of", new Term[] {new Atom("joe"),new Atom("ralf")});

        System.out.println("child_of(joe,ralf) is " + ( query1.hasSolution() ? "provable" : "not provable" ));


        //Aqui hago una consulta a descendant_of que a diferencia de arriba esto es una regla y no un hecho
        Query query2 = new Query("descendent_of", new Term[] {new Atom("steve"),new Atom("ralf")});

        System.out.println("descendent_of(joe,ralf) is " + ( query2.hasSolution() ? "provable" : "not provable" ));

        //Haciendo uso de variables para hacer consultas
        Variable X = new Variable("X");

        Query q4 = new Query("descendent_of", new Term[] {X,new Atom("ralf")});

        java.util.Map<String,Term> solution;

        solution = q4.oneSolution();


        System.out.println( "first solution of descendent_of(X, ralf)");

        System.out.println( "X = " + solution.get("X"));

    }
}
