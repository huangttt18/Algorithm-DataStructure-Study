package com.study.leetcode.everyday;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/14 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_208_实现Trie前缀树 {

    static class Trie {

        boolean isWord;
        Trie[] subNodes;

        /** Initialize your data structure here. */
        public Trie() {
            this.isWord = false;
            this.subNodes = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (root.subNodes[index] == null)
                    root.subNodes[index] = new Trie();
                root = root.subNodes[index];
            }
            root.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (root.subNodes[index] == null)
                    return false;
                root = root.subNodes[index];
            }
            return root != null && root.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (root.subNodes[index] == null)
                    return false;
                root = root.subNodes[index];
            }
            return true;
        }
    }

    static class Trie21 {

        final char INIT = ' ';

        class Node {
            char ch = INIT;
            boolean isWord;
            Node[] subNodes;

            Node(char ch) {
                this.ch = ch;
                this.isWord = false;
                this.subNodes = new Node[26];
            }
        }

        /**
         * 根节点：存储非字母元素
         */
        Node root;

        /** Initialize your data structure here. */
        public Trie21() {
            this.root = new Node(INIT);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            // 确定需要插入的位置[0...25]
            int insertStart = word.charAt(0) - 'a';
            insert(word, root, root.subNodes[insertStart], 0);
        }

        private void insert(String word, Node root, Node subNode, int startIndex) {
            if (startIndex == word.length() - 1) {
                subNode = new Node(word.charAt(startIndex));
                root.subNodes[word.charAt(startIndex) - 'a'] = subNode;
                subNode.isWord = true;
                return;
            }
            if (subNode == null) {
                // 此时表示当前subNode还未被插入过
                subNode = new Node(word.charAt(startIndex));
                root.subNodes[word.charAt(startIndex) - 'a'] = subNode;
            }
            insert(word, subNode, subNode.subNodes[word.charAt(startIndex + 1) - 'a'], startIndex + 1);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int searchStart = word.charAt(0) - 'a';
            return search(word, root.subNodes[searchStart], 0);
        }

        private boolean search(String word, Node subNode, int startIndex) {
            if (startIndex == word.length() - 1) {
                return subNode != null && subNode.isWord && subNode.ch == word.charAt(startIndex);
            }
            if (subNode == null)
                return false;
            return search(word, subNode.subNodes[word.charAt(startIndex + 1) - 'a'], startIndex + 1);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int searchStart = prefix.charAt(0) - 'a';
            return startsWith(prefix, root.subNodes[searchStart], 0);
        }

        private boolean startsWith(String prefix, Node subNode, int startIndex) {
            if (startIndex == prefix.length() - 1)
                return subNode != null && subNode.ch == prefix.charAt(startIndex);
            if (subNode == null)
                return false;
            return startsWith(prefix, subNode.subNodes[prefix.charAt(startIndex + 1) - 'a'], startIndex + 1);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("bear");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        boolean apple = trie.search("apps");
        boolean app = trie.search("app");
        System.out.println(apple);
        System.out.println(app);
    }
}
