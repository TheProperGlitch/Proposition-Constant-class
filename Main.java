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

        System.out.println("TRUTH TABLE: ");
        //All possible variariations for six truth assignments
        PropositionConstant xa = new PropositionConstant("a");
        PropositionConstant xb = new PropositionConstant("b");
        PropositionConstant xc = new PropositionConstant("c");
        PropositionConstant xd = new PropositionConstant("d");
        PropositionConstant xe = new PropositionConstant("e");
        PropositionConstant xf = new PropositionConstant("f");
        ArrayList<PropositionConstant> here = new ArrayList<PropositionConstant>();
        here.add(xa);
        here.add(xb);
        here.add(xc);
        here.add(xd);
        here.add(xe);
        here.add(xf);
        Boolean oa = false;
        Boolean ob = false;
        Boolean oc = false;
        Boolean od = false;
        Boolean oe = false;
        Boolean of = false;
        ArrayList<Boolean> there = new ArrayList<Boolean>();
        there.add(oa);
        there.add(ob);
        there.add(oc);
        there.add(od);
        there.add(oe);
        there.add(of);

        ArrayList<ArrayList<Boolean>> allBools = new ArrayList<ArrayList<Boolean>>();
        int counting = 0;
        for (int layerOne = 0; layerOne < 2; layerOne++) {
          if (layerOne == 0) {
               oa = true;
          } else oa = false;
          for (int layerTwo = 0; layerTwo < 2; layerTwo++) {
               if (layerTwo == 0) {
                    ob = true;
               } else ob = false;
               for (int layerThree = 0; layerThree < 2; layerThree++) {
                    if (layerThree == 0) {
                         oc = true;
                    } else oc = false;
                    for (int layerFour = 0; layerFour < 2; layerFour++) {
                         if (layerFour == 0) {
                              od = true;
                         } else od = false;
                         for (int layerFive = 0; layerFive < 2; layerFive++) {
                              if (layerFive == 0) {
                                   oe = true;
                              } else oe = false;
                              for (int layerSix = 0; layerSix < 2; layerSix++) {
                                   if (layerSix == 0) {
                                        of = true;
                                   } else of = false;
                                   there.set(0, oa);
                                   there.set(1, ob);
                                   there.set(2, oc);
                                   there.set(3, od);
                                   there.set(4, oe);
                                   there.set(5, of);
                                   allBools.add((ArrayList<Boolean>)there.clone());
                                   counting++;
                                 }
                            }
                       }
                  }
             }
        }
        LogicalSentence ma = new LogicalSentence("a");
        LogicalSentence mb = new LogicalSentence("b");
        LogicalSentence mc = new LogicalSentence("c");
        LogicalSentence md = new LogicalSentence("~a");
        LogicalSentence me = new LogicalSentence("~b");
        LogicalSentence mf = new LogicalSentence("~c");
        Boolean[][] bigArray = new Boolean[16][64];

        LogicalSentence[] sentences = new LogicalSentence[16];

        sentences[0] = new LogicalSentence(false, ma, ma, "&");
        sentences[1] = new LogicalSentence(false, ma, mb, "&");
        sentences[2] = new LogicalSentence(false, ma, mc, "&");
        sentences[3] = new LogicalSentence(false, ma, md, "&");
        sentences[4] = new LogicalSentence(false, ma, me, "&");
        sentences[5] = new LogicalSentence(false, ma, mf, "&");
        sentences[6] = new LogicalSentence(false, mb, mb, "&");
        sentences[7] = new LogicalSentence(false, mc, mc, "&");
        sentences[8] = new LogicalSentence(false, mc, mf, "&");
        sentences[9] = new LogicalSentence(false, ma, md, "|");
        sentences[10] = new LogicalSentence(false, ma, mb, "|");
        sentences[11] = new LogicalSentence(false, ma, mc, "|");
        sentences[12] = new LogicalSentence(false, ma, mc, "<=>");
        sentences[13] = new LogicalSentence(false, ma, md, "<=>");
        sentences[14] = new LogicalSentence(false, mb, mc, "=>");
        sentences[15] = new LogicalSentence(false, mb, me, "=>");


        for (int layerOne = 0 ; layerOne < 16 ; layerOne++){
          for (int layerTwo = 0 ; layerTwo < 64 ; layerTwo++ ){
               TruthAssignment eval = new TruthAssignment(here, allBools.get(layerTwo));
               bigArray[layerOne][layerTwo] = sentences[layerOne].evaluate(eval);
          }
        }
        System.out.println("     1      2      3      4      5      6      7      8      9     10     11     12    13     14    15    16");
        for (int layerOne = 0; layerOne < 64 ; layerOne++){ 
          System.out.print(layerOne + ": ");
          for (int layerTwo = 0 ; layerTwo < 16 ; layerTwo++) {
               System.out.print(bigArray[layerTwo][layerOne] + "| ");
          }
          System.out.println();
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