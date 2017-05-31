/**
 * @author srikanth
 * 
 * 
 * 
 */
public class BinarySearchTreeImpl {

	public BSTreeNode root;

	public BinarySearchTreeImpl() {
		root = null;
	}

	/**
	 * We are using recursion process. Reason: We are maintain levels (Root
	 * level, internal level,child level.. ) hence, each level process should be
	 * same, so we are using recursion.
	 * 
	 * we are creating two methods for adding because, user will send you the
	 * node data. as we know that, this is recursive process, we need to add
	 * element based on the root element.
	 * 
	 * if following method is executing one time then it will return root
	 * element at level-1 [Root element] if the following method is executing
	 * two times then it will return root element at level-2 [Root element-->
	 * right or left child] if the following method is executing 3 times then it
	 * will return root element at level-3 [Root element(L1)-->Root
	 * element(L2)---> right or left child]
	 * 
	 * @param nodeData
	 */
	public void addNodeToTree(int nodeData) {
		root = add(root, nodeData);

	}

	/**
	 * step 1: Check root is null or not, if it is null then create a node as a
	 * root and insert data
	 * 
	 * step 2: If root is not null, then Compare the newdata to root data,
	 * 
	 * condition 1: If root data > new data then Make a root.left child as
	 * "root"; and recursive call add method Passing the root.left and node data
	 * to add method.
	 * 
	 * condition 2: If root data < new data then Make a root.right child as
	 * "root"; and recursive call add method Passing the root.right and node
	 * data to add method.
	 * 
	 * 
	 * @param root
	 * @param nodeData
	 * @return
	 */
	private BSTreeNode add(BSTreeNode root, int nodeData) {
		if (root == null) {
			root = new BSTreeNode(nodeData);

		} else if (root.getNodeData() > nodeData) {
			root.leftChild = add(root.leftChild, nodeData);
		} else if (root.getNodeData() < nodeData) {
			root.rightChild = add(root.rightChild, nodeData);
		}
		return root;
	}

	public boolean find(int searchElement) {

		return search(root, searchElement);
	}

	/**
	 * Step 1: Check root is null or not. If it is null then return from the
	 * method.
	 * 
	 * Step 2: If it is not all, compare search element with root. Condition 1:
	 * root is > search element. Then make a root.Leftchildnode(as NewRoot) Pass
	 * values in to search method(Recursive call) Condition 2: root is < search
	 * element. Then make a root.Righttchildnode(as NewRoot) Pass values in to
	 * search method(Recursive call)
	 * 
	 * step 3: Process step-2 until the both condition get false (i.e you found
	 * your search element) then return search Element.
	 * 
	 * @param root
	 * @param searchElement
	 * @return
	 */
	public boolean search(BSTreeNode root, int searchElement) {

		boolean found = false;

		while (root != null && !found) {

			if (root.getNodeData() > searchElement) {
				root = root.leftChild;
			} else if (root.getNodeData() < searchElement) {
				root = root.rightChild;
			} else {
				found = true;
				break;
			}
			found = search(root, searchElement);
		}

		return found;

	}

	/**
	 * Step 1: Visit Root.(i.e return(Print) the root)
	 * 
	 * Step 2: Traverse left sub-tree in Pre-order
	 * 
	 * Step 3: Traverse Right sub-tree in Pre-order.
	 * 
	 * 
	 * Tip : Root --- > Left --- > Right
	 * 
	 * 
	 * 
	 */
	public void preOrderTraversal() {

		System.out.println("Pre-Order Traversal");

		startPreOrderProcess(root);

	}

	private void startPreOrderProcess(BSTreeNode root) {

		if (root == null)
			return;

		System.out.print("("+root.getNodeData()+") .");
		startPreOrderProcess(root.leftChild);
		startPreOrderProcess(root.rightChild);
	}

	/**
	 * Step 1: Traverse left sub-tree in In-order.
	 * 
	 * Step 2: Visit Root.(i.e return(Print) the root)
	 * 
	 * Step 3: Traverse Right sub-tree in In-order.
	 * 
	 * Tip : Left --- > Root --- > Right
	 * 		 Free-fall;
	 * 
	 */
	public void inOrderTraversal() {

		System.out.println("\n\nIn-Order Traversal");

		startInOrderProcess(root);

	}

	private void startInOrderProcess(BSTreeNode root) {

		if (root == null)
			return;

		startInOrderProcess(root.leftChild);
		System.out.print("("+root.getNodeData()+") .");
		startInOrderProcess(root.rightChild);

	}

	/**
	 * step 1: Traverse left sub-tree in Pre-order.
	 * 
	 * Step 2: Traverse Right sub-tree in Pre-order.
	 * 
	 * Step 3:Visit Root.(i.e return(Print) the root)
	 * 
	 * * Tip : Left --- > Right --- > Root 
	 *         (leaf-Break)
	 * 
	 */
	public void postOrderTraversal() {
		System.out.println("\n\nPost-Order Traversal");
		startPostOrderProcess(root);
	}

	private void startPostOrderProcess(BSTreeNode root) {

		if (root == null)
			return;

		startPostOrderProcess(root.leftChild);
		startInOrderProcess(root.rightChild);
		System.out.print("("+root.getNodeData()+") .");
	}
}
