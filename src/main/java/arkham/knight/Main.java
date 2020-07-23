package arkham.knight;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

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
    }
}
