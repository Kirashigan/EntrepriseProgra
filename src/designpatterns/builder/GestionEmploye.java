package designpatterns.builder;

public class GestionEmploye {
    public static void main(String[] args) {
        try {
            Employe em1 = new Employe.EmployeBuilder().
                    setMatricule("test").
                    setNom("test").
                    setPrenom("test").
                    setMail("test").
                    setTelephone("test")
                    .build();
            System.out.println(em1.toString());
        }catch (Exception e){
            System.out.println("erreur "+e);
        }
        try {
            Employe em2 = new Employe.EmployeBuilder().
                    setNom("test2").
                    setPrenom("test2").
                    setTelephone("test2").
                    setMail("test2").build();
            System.out.println(em2.toString());
        }catch (Exception e){
            System.out.println(e);
        }

        //Cas 2 exception levé
    }
}
