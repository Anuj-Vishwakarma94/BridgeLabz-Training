import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class SearchInBinaryTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // Helper method to insert into BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution obj = new Solution();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        TreeNode root = null;
        System.out.println("Enter BST node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = obj.insert(root, value);
        }

        System.out.print("Enter value to search: ");
        int target = sc.nextInt();

        TreeNode result = obj.searchBST(root, target);

        if (result != null) {
            System.out.println("Node found with value: " + result.val);
        } else {
            System.out.println("Node not found");
        }
    }
}
