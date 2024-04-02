import java.util.Random;

public class Personagem{
    private String nome;
    private int energia, fome, sono, vida, ataque, defesa;
    private boolean temComida = false;

    String createBar(int min, int max, int value){
        String bar = "";

        for(int x = min; x <= value - 1; x++){
            bar += "\u001B[32m▮\u001B[0m"; 
            // System.out.printf("\u001B[32m▮\u001B[0m");
        }
        for(int y = value; y <= max - 1; y++){
            bar += "\u001B[37m▮\u001B[0m"; 
            // System.out.printf("\u001B[31m▮\u001B[0m");
        }
        return bar;
    }

    void nascer(String nome, int energia, int fome, int sono){
        this.nome = nome;
        this.energia = energia;
        this.fome = fome;
        this.sono = sono;
        this.vida = 10;
        this.ataque = 4;
        this.defesa = 2;

    }

    void cacar(){
        if(this.energia >= 2 && !temComida){
            System.out.printf("🏹 - %s está caçando!!\n", (this.nome));
            this.energia -= 2;
            this.sono++;
            this.temComida = true;        
        } else {
            System.out.printf("❌ - %s está muito cansado ou já tem comida\n", (this.nome));        
        }
    }

    void explorar(){
        Random rand = new Random();
        if(this.energia >= 4 && this.fome <= 5){
            int choice = rand.nextInt(4);
            switch (choice) {
                case 1:
                    System.out.printf("\n🍔 - %s encontrou um cesto de comida! (-5 de fome)", this.nome);
                    if(this.fome >= 5){
                        this.fome -= 5;
                    } else {
                        this.fome = 0;
                    }
                    break;
                case 2:
                    System.out.printf("\n🗝️ - %s encontrou uma chave! (Desbloqueia uma passagem secreta)", this.nome);
                    // Lógica para desbloquear uma passagem secreta
                    break;
                case 3:
                    System.out.printf("\n💰 - %s encontrou um baú do tesouro! (+20 de ouro)", this.nome);
                    break;
                case 4:
                    System.out.printf("\n🏹 - %s encontrou um arco e flechas! (+10 de ataque)", this.nome);
                    this.ataque += 10;
                    break;
                case 5:
                    System.out.printf("\n🌿 - %s encontrou uma poção de cura! (+15 de vida)", this.nome);
                    this.vida += 15;
                    break;
                case 6:
                    System.out.printf("\n🔮 - %s encontrou um amuleto mágico! (+10 de defesa, +10 de magia)", this.nome);
                    this.defesa += 10;
                    break;
                case 7:
                    System.out.printf("\n🔥 - %s caiu em uma armadilha de fogo! (-10 de vida)", this.nome);
                    this.vida -= 10;
                    break;
                case 8:
                    System.out.printf("\n🗡️ - %s encontrou uma espada afiada! (+15 de ataque)", this.nome);
                    this.ataque += 15;
                    break;
                case 9:
                    System.out.printf("\n🛡️ - %s encontrou um escudo resistente! (+20 de defesa)", this.nome);
                    this.defesa += 20;
                    break;
                case 10:
                    System.out.printf("\n👹 - %s encontrou um monstro! (-30 de vida)", this.nome);
                    this.vida -= 30;
                    break;
                default:
                    System.out.println("\n⚠️ - Evento inesperado!");
            }
        }
    }

    void dormir(){
        if(this.energia <= 8){
            System.out.printf("🛏️ - %s está dormindo!!\n", (this.nome));
            this.fome += 2;
            this.sono = 0;
        } else {
            System.out.printf("❌ - %s está sem sono\n", (this.nome));        
        }
    }

    void status(){
        System.out.printf("📜 - %s está com:\n\t%s (%d) - de vida\n\t%s (%d) - de energia\n\t%s (%d) - de fome\n\t%s (%d) - de sono\n", this.nome, this.createBar(0, 10, this.vida), this.vida, this.createBar(0, 10, this.energia), this.energia, this.createBar(0, 10, this.fome), this.fome, this.createBar(0, 10, this.sono), this.sono);
    }

    void comer(){
        if(this.energia >= 1 && this.temComida){
            System.out.printf("🍔 - %s está comendo!!\n", (this.nome));
            this.temComida = false;
            this.fome = 0;
            this.energia += 5;
        } else {
            System.out.printf("❌ - %s está muito cansado ou não tem comida\n", (this.nome));        
        }
    }
}