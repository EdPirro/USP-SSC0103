public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Insira o raio do circulo:");
        double raio = EntradaTeclado.leDouble();

        Circulo c = new Circulo("azul", true, raio);

        System.out.println("A Area do circulo eh: " + c.getArea() + ", já seu perimetro eh: " + c.getPerimeter() + ".");

        System.out.println("Insira o tamanho do lado do quadrado");
        double lado = EntradaTeclado.leDouble();

        Quadrado q = new Quadrado("branco", false, lado);

        System.out.println("A Area do quadrado eh: " + q.getArea() + ", já seu perimetro eh: " + q.getPerimeter() + ".");


        double[] lados = new double[2];
        System.out.println("Insira o tamanho do primeiro lado do retangulo:");
        lados[0] = EntradaTeclado.leDouble();
        System.out.println("Insira o tamanho do segundo lado do retangulo:");
        lados[1] = EntradaTeclado.leDouble();

        Retangulo r = new Retangulo("verde", true, lados[0], lados[1]);

        System.out.println("A Area do retangulo eh: " + r.getArea() + ", já seu perimetro eh: " + r.getPerimeter() + ".");

    }
}
