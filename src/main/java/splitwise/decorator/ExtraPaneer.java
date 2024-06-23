package splitwise.decorator;

public class ExtraPaneer extends BasePizza {
    ExtraPaneer(BasePizza basePizza){
        super(basePizza);
    }
    int getCost(){
        return basePizza.getCost() + 40;
    }
}
