package seminar.two.seminarTask;

import java.util.Stack;

/* Дано бинарное дерево, нужно найти и вернуть элемент, находящийся на максимальной глубине от корня дерева
 * */
public class DeepeestNode {

    Node root;

    public class Node{

        int val;
        Node left;
        Node right;

        public void printNode(Node node) { // Вывод значения узла в консоль
            System.out.println(" Выбранный узел имеет значение :" + node.val);
        }
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + val +
                    ", leftChild=" + left +
                    ", rightChild=" + right +
                    '}';
        }
    }

    public Node getDeepestNode(){

        int maxDepth = getMaxDepth(this.root);
        return findDeepestNode(this.root,maxDepth);

    }

    private Node findDeepestNode(Node node, int depth){
        if(node == null) return null;
        if(depth == 1) return node;

        // двигаемся по левой стороне и уменьшаем глубину на 1 каждый раз
        Node result = findDeepestNode(node.left,depth - 1);
        if(result != null) return result;
        // двигаемся по правой стороне и уменьшаем глубину на 1 каждый раз
        return findDeepestNode(node.right,depth - 1);
    }

    private int getMaxDepth(Node node){
        if(node == null) return 0;
        // каждый раз при проходе в левую или правую ноду увеличиваем глубину на 1(также ищется сразу максимальное кол
        // -во элементов с правой или левой стороны)
        return 1 + Math.max(getMaxDepth(node.left),getMaxDepth(node.right));
    }

    public void addNode(int value){
        Node newNode = new Node();
        newNode.val = value;
        if(root == null) root = newNode;
        else{

            Node currentNode = root;
            Node parentNode; //родительские ноды узлов дерева
            while(true){

                parentNode = currentNode;
                //если элемент уже есть в дереве, то не сохраняем и не добавляем его в дерево и просто выходим из метода
                if(currentNode.val == value) return;
                // движение влево
                else if(value < currentNode.val){
                    currentNode = currentNode.left;

                    //если был достигнут конец цепочки, то вставляем влево и выходим из метода
                    if(currentNode == null){
                        parentNode.left = newNode;
                        return;
                    }
                }else{
                    // движение вправо
                    currentNode = currentNode.right;

                    //если был достигнут конец цепочки, то вставляем влево и выходим из метода
                    if(currentNode == null){
                        parentNode.right = newNode;
                        return;
                    }
                }

            }
        }
    }
    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.val); // выводим его значение в консоли
                    localStack.push(temp.left); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}
