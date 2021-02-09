import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Circle kolo1 = new Circle(4.0, "pink",true);
        Circle kolo2 = new Circle(4.0);
        Rectangle prostokat1 = new Rectangle(5.0, 10.0, "grey", false);
        Square kwadrat1 = new Square(4.0);

        int i=0;
        String[] kolory = {"pink", "red", "green", "yellow"};
        while(i<40){
            Random losowa = new Random();
            int los1 = losowa.nextInt(99);
            int los2 = losowa.nextInt(4);
            Circle kolo= new Circle(los1, kolory[los2] , Math.random() < 0.5);
            i++;
        }



        System.out.println("\n-----------------------------");

        ArrayList<Shape> listaFigur1 = new ArrayList<>();
        listaFigur1.add(kolo1);
        listaFigur1.add(kolo2);
        listaFigur1.add(kolo2);
        listaFigur1.add(kolo1);

        listaFigur1.remove(3);
        listaFigur1.clear();

        LinkedList<Circle> listaKol = new LinkedList<>();
        listaKol.add(kolo1);
        listaKol.add(kolo2);
        listaKol.add(kolo1);
        listaKol.addFirst(kolo2);
        listaKol.add(new Circle(10));

        Set<Circle> zbiorKol = new HashSet<>();
        zbiorKol.add(kolo1);
        zbiorKol.add(kolo1);
        zbiorKol.add(kolo2);
        zbiorKol.add(kolo2);

        Map<String,Circle> mapaKol = new HashMap<>();
        mapaKol.put("Koło1",kolo1);
        mapaKol.put("Koło2",kolo2);
        mapaKol.put("Koło1",kolo1);

        Map<Double,Circle> mapaKol2= new HashMap<>();
        mapaKol2.put(kolo1.getArea(),kolo1);
        mapaKol2.put(kolo2.getArea(),kolo2);
        mapaKol2.put(kolo2.getArea(),kolo1);

        Random losowa = new Random();

        System.out.println("------------------09.02.2021------------------");
        List<Rectangle> prostokaty = Arrays.asList(
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"pink",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"red",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"pink",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"red",false),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"green",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"pink",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"green",false),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"pink",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"red",true),
                new Rectangle(losowa.nextInt(10),losowa.nextInt(10),"blue",true)
        );
        System.out.println(prostokaty);
        System.out.println("\nA------------------------------------");

        prostokaty.stream()
                .filter(d -> d.getPerimeter() > d.getArea())
                .forEach(System.out::println);

        System.out.println("\nB------------------------------------");

        prostokaty.stream()
                .sorted(Comparator.comparingDouble(Rectangle::getArea))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nC------------------------------------");

        prostokaty.stream()
                .sorted(Comparator.comparingDouble(Rectangle::getPerimeter)
                        .reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nD------------------------------------");

        prostokaty.stream()
                .mapToDouble(d -> d.getPerimeter())
                .average()
                .ifPresent(a -> System.out.println(a));

        System.out.println("\nE------------------------------------");


            double sum1 = prostokaty.stream()
                    .mapToDouble(g -> g.getArea())
                    .sum();
            System.out.println(sum1);

    }
}
