package ������;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {
	public Node root;
	public int treePath = 0;//��������·��
	public int number = 0; //�������нڵ����
	//����һ�������� ����
	public void add(String data){
		Node node = new Node(data,null,null);
		Node parent = root;
		Node current = root;
		boolean flag = true;
		//�жϸ��ڵ��Ƿ���ֵ
		if(root == null){
			root = node;
		}else{
			//һֱ�жϵ�ǰ�ȽϽڵ��Ƿ�Ϊ�գ�Ϊ�յĻ��Ϳ��Խ��в�����
			while(current !=null){
				parent = current;
				//����С�ڸ��ڵ�
				if(data.compareTo(current.getData())<0){
					current = current.getLeftNode();
					flag = true;
				//������ڸ��ڵ�
				}else if(data.compareTo(current.getData())>0){
					current = current.getRightNode();
					flag = false;
				//����������ֵ�򲻲���
				}else{
					return ;
				}
			}
			if(flag){
				current = node;
				parent.setLeftNode(current);
			}else{
				current = node;
				parent.setRightNode(current);
			}
		}
	}
	//��ǰ���еĽڵ����
	public int size(Node root){
		if(root == null){
			return 0;
		}else{
			size(root.getLeftNode());
			size(root.getRightNode());
			return ++number;
		}
	}
	//ǰ�����
	public void search_DLR(Node root){
		if(root != null){
			System.out.print(root.getData()+" ");
			search_DLR(root.getLeftNode());
			search_DLR(root.getRightNode());
		}
	}
	//�������
	public void search_LDR(Node root){
		if(root !=null){
			search_LDR(root.getLeftNode());
			System.out.print(root.getData()+" ");
			search_LDR(root.getRightNode());
		}
	}
	//�������
	public void search_LRD(Node root){
		if(root !=null){
			search_LRD(root.getLeftNode());
			search_LRD(root.getRightNode());
			System.out.print(root.getData()+" ");
		}
	}
	//�ǵݹ�ʽ���������
	
	public void search_LDRL2(Node root){
		//��ʱ�Ľڵ� ����ָ��ǰ�����Ľڵ�
		Node temp = root;
		//����һ��ջ�ѽڵ������һ��һ��ѹ���ȥ��ֱ����ǰ�ڵ�Ϊ��
		Stack<Node> stack = new Stack<Node>();
		while(temp != null || !stack.isEmpty()){
			//��ǰ�ڵ㲻Ϊ�յ�ʱ��ѹջ
			if(temp!=null){
				stack.push(temp);
				temp = temp.getLeftNode();
			}else{
				//���ڵ�Ϊ��ʱջ����ֵ��ʱ���ջ��Ԫ���������
				temp = stack.pop();
				//��������Ľڵ����� ��ʱ����������һ��������ߺ��ӵĽڵ�
				System.out.print(temp.getData()+" ");
				//֮���õ�ǰ�ڵ�ָ�������ӵ��Һ����ٴν����ж�
				temp = temp.getRightNode();
			}
		}
	}
	//�ǵݹ�������
	public void search_LRDl2(Node root){
		Node temp = root;
		//ʵ�ʲ�����ջ
		Stack<Node> stack = new Stack<Node>();
		//�洢������ݵ�ջ
		Stack<Node> output = new Stack<Node>();
		while(temp!=null || !stack.isEmpty()){
			if(temp!=null){
				output.push(temp);
				stack.push(temp);
				temp = temp.getRightNode();
			}else{
				temp = stack.pop();
				temp = temp.getLeftNode();
			}
		}
		while(output.size()>0){
			System.out.print(output.pop().getData()+" ");
		}
	}
	//������б���
	/*
	 * ����˼·���ǰ����ֽڵ���뵽linkedlistģ��Ķ�����ȥ
	 * ��ͷԪ���Ƴ���ͬʱ���������Һ��Ӳ��뵽���е���ȥ ����еĻ�
	 * �������Ͻ���������� ����ͷ����ͬʱ���ͷ���֪������Ϊ�� �������
	 */
	public void search_level(Node root){
		//�����ݴ浽һ���������� ��������������ģ�����
		LinkedList<Node> list = new LinkedList<Node>();
		Node node  = root;
		Node result = null;
		//�ȰѸ��ڵ�����ȥ �жϸ��ڵ��Ƿ���ֵ
		if(node != null){
			list.add(node);
			//�������ڵ�ֵ
			result = list.poll();
			//�����жϵ����ڵ�ķ���ֵ ���û�нڵ����򵯳�null ����ֹ�ж�
			while(result!=null){
				System.out.print(result.getData()+" ");
				//�жϵ�ǰ�����е�һ��Ԫ���Ƿ������Һ��������������뵽������
				if(node.getLeftNode()!=null){
					list.addLast(node.getLeftNode());
				}
				if(node.getRightNode()!=null){
					list.addLast(node.getRightNode());
				}
				//��ǰ���в�Ϊ��ʱ node����ʼ��ָ�����ͷԪ��
				if(list.size() != 0){
					node = list.getFirst();
				}
				//����ͷԪ�ز�ѭ���ж����Ƿ�Ϊ���Ƿ������Һ���
				result = list.poll();
			}
		}
		else{
			System.out.println("��ǰΪ����");
		}
	}
	//���ҵ�ǰ������� ������ڵ�Ϊ�������Ϊ0 �����Ϊ�� �ݹ�������Һ��ӱȽ�˭��˭��ͷ���˭
	public int search_depth(Node root){
		if(root == null){
			return 0;
		}else{
			int left = 1;
			int right = 1;
			left += search_depth(root.getLeftNode());
			right += search_depth(root.getRightNode());
			return left>right?left:right;
		}
	}
	//��ӡ���е�ǰ��������·��
	//����Ϊ�����ڵ㣬�洢�������飬����·�����ȵ����α���
	//��ʾ �����α���size������ʮ����Ҫ
	public void printWay(Node root,String[] path,int size){
		//������ڵ�Ϊ��ֱ�ӷ���
		if(root == null){
			return ;
		}
		//��Ϊ�հѸ��ڵ�洢�����鵱��
		path[size++] = root.getData();
		//�����߼��жϣ�����ǰ����ǲ���Ҷ�ӽ�� �����Ҷ�ӽ�� ���ճ���Ϊ size���д�ӡ��ǰ����
		if(root.getLeftNode()==null&&root.getRightNode()==null){
			System.out.println("·��"+(++treePath)+"Ϊ");
			for(int i=0;i<size;i++){
				System.out.print(path[i]+" ");
			}
			System.out.println();
			//�������Ҷ�ӽ��ݹ��ȥ�����������в�ֵ
		}else{
			printWay(root.getLeftNode(),path,size);
			printWay(root.getRightNode(),path,size);
		}
	}
	//��ȡĳһԪ�صĽ�� �������Ӻ��Һ���
	public Node searchByData(String data){
		Node node = this.root;
		Node result = null;
		if(node.getData().equals(data)){
			result = node;
		}else{
			//�жϵ�ǰ�ڵ���Ŀ��ڵ�Ĵ�С��ֵ 
			while(node!=null && node.getData().compareTo(data)<0){
				node = node.getRightNode();
			}
			while(node!=null && node.getData().compareTo(data)>0 ){
				node = node.getLeftNode();
			}
			if(node !=null){
				result = node;
			}
		}
		return result;
	}

	public static void main(String[] args){
		//���Դ���
		Tree tree = new Tree();
		tree.add("4");
		tree.add("6");
		tree.add("2");
		tree.add("3");
		tree.add("7");
		tree.add("8");
		tree.add("5");
		System.out.println("ǰ�����");
		tree.search_DLR(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.search_LDR(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.search_LRD(tree.getRoot());
		System.out.println();
		System.out.println("�������");
		tree.search_level(tree.getRoot());
		System.out.println();
		System.out.println("�ǵݹ��������");
		tree.search_LDRL2(tree.getRoot());
		System.out.println();
		System.out.println("�ǵݹ�������");
		tree.search_LRDl2(tree.getRoot());
		System.out.println();
		System.out.println("��ǰ�������");
		System.out.println(tree.search_depth(tree.getRoot()));
		System.out.println("����ĳһԪ��");
		Node node = tree.searchByData("6");
		if(node!=null){
			System.out.println("��ǰԪ��Ϊ"+node.getData());
			if(node.getLeftNode()!=null){
			System.out.println("����Ϊ+"+node.getLeftNode().getData());
			}
			if(node.getRightNode()!=null){
				System.out.println("�Һ���Ϊ"+node.getRightNode().getData());
			}
		}else{
			System.out.println("��ǰԪ�ز�����");
		}
		System.out.println("��ӡ����·��");
		String[] path = new String[100];
		tree.printWay(tree.getRoot(), path, 0);
		System.out.println("��ǰ�ڵ�ĸ���");
		int size = tree.size(tree.getRoot());
		System.out.println(size);
	}

	public Node getRoot() {
		return root;
	}
	
}
