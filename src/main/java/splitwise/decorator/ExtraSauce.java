package splitwise.decorator;

public class ExtraSauce extends BasePizza {
    ExtraSauce(BasePizza basePizza){
        super(basePizza);
    }
    int getCost(){
        return basePizza.getCost() + 15;
    }
}
