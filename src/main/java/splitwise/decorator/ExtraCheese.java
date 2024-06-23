package splitwise.decorator;

public class ExtraCheese extends BasePizza {
    ExtraCheese(BasePizza basePizza){
        super(basePizza);
    }
    int getCost(){
        return basePizza.getCost() + 10;
    }
}
