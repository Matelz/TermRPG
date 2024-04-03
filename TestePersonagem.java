import java.util.Random;
import java.util.Scanner;

public class TestePersonagem {
    public static void main(String[] args) {
        Random random = new Random();
        Boolean running = true;
        Personagem personagem = new Personagem();
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Insira um nome para o seu herói:\n-> ");
        String name = input.nextLine(); 
        personagem.nascer(name, random.nextInt(11), random.nextInt(11), random.nextInt(11));
        
        while (running){ 
            var choice = "";

            System.out.printf("\nDigite o que você deseja fazer:\n\t📜 (S) - Status\n\t🏹 (C) - Caçar\n\t🏔️  (E) - Explorar\n\t🍔 (O) - Comer\n\t🛏️  (D) - Dormir\n\t❌ (X) - Sair\n");
            
            try{
                choice = input.next("[SCEODX+]");
            }catch(java.util.InputMismatchException e){
                System.err.println("Digite um valor válido");
            }

            
            while(choice != null){
                switch (choice) {
                    case "S":
                        personagem.status(); 
                        break;

                    case "C":
                        personagem.cacar();
                        break;

                    case "E":
                        personagem.explorar();
                        break;

                    case "O":
                        personagem.comer();
                        break;

                    case "D":
                        personagem.dormir();
                        break;

                    case "X":
                        running = false;
                        break;
                
                    default:
                        break;
                }

                choice = null;
                // input.close();
            }
        }
    }
}
