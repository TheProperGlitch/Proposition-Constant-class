import java.util.ArrayList;

public class TruthAssignment{
    private ArrayList<PropositionConstant> pConstants;
    private ArrayList<Boolean> bConstants;
    public TruthAssignment(ArrayList<PropositionConstant> pInput, ArrayList<Boolean> bInput){
        pConstants = pInput;
        bConstants = bInput;
    }
    
    public boolean findTruth(PropositionConstant searchFor){
        int pPosition = -1;
        for (int i = 0; i < pConstants.size() ; i++){
            if(pConstants.get(i).equals(searchFor)){
                pPosition = i;
            }
        }
        return bConstants.get(pPosition);
    }

    
}
