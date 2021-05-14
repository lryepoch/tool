package com.da.graph;

import java.util.Stack;

public class DFS {
	// 顶点数组
	private Vertex[] vertexList;
	// 邻接矩阵
	private int[][] adjMat;
	// 顶点的最大数目
	private int maxSize = 20;
	// 当前顶点个数
	private int nVertex;
	// 栈
	private Stack stack;

	public class Vertex {
		public char label;
		public boolean wasVisited;

		public Vertex(char label) {
			this.label = label;
			// wasVisited=false;
		}
	}

	// 对邻接矩阵初始化，都为零。
	public DFS() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		// 初始化顶点个数为0
		nVertex = 0;
		// 初始化邻接矩阵所有元素都为0，即所有顶点都没有边
		for (int i = 0; i < maxSize; i++) {
			for (int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		stack = new Stack();
	}

	/**
	 * 添加顶点。将顶点添加到数组中，是否访问标志置为wasVisited=false(未访问)
	 */
	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}

	/**
	 * 添加边。注意用邻接矩阵表示边，是对称的，两部分都要赋值
	 */
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	/**
	 * 寻找当前未访问过的邻接点
	 */
	public int getadjUnvisitedVertex(int v) {
		for (int i = 0; i < nVertex; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	/**深度优先搜索算法:
     * 1、用peek()方法检查栈顶的顶点
     * 2、用getAdjUnvisitedVertex()方法找到当前栈顶点邻接且未被访问的顶点
     * 3、第二步方法返回值不等于-1则找到下一个未访问的邻接顶点，访问这个顶点，并入栈
     *    如果第二步方法返回值等于 -1，则没有找到，出栈
     */
	public void dfs() {
		// 首先访问0号顶点
		vertexList[0].wasVisited = true;
		// 显示该顶点
		displayVertex(0);
		// 压入栈中
		stack.push(0);
		while (!stack.isEmpty()) {
			// 获得一个【当前栈顶结点】未访问过的邻接点
			int v = getadjUnvisitedVertex((Integer) stack.peek());
			if (v == -1) {
				// 弹出一个顶点
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;// 改为已访问过
				displayVertex(v);// 显示
				stack.push(v);// 压入栈
			}
		}

		// 搜索完以后，要将访问信息修改,初始化，以便于下次搜索
		for (int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;// 改为未被访问过
		}

	}

	public static void main(String[] args) {
		DFS g = new DFS();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		g.dfs();
	}

}
