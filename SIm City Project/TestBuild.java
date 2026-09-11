
public class TestBuild extends Building {
    public void update(){

    }
    
} 

class Node <T extends Building>{
    private T value;
    private Node<? extends Building> left; 
    private Node<? extends Building> right; 
    private Node<? extends Building> up; 
    private Node<? extends Building> down; 
    
    public Node(T valueT){
        this.left = null;
        this.right =null;
        this.up = null;
        this.down = null;
        this.value = valueT;
    }
    
    // public void setNext
}

