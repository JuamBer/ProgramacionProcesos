import java.io.*;
import java.net.*;

// SERVIDOR ESPERA CONNEXIONS A LES QUE ATENDRA

// SERVIDOR SALUDARÀ AMB LA FRASE "Hola client"

public class Servidor {

    // PORT EN EL QUE ESPERA CONNEXIONS
    static final int PORT = 5000;
    
    public static void main(String[] args) {
        new Servidor();
    }
    
    
    public Servidor(){
        try{
            ServerSocket ssServidor = new ServerSocket(PORT);
            System.out.println("Escolte al port "+PORT);
            
            for (int numCli = 0; numCli < 3; numCli++) {
                Socket sCliente = ssServidor.accept();
                
                System.out.println("Serveisc al client");
                
                OutputStream aux = sCliente.getOutputStream();
                DataOutputStream flux = new DataOutputStream(aux);
                
                flux.writeUTF("Hola Client");
                sCliente.close();
            }
            
            System.out.println("Massa clients per hui");
            
            ssServidor.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}