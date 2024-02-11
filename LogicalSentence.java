public class LogicalSentence {
    private PropositionConstant prop;
    private LogicalSentence logic;
    private boolean negation = false;
    private String operation;
    private LogicalSentence x;
    private LogicalSentence y;

    //Constructor
    LogicalSentence(String str){
        //Input: String
        //Effect: Defines prop, logic, or/and negation
        if(!str.startsWith("~")){
            prop = new PropositionConstant(str);
        } else if (str.startsWith("~")) {
            negation = true;
            logic = new LogicalSentence(str.substring(1));
        }
    }

    LogicalSentence(boolean negated, LogicalSentence a, LogicalSentence b, String op){
        if(negated){
            negation = true;
            if(a == null){
                logic = b;
            } else {
                logic = a;
            }
        } else {
        operation = op;
        x = a;
        y = b;
        }
    }

    boolean evaluate(TruthAssignment truth){
        boolean baseValue;
        if (!(operation == null || operation.equals(""))){
            if (operation.equals("&")){
                baseValue = x.evaluate(truth) && y.evaluate(truth);
            } else if (operation.equals("|")){
                baseValue = x.evaluate(truth) || y.evaluate(truth);
            } else if (operation.equals("<=>")){
                if(x.evaluate(truth)){
                    baseValue = y.evaluate(truth);
                } else {
                    baseValue = !y.evaluate(truth);
                }
            } else if (operation.equals("=>")){
                baseValue = !x.evaluate(truth) || y.evaluate(truth);
            } else {
                System.out.println("ERROR");
                baseValue = false;
            }
        } else {
            if (!(logic == null)){
                baseValue = logic.evaluate(truth);
            } else {
                baseValue = truth.findTruth(prop);
            }
             if (negation){
                baseValue = !baseValue;
            }
        }
        return baseValue;
    }


    //These methods are just to make testing easy
    PropositionConstant getProp(){
        return prop;
    }
    LogicalSentence getLogic(){
        return logic;
    }
    boolean getNegation(){
        return negation;
    }
}
