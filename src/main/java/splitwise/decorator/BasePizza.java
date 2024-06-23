package splitwise.decorator;

public class BasePizza {
    BasePizza basePizza;
    BasePizza(BasePizza basePizza){
        this.basePizza=basePizza;
    }
    int getCost(){
        return 100;
    }
}
