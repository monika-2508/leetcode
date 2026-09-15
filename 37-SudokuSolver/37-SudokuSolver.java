// Last updated: 9/15/2026, 9:26:29 AM
1import java.util.Arrays;
2import java.util.LinkedList;
3import java.util.Queue;
4
5public class Codec {
6    private static final String NULL_NODE = "null";
7    private static final String DELIMITER = ",";
8
9    // Encodes a tree to a single string.
10    public String serialize(TreeNode root) {
11        StringBuilder sb = new StringBuilder();
12        serializeHelper(root, sb);
13        return sb.toString();
14    }
15
16    private void serializeHelper(TreeNode node, StringBuilder sb) {
17        if (node == null) {
18            sb.append(NULL_NODE).append(DELIMITER);
19            return;
20        }
21        sb.append(node.val).append(DELIMITER);
22        serializeHelper(node.left, sb);
23        serializeHelper(node.right, sb);
24    }
25
26    // Decodes your encoded data to tree.
27    public TreeNode deserialize(String data) {
28        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
29        return deserializeHelper(nodes);
30    }
31
32    private TreeNode deserializeHelper(Queue<String> nodes) {
33        if (nodes.isEmpty()) return null;
34        
35        String val = nodes.poll();
36        if (val.equals(NULL_NODE)) {
37            return null;
38        }
39
40        TreeNode node = new TreeNode(Integer.parseInt(val));
41        node.left = deserializeHelper(nodes);
42        node.right = deserializeHelper(nodes);
43        return node;
44    }
45}