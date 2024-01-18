public class TruthAssignment{
    private PropositionConstant[] pConstants;
    private boolean[] bConstants;
    public TruthAssignment(PropositionConstant[] pInput, boolean[] bInput){
        pConstants = pInput;
        bConstants = bInput;
    }
    public boolean findTruth(PropositionConstant searchFor){
        int pPosition = -1;
        for (int i = 0; i < pConstants.length ; i++){
            if(pConstants[i] == searchFor){
                pPosition = i;
            }
        }
        return bConstants[pPosition];
    }
}
