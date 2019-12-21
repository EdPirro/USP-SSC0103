public class Retangulo extends FigurasGeometricas{
    private double[] lado = new double[2];

    public Retangulo(String color, boolean filled, double ladoA, double ladoB) {
        super(color, filled);
        this.lado[0] = ladoA;
        this.lado[1] = ladoB;
    }

    public double[] getLado() {
        return lado;
    }

    public void setLado(double[] lado) {
        this.lado = lado;
    }

    public double getArea(){
        return lado[0] * lado[1];
    }

    public double getPerimeter(){
        return (2 * lado[0]) + (2 * lado[1]);
    }
}
