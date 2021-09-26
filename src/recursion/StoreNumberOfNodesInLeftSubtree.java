package recursion;
/**
 你想要左孩子返回什么？左子树有多少nodes
 右孩子返回什么？右子树有多少nodes
 当前层做什么？在当前层只管左边的子树有多少个total nodes
 要汇报什么给上一层？左total加右total加自己一个
 */
public class StoreNumberOfNodesInLeftSubtree {
        public void numNodesLeft(TreeNodeLeft root) {
            numNodes(root);
        }
        private int numNodes(TreeNodeLeft root){
            //base case: 当root为null表示没有更多node可以处理的时候
            if (root == null) {
                return 0;
            }
            //左孩子返回左边subtree的node个数
            int left = numNodes(root.left);
            //右孩子返回右边subtree的node个数
            int right = numNodes(root.right);
            //当前层：把左子树返回的值挂树上， 然后左total加右total加自己一个
            root.numNodesLeft = left;
            return left + right + 1;
        }
    }
