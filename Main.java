public class Main {
    public static void main(String[] args) {
        int testsFailed = 0;
        int totalTestsFailed = 0;
        System.out.println("TEST CODE FOR PropositionConstant:");
        PropositionConstant x = new PropositionConstant("Hello", true);
        PropositionConstant y = new PropositionConstant("Goodbye", false);
        System.out.println("TEST 1: THE toString METHOD FOR PropositionConstant RETURNS THE INTENDED STRING FOR A PropositionConstant \nWITH THE NAME \"Hello\" AND THE VALUE true.");
        if (x.toString().equals("The proposition constant named Hello has a truth value of true.")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 2: THE toString METHOD FOR PropositionConstant RETURNS THE INTENDED STRING FOR A PropositionConstant \nWITH THE NAME \"Goodbye\" AND THE VALUE false.");
        if (y.toString().equals("The proposition constant named Goodbye has a truth value of false.")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 3: THE toggle METHOD FOR PropositionConstant FLIPS THE VALUE OF PropositionConstant x FROM TRUE TO FALSE.");
        x.toggle();//x should be false
        if (x.toString().equals("The proposition constant named Hello has a truth value of false.")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 4: THE toggle METHOD FOR PropositionConstant FLIPS THE VALUE OF PropositionConstant x FROM FALSE TO TRUE.");
        x.toggle();//x should be true
        if (x.toString().equals("The proposition constant named Hello has a truth value of true.")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 5: THE equals METHOD FOR PropositionConstant COMPARES TWO PropositionConstants WITH VALUE true CORRECTLY.");
        y.toggle();//y should be true
        if (x.equals(y)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 6: THE equals METHOD FOR PropositionConstant COMPARES TWO PropositionConstants WITH DIFFERENT VALUES CORRECTLY.");
        x.toggle();//x should be false
        if (!x.equals(y)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 7: THE equals METHOD FOR PropositionConstant COMPARES TWO PropositionConstants WITH VALUE false CORRECTLY.");
        y.toggle();
        if (x.equals(y)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TESTING FOR PropositionConstant DONE. \nTOTAL TESTS: 7\nFAILURES: " + testsFailed);



        totalTestsFailed = testsFailed;
        testsFailed = 0;
        System.out.println("TEST CODE FOR TruthAssignment:");
        PropositionConstant one = new PropositionConstant("this", true);
        PropositionConstant two = new PropositionConstant("that", false);
        PropositionConstant three = new PropositionConstant("where", true);
        boolean[] boolList = {false,true,true};
        PropositionConstant[] propList = {one,two,three};
        TruthAssignment test = new TruthAssignment(propList, boolList);
        System.out.println("TEST 1: THE findTruth METHOD FOR TruthAssignment RETURNS THE INTENDED RESULT FOR THE FIRST \nPropositionConstant IN THE LIST");
        if (!test.findTruth(one)){
            System.out.println("TEST PASSED");
        }else { 
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 2: THE findTruth METHOD FOR TruthAssignment RETURNS THE INTENDED RESULT FOR THE SECOND \nPropositionConstant IN THE LIST");
        if(test.findTruth(two)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TESTING FOR TruthAssignment DONE. \nTOTAL TESTS: 2\nFAILURES: " + testsFailed);




        totalTestsFailed+= testsFailed;
        testsFailed = 0;
        System.out.println("TEST CODE FOR LogicalSentence:");
        System.out.println("TEST 1: MAKING A LogicalSentence WITHOUT ANY TILDES MAKES A PropositionConstant");
        LogicalSentence a = new LogicalSentence("p");
        if(a.getProp().getName().equals("p")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        System.out.println("TEST 2: MAKING A LogicalSentence WITHOUT ANY TILDES MAKES NEGATION FALSE");
        if(!a.getNegation()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }
        
        System.out.println("TEST 3: THE EVALUATE METHOD WORKS AS EXPECTED 1/4");
        PropositionConstant test3Constant = new PropositionConstant("p", false);
        PropositionConstant[] test3List = {test3Constant};
        boolean[] test3booleans = {false};
        TruthAssignment test3Assignment = new TruthAssignment(test3List, test3booleans);
        if(!a.evaluate(test3Assignment)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }


        System.out.println("TEST 4: THE EVALUATE METHOD WORKS AS EXPECTED 2/4");
        boolean[] test4booleans = {true};
        test3Assignment = new TruthAssignment(test3List, test4booleans);
        if(a.evaluate(test3Assignment)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }

        LogicalSentence b = new LogicalSentence("~p");

        System.out.println("TEST 5: MAKING A LogicalSentence WITH TILDES MAKES A LogicalSentence");
        if(b.getLogic().getProp().getName().equals("p")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }

        System.out.println("TEST 6: MAKING A LogicalSentence WITH TILDES MAKES NEGATION TRUE");
        if(b.getNegation()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }

        System.out.println("TEST 7: THE EVALUATE METHOD WORKS AS EXPECTED 3/4");
        test3Assignment = new TruthAssignment(test3List, test3booleans);
        if(b.evaluate(test3Assignment)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }

        System.out.println("TEST 8: THE EVALUATE METHOD WORKS AS EXPECTED 4/4");
        test3Assignment = new TruthAssignment(test3List, test4booleans);
        if(!b.evaluate(test3Assignment)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            testsFailed++;
        }

        System.out.println("TESTING FOR PropositionConstant DONE. \nTOTAL TESTS: 8\nFAILURES: " + testsFailed);
        totalTestsFailed+= testsFailed;
        testsFailed = 0;

        
        System.out.println("ALL TESTING DONE. RESULTS: \nTESTS DONE: 17\nTESTS FAILED: " + totalTestsFailed);
    }
} 