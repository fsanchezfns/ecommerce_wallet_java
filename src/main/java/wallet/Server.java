package wallet;

import wallet.application.RestController;
import static spark.Spark.*;

public class Server{
    public static void main(String[] args) {
        
        new Server().start();
    }

    void start(){

        path("/v1", () -> {

            path("/operations", () -> {
                post("",  (req, res) -> RestController.createOperation(req,res));
                get("/:id" ,  (req, res) -> RestController.getOperation(req,res) );
                get("",  (req, res) -> "consulta todas las operaciones");  
                
            });

            path("/wallet", () -> {
                get("",  (req, res) -> "consulta la billetera");
                
            });



        });

    }
}