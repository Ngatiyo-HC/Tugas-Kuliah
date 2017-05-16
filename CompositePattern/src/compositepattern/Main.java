package compositepattern;
import java.util.ArrayList;
import java.util.List;

interface Component{
 public void PrintHello();
 public void PrintGoodBye();
}

class Mahasiswa implements Component{
 public Mahasiswa(String name) {
  this.name = name;
 }

 private String name;

 @Override
 public void PrintHello() {
  System.out.println(this.name+" Mengatakan Hallo");
 }

 @Override
 public void PrintGoodBye() {
  System.out.println(this.name+" Mengatakan Selamat tinggal");
 }
}

class Composite implements Component{
 List<Component> list = new ArrayList<Component>();
 @Override
 public void PrintHello() {
  for(Component component : list){
   component.PrintHello();
  }
 }
 @Override
 public void PrintGoodBye() {
  for(Component component : list){
   component.PrintGoodBye();
  }
 }
 public void AddComponent(Component component){
  this.list.add(component);
 }

 public void RemoveComponent(Component component){
  this.list.remove(component);
    }
}
public class Main {
  public static void main(String[] args) {
  Mahasiswa mahasiswa_1 = new Mahasiswa("Budi");
  Mahasiswa mahasiswa_2 = new Mahasiswa("Bapabudi");
  Mahasiswa mahasiswa_3 = new Mahasiswa("Ibubudi");
  Mahasiswa mahasiswa_4 = new Mahasiswa("Kakabudi");
  Mahasiswa mahasiswa_5 = new Mahasiswa("Adebudi");

  Composite composite_1 = new Composite();
  composite_1.AddComponent(mahasiswa_1);
  composite_1.AddComponent(mahasiswa_2);

  Composite composite_2 = new Composite();
  composite_2.AddComponent(mahasiswa_3);
  composite_2.AddComponent(mahasiswa_4);

  Composite composite_3 = new Composite();
  composite_3.AddComponent(composite_1);
  composite_3.AddComponent(composite_2);
  composite_3.AddComponent(mahasiswa_5);

  System.out.print("Masukkan Nama Mahasiswa : ");

  System.out.println("Panggil Function PrintHello() dari mahasiswa_1");
  mahasiswa_1.PrintHello();
  System.out.println("-----------------------------------------------");
  System.out.println("Panggil Function PrintHello() dari composite_1");
  composite_1.PrintHello();
  System.out.println("-----------------------------------------------");
  System.out.println("Panggil Function PrintHello() dari composite_2");
  composite_2.PrintHello();
  System.out.println("-----------------------------------------------");
  System.out.println("Panggil Function PrintHello() dari composite_3");
  composite_3.PrintHello();
  System.out.println("-----------------------------------------------");
 }
}
