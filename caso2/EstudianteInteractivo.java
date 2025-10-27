import java.util.Scanner;

class Estudiante {
    private String codigo;
    private String nombre;
    private int ciclo;

    public Estudiante(String codigo, String nombre, int ciclo) {
        this.codigo = codigo; this.nombre = nombre; this.ciclo = ciclo;
    }
    public String getCodigo() { return codigo; }  public void setCodigo(String v){codigo=v;}
    public String getNombre() { return nombre; }  public void setNombre(String v){nombre=v;}
    public int getCiclo() { return ciclo; }      public void setCiclo(int v){ciclo=v;}

    @Override public String toString(){ return "Estudiante{codigo='"+codigo+"', nombre='"+nombre+"', ciclo="+ciclo+"}"; }
}

public class EstudianteInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código: "); String codigo = sc.nextLine();
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Ciclo (número): "); int ciclo = sc.nextInt();
        Estudiante e = new Estudiante(codigo, nombre, ciclo);
        System.out.println("Creado: " + e);
        sc.close();
    }
}
