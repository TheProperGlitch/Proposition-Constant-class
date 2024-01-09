import java.util.Objects;

public class PropositionConstant {
    private String name;
    private boolean value;
    public PropositionConstant(String name, Boolean value){
        this.name=name;
        this.value=value;
    }

    public String toString(){
        String retval = "The proposition constant named " + name + " has a truth value of "+ value + ".";
        return retval;
    }

    public void toggle(){
        value = !value;
    }

    public boolean equals(PropositionConstant other){
     if ( (this.value && other.value) || ((!this.value)&&(!other.value))){
        return true;
     } else {
        return false;
     }
}

}
