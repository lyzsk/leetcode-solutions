import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/02/09
 **/
public class AuthenticationManager {
    private int timeToLive;
    private Node head;
    private Node tail;
    private Map<String, Node> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tokens = new HashMap<>(16);
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(tokenId, currentTime + timeToLive);
        tokens.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId) && tokens.get(tokenId).expire > currentTime) {
            Node node = tokens.get(tokenId);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime) {
            Node node = head.next;
            tokens.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }
        return tokens.size();
    }
}

class Node {
    public int expire;
    public String key;
    public Node prev;
    public Node next;

    public Node(int expire) {
        this.expire = expire;
        this.key = null;
        this.prev = null;
        this.next = null;
    }

    public Node(String key, int expire) {
        this.key = key;
        this.expire = expire;
        this.prev = null;
        this.next = null;
    }

    public Node(String key, int expire, Node prev, Node next) {
        this.key = key;
        this.expire = expire;
        this.prev = prev;
        this.next = next;
    }
}
