public class LogicalSentence {
    private PropositionConstant prop;
    private LogicalSentence logic;
    private boolean negation = false;

    //Constructor
    LogicalSentence(String str){
        //Input: String
        //Effect: Defines prop, logic, or/and negation
        if(!str.startsWith("~")){
            prop = new PropositionConstant(str, false);
        } else if (str.startsWith("~")) {
            negation = true;
            logic = new LogicalSentence(str.substring(1));
        }
    }

    boolean evaluate(TruthAssignment truth){
        if (!(logic == null)){
            return logic.evaluate(truth, negation);
        }else{
        //Input: TruthAssignment
        //Output: A boolean which is the value for prop in the TruthAssignment
        return !(truth.findTruth(prop) && negation) && (truth.findTruth(prop) || negation);
        }
    }

    boolean evaluate(TruthAssignment truth, boolean nBoolean){
        if (!(logic == null)){
            return logic.evaluate(truth, nBoolean);
        }else{
        //Input: TruthAssignment
        //Output: A boolean which is the value for prop in the TruthAssignment
        return !(truth.findTruth(prop) && nBoolean) && (truth.findTruth(prop) || nBoolean);
        }
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
