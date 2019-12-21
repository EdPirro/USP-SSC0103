public class Circulo extends FigurasGeometricas {
    private double raio;

    public Circulo(String color, boolean filled, double radius) {
        super(color, filled);
        this.raio = radius;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double radius) {
        this.raio = radius;
    }

    public double getArea(){
        return raio * raio * Math.PI;
    }

    public double getPerimeter(){
        return 2 * raio * Math.PI;
    }
}
