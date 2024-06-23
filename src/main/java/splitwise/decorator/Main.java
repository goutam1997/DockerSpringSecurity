package splitwise.decorator;

public class Main {
    public static void main(String[] args) {
        BasePizza extraPaneer=new ExtraPaneer(new ExtraCheese(new BasePizza(null)));
        System.out.println(extraPaneer.getCost());
        BasePizza extraSauce=new ExtraSauce(new ExtraCheese(new BasePizza(null)));
        System.out.println(extraSauce.getCost());
    }
}
