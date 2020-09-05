
import java.util.List;
import java.util.Arrays;
import java.util.Queue; 
import java.util.PriorityQueue; 
import java.util.Stack;

public class IterativeDepth {

	private static String goal = "";

	//set the goal for the search
	public void setGoal(String node) {
		goal = node;
	}

	//see if the current node is the goal

	public static boolean isGoal(String node) {
		return node.equals(goal);
	}

	public static String getGoal() {
		return goal;
	}

	//returns the successor nodes as a List<String>
	public static List<String> successFunc(String node) {
		List myList;

		if (node.equals("A")) {
			String[] succ = {"C","B"};
			myList =  Arrays.asList(succ);
		}
		else if(node.equals("B")) {
			String[] succ = {"E","D"};
			myList =  Arrays.asList(succ);
		}
		else if(node.equals("C")) {
			String[] succ = {"G","F"};
			myList =  Arrays.asList(succ);
		}else {
			String[] succ = {};
			myList = Arrays.asList(succ);
		}

		return myList;
	}

	public static int depthNode(String node) {	
		if (node.equals("A")) return 0;
		else if (node.equals("B") || node.equals("C")) return 1;
		else if (node.equals("D") || node.equals("E") || node.equals("F") || node.equals("G")) return 2;
		else return -1;
	}

	public static boolean ITDepthSearch(int depth) {
		int x = 0;
		boolean result=true;
		while(x<=depth) {
			result = DFSLimit(x);
			if(result==true) {
				System.out.print("found " + goal);
				return true;
			}
			x++;
			System.out.println(":"+ goal+ " not found, "); 
		}
		
		return false;
	}


	public static boolean DFSLimit(int x) {
		var  myStack = new Stack<String>();
		myStack.push("A");
		while (!myStack.isEmpty()){
			String node = myStack.pop();
			System.out.print(node + " ");
			if(isGoal(node)) {
				return true;
			}
			if(depthNode(node)<x){
				List<String>successList = successFunc(node);
				for(int i=0; i<successList.size();i++) {
					String	newNode= successList.get(i);
					myStack.push(newNode);
				}
			}

		}		
		//your code here
		return false;
	}

	public static void main(String[] args) {

		//System.out.println(successFunc("A"));
		IterativeDepth idSearch = new IterativeDepth();
		idSearch.setGoal("G");
		idSearch.ITDepthSearch(2);
		//System.out.println();
		//blSearch.DFSTraversal();

	}//end of main

}//end of class
