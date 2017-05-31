
public class BinarySearchTreeTraversalImpl {
	
	
		public static void main(String args[]) {

			BinarySearchTreeImpl obj = new BinarySearchTreeImpl();
			obj.addNodeToTree(7);
			obj.addNodeToTree(1);
			obj.addNodeToTree(0);
			obj.addNodeToTree(3);
			obj.addNodeToTree(2);
			obj.addNodeToTree(5);
			obj.addNodeToTree(4);
			obj.addNodeToTree(6);
			obj.addNodeToTree(9);
			obj.addNodeToTree(8);
			obj.addNodeToTree(10);
		
		
			obj.preOrderTraversal();
			obj.inOrderTraversal();
			obj.postOrderTraversal();
		}
	}

