public class Quadrado extends FigurasGeometricas {
    private double lado;

    public Quadrado(String color, boolean filled, double lado) {
        super(color, filled);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getArea(){
        return lado * lado;
    }

    public double getPerimeter(){
        return 4 * lado;
    }
}
