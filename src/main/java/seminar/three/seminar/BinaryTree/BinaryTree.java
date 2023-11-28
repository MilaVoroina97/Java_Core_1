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


        return false;
    }
}
