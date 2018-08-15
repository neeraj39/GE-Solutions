import java.util.Scanner;

/**
 * Program to implement Binary tree
 *
 */
class BTNode{
	
	BTNode left,right;
	int data;
	
	/**
	 * @param data
	 */
	public BTNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	/**
	 * @return the left
	 */
	public BTNode getLeft() {
		return left;
	}
	/**
	 * @return the right
	 */
	public BTNode getRight() {
		return right;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BTNode left) {
		this.left = left;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BTNode right) {
		this.right = right;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
}
public class Tree {
	
	private BTNode root;
	
	/* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private BTNode insert(BTNode node, int data)
    {
        if (node == null)
            node = new BTNode(data);
        else
        {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);             
        }
        return node;
    }
    /* Function to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(BTNode r, int val)
    {
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;         
    }

	public static void main(String[] args) {
		Tree tree = new Tree();
		 Scanner scan = new Scanner(System.in);
		 char ch;
		 do{
			 System.out.println("\nBinary Tree Operations\n");
	            System.out.println("1. insert ");
	            System.out.println("2. search");
	            int choice = scan.nextInt();      
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                tree.insert( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to search");
	                System.out.println("Search result : "+ tree.search( scan.nextInt() ));
	                break; 
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;  
	            }
			 
			 System.out.println("\nDo You want to continue-- Yes or No\n");
			 ch=scan.next().charAt(0);
		 }while(ch =='y' ||ch =='Y');
		 scan.close();
	}

}
