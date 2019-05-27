package C08Stack;

public class SimpleBrowser {

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SimpleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("currentPage is: " + this.currentPage);
    }

    public void open(String url) {
        if(this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    public String goBack() {
        if(this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind");
        return null;
    }

    public String goForward() {
        if(this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;
        }
        System.out.println("* Cannot go forward, no pages forward");
        return null;
    }

    public static void main(String[] args) {
        SimpleBrowser browser = new SimpleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    public static class LinkedListBasedStack {
        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            size = 0;
        }

        public int size() {
            return this.size;
        }

        public String getTopData() {
            if(this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        public String pop() {
            Node popNode = this.top;
            if(popNode == null) {
                System.out.println("Stack is empty");
                return null;
            }
            this.top = top.next;
            if(this.size > 0) {
                this.size--;
            }
            return popNode.data;
        }

        public void printAll() {
            System.out.print("Print Stack:");
            Node currentNode = this.top;
            while(currentNode != null) {
                System.out.print(currentNode.data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        public static class Node {
            private String data;
            private Node next;

            public Node(String data) {
                this.data = data;
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
    }
}
