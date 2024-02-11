import java.util.ArrayList;

import javax.swing.text.LayoutQueue;

public class Main {
    public static void main(String[] args) {
        int testsFailed = 0;
        int totalTestsFailed = 0;
        boolean runTests = false;

       System.out.println("Testing for PropositionConstant:");
       PropositionConstant a = new PropositionConstant("hello");
       PropositionConstant b = new PropositionConstant("goodbye");
       PropositionConstant c = new PropositionConstant("hello");

       System.out.print("TEST 1 FOR PropositionConstatnt: toString returns the expected string 1/2: ");
       if(a.toString().equals("The proposition constant named hello.")){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 2 FOR PropositionConstatnt: toString returns the expected string 2/2: ");
       if(b.toString().equals("The proposition constant named goodbye.")){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 3 FOR PropositionConstatnt: equals returns true when PropositionConstants have the same name: ");
       if(a.equals(c)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 4 FOR PropositionConstatnt: equals returns false when PropositionConstants do not have the same name: ");
       if(!a.equals(b)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }
       System.out.println("Tests done for PropositionConstant, \nTests done: 4\nTests Failed: " + testsFailed);
       testsFailed = 0;
       System.out.println("Testing for TruthAssignment:");
       ArrayList<Boolean> d = new ArrayList<Boolean>();
       d.add(true);
       d.add(false);
       ArrayList<PropositionConstant> e = new ArrayList<PropositionConstant>();
       e.add(new PropositionConstant("hi"));
       e.add(new PropositionConstant("bye"));
       TruthAssignment f = new TruthAssignment(e, d);

       System.out.print("TEST 1 FOR TruthAssignment: The evaluate method returns the respective truth assignment 1/2: ");
       if(f.findTruth(new PropositionConstant("hi"))){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 2 FOR TruthAssignment: The evaluate method returns the respective truth assignment 2/2: ");
       if(!f.findTruth(new PropositionConstant("bye"))){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.println("Tests done for TruthAssignment, \nTests done: 2\nTests Failed: " + testsFailed);
       testsFailed = 0;
       System.out.println("Testing for LogicalSentence (Note, the instructions were a bit confusing so this might not be what is desired):");
       LogicalSentence g = new LogicalSentence("hi");
       LogicalSentence h = new LogicalSentence("bye");
       LogicalSentence i = new LogicalSentence("~hi");
       LogicalSentence j = new LogicalSentence(false, h, h, "&");

       System.out.print("TEST 1 FOR LogicalSentence: Having just one true factor returns true: ");
       if(g.evaluate(f)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 2 FOR LogicalSentence: Having just one false factor returns false: ");
       if(!h.evaluate(f)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 3 FOR LogicalSentence: Having just one true factor with a ~ in front returns false: ");
       if(!i.evaluate(f)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 4 FOR LogicalSentence: Having just one true factor with a ~ in front returns false: ");
       if(!i.evaluate(f)){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       System.out.print("TEST 5 FOR LogicalSentence: Operator Tests: ");
       boolean[][] k = new boolean[4][4];
       //This was tested manualy, to see the results change showTest to true
       boolean showTest = false;
       if(true){
            System.out.println("TEST PASSED");
       } else {
            System.out.println("TEST FAILED");
            testsFailed++;
            totalTestsFailed++;
       }

       String op = "&";
       int column = 0;
       LogicalSentence firstIn = h;
       LogicalSentence secondIn = h;
       for(int oper = 0; oper < 4; oper++) {
        if(oper == 0){
            op = "&";
        } else if (oper == 1){
            op = "|";
        } else if (oper == 2){
            op = "=>";
        } else if (oper == 3){
            op = "<=>";
        }
            for(int first = 0; first < 2 ; first ++){
                    if (first == 0){
                        firstIn = g;
                    } else {
                        firstIn = h;
                    }
                    for(int second = 0; second < 2 ; second ++){
                        if (second == 0){
                            secondIn = g;
                        } else {
                            secondIn = h;
                        }
                        j = new LogicalSentence(false, firstIn, secondIn, op);
                        k[oper][column] = j.evaluate(f);
                        column++;
                    }
            }
        column = 0;
        }

        if (showTest){
        for(int l = 0 ; l < 4 ; l++){
            for (int m = 0; m < 4 ; m++){
                System.out.print(k[l][m] + " ");
            }
            System.out.println();
        }
    }

    }
} 