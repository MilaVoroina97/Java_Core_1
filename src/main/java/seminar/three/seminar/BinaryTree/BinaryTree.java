package seminar.three.seminar.BinaryTree;

public class BinaryTree {

    // Обертка над классом `Node`
    static class NodeWrapper
    {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    // Функция для проверки, присутствует ли данный узел в бинарном дереве или нет
    public static boolean isPresentNode(Node root,Node node){
        if(root == null) return false;
        // если узел найден, возвращаем true
        if(root == node) return true;
        // вернуть true, если данный узел найден в левом или правом поддереве
        return isPresentNode(root.left,node) || isPresentNode(root.right, node);
    }

    // Функция для поиска наименьшего общего предка заданных узлов `x` и `y`, где
    // в бинарном дереве присутствуют как `x`, так и `y`.
    // Функция возвращает true, если `x` или `y` найдены в поддереве с корнем
    // `lca` —> сохраняет `LCA(x, y)`

    public static boolean findLCA(Node root, NodeWrapper lca,Node n1, Node n2){

        if(root == null) return false;
        // базовый вариант 2: вернуть true, если найдено либо `x`, либо `y`
        if(root == n1 || root == n2) {
            // устанавливаем lca на текущий узел
            lca.node = root;
            return true;
        }
        // рекурсивно проверяем, существует ли `x` или `y` в левом поддереве
        boolean left = findLCA(root.left,lca,n1,n2);
        // рекурсивно проверяем, существует ли `x` или `y` в правом поддереве
        boolean right = findLCA(root.right,lca,n1,n2);
        // если `x` найдено в одном поддереве, а `y` найдено в другом поддереве,
        // обновить lca до текущего узла
        if(left && right) lca.node = root;
        // вернуть true, если `x` или `y` найдены либо в левом, либо в правом поддереве
        return left || right;
    }

    // Функция для поиска наименьшего общего предка узлов `x` и `y`
    public static void findLCA(Node root, Node n1, Node n2){

        // `lca` хранит самого младшего общего предка
        Node lca = null;
        // Обернуть узел `lca`, чтобы его ссылку можно было изменить внутри
        // метод `findLCA()`
        NodeWrapper LCA = new NodeWrapper(lca);
        // вызываем LCA-процедуру, только если в дереве присутствуют и `x`, и `y`
        if(isPresentNode(root,n2) && (isPresentNode(root,n1))){
            findLCA(root,LCA,n1,n2);
            lca = LCA.node;
        }

        // если LCA существует, вывести его
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        }
        else {
            System.out.println("LCA does not exist");
        }

    }
    public static void main(String[] args)
    {
        /* Построим следующее дерево
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new Node(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }
}
