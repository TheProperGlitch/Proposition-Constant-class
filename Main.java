public class Main {
    public static void main(String[] args) {
        PropositionConstant x = new PropositionConstant("Hello", true);
        PropositionConstant y = new PropositionConstant("Goodbye", false);
        System.out.println(x);
        x.toggle();
        System.out.println(x);
        System.out.println(y);
        System.out.println(x.equals(y));

    }
}