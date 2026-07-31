/* Trie Node structure
class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndOfWord;
    public TrieNode() {
        for (int i = 0; i < 26; ++i) {
            children[i] = null;
        }
        isEndOfWord = false;
    }
} */

class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Insert
    public void insert(String key) {

        TrieNode current = root;

        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search
    public boolean search(String key) {

        // Root should always exist
        if (root == null) {
            return false;
        }

        TrieNode current = root;

        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Check if node has no children
    private boolean isEmpty(TrieNode node) {

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {
                return false;
            }
        }

        return true;
    }

    // Delete helper
    private TrieNode deleteHelper(
        TrieNode current,
        String key,
        int depth
    ) {

        if (current == null) {
            return null;
        }

        // Reached end of word
        if (depth == key.length()) {

            if (!current.isEndOfWord) {
                return current;
            }

            current.isEndOfWord = false;

            // Don't delete root
            if (depth == 0) {
                return current;
            }

            if (isEmpty(current)) {
                return null;
            }

            return current;
        }

        int index = key.charAt(depth) - 'a';

        // Character doesn't exist
        if (current.children[index] == null) {
            return current;
        }

        // Recursive delete
        current.children[index] =
            deleteHelper(current.children[index], key, depth + 1);

        // Don't delete root
        if (depth == 0) {
            return current;
        }

        // Delete useless node
        if (isEmpty(current) && !current.isEndOfWord) {
            return null;
        }

        return current;
    }

    // Delete
    public void deleteKey(String key) {

        root = deleteHelper(root, key, 0);

        // Safety: root should never be null
        if (root == null) {
            root = new TrieNode();
        }
    }
}