class Retangulo {
    protected String desenho;

    public Retangulo(String desenho) {
        this.desenho = desenho;
    }

    public void desenhar(String texto) {
        int largura = texto.length() + 4;
        System.out.println(desenho.repeat(largura));
        System.out.println(desenho + " " + texto + " " + desenho);
        System.out.println(desenho.repeat(largura));
    }
}

class RetanguloBordasDuplas extends Retangulo {
    public RetanguloBordasDuplas() {
        super("═");
    }
}


public class Main {
    public static void main(String[] args) {
        Retangulo retanguloSimples = new Retangulo("-");
        Retangulo retanguloBordasDuplas = new RetanguloBordasDuplas();

        System.out.println("Desenhando retângulo simples:");
        retanguloSimples.desenhar("Hello, World!");

        System.out.println("\nDesenhando retângulo com bordas duplas:");
        retanguloBordasDuplas.desenhar("Hello, World!");
    }
}
