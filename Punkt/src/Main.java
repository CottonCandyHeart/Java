public class Main {
    public static void main(String[] args) {
        Punkt2D p2d = new Punkt2D(5,6);
        System.out.println("Punkt 2D: " + p2d.toString());

        Punkt3D p3d = new Punkt3D(p2d,7);
        System.out.println("Punkt 3D: " + p3d.toString());  // polimorfizm

        Punkt3DzEtykieta p3dze = new Punkt3DzEtykieta(p3d,"ETYKIETA");
        System.out.println("Punkt 3D z etykietą: " + p3dze.toString());  // polimorfizm

        Punkt4D p4d = new Punkt4D(p3d,10);
        System.out.println("Punkt 4D: " + p4d.toString());  // polimorfizm

        Punkt4DzEtykieta p4dze = new Punkt4DzEtykieta(p4d,"ETYKIETA 2");
        System.out.println("Punkt 4D z etykietą: " + p4dze.toString());  // polimorfizm
    }
}