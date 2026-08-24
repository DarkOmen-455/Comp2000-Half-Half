//type erasure and runtime exception example

public class Main {
    public static void main(String[] args) {
        Container<String> strings = new Container<>();
        strings.add("hello");
        strings.add("world");
        breaks(strings);

        String first = strings.get(0);
        String second = strings.get(1);
        String third = strings.get(2);

        System.out.println(first + " " + second);
    }

    public static void breaks(Container c){
    c.add(5);

}
}


