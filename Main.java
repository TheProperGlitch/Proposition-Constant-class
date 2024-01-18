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

        System.out.println("ALL TESTING DONE. RESULTS: \nTESTS DONE: 9\nTESTS FAILED: " + testsFailed);
    }
} 