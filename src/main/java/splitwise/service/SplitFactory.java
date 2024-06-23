package splitwise.service;

import splitwise.model.SplitType;

public class SplitFactory {
    public static SplitExpense get(SplitType splitType){
        return switch (splitType) {
            case EQUAL -> new EqualSplit();
            case UNEQUAL -> new UnEqualSplit();
            case PERCENT -> new PercentSplit();
        };
    }
}
