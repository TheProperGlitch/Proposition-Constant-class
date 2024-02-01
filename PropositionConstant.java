public class PropositionConstant {
    private String name;
    public PropositionConstant(String name){
        this.name=name;
    }

    public String toString(){
        String retval = "The proposition constant named "+ name +".";
        return retval;
    }

    public boolean equals(PropositionConstant other){
        return this.name.equals(other.name);
     }

     //The following code is only for testing
    
     public String getName(){
       return name; 
     }

}

