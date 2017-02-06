package ƽ�������;

import ���������.Test02.Node;

public class BalenceTree {
	public class Node{
		private int data;
		private Node leftNode;
		private Node rightNode;
		private int factor;//ƽ������
		
		public Node(){
			
		}
		public Node(int data,Node leftNode,Node rightNode,int factor){
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.factor = factor;
		}
		public Node(int data,Node leftNode,Node rightNode){
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		public int getFactor() {
			return factor;
		}
		public void setFactor(int factor) {
			this.factor = factor;
		}
	}
	
	private Node root;
	
	public int judgeFactor(Node node){
		if(node == null){
			return 0;
		}else{
			int left = judgeChildren(node.getLeftNode());
			int right = judgeChildren(node.getRightNode());
			return left - right;
		}
	}
	public int judgeChildren(Node node){
		if(node!=null){
			int left = 1;
			int right = 1;
			left += judgeChildren(node.getLeftNode());
			right += judgeChildren(node.getRightNode());
			return left>right?left:right;
		}else{
			return 0;
		}
	}
	//���Ԫ�صķ���
	public void add(int data){
		Node node = new Node(data,null,null);
		Node current = root;
		Node father = root;
		
		boolean flag = false;
		if(root == null){
			root = node;
		}else{
			while(current != null){
				father = current;
				if(current.getData() > data){
					current = current.getLeftNode();
					flag = false;
				}else if(current.getData() < data){
					current = current.getRightNode();
					flag = true;
				}else{
					return ;
				}
			}
			if(!flag){
				father.setLeftNode(node);
			}else{
				father.setRightNode(node);
			}
		}
		//Ϊ��ǰ��ÿһ��������ƽ�����ӵĸ�ֵ
		setFactory(root);
		//�жϵ�ǰ����ڵ���ǲ���ƽ���������
	}
	//����ÿһ������ƽ������
	public void setFactory(Node node){
		if(node!=null){
			int factory = judgeFactor(node);
			node.setFactor(factory);
			setFactory(node.getLeftNode());
			setFactory(node.getRightNode());
		}
	}
	
	public void judgeBalence(Node node){
		if(node.getFactor() == 2){
		}else if(node.getFactor() == -2){
			
		}
	}
	
	public static void main(String[] args){
		
	}
}
