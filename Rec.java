import java.io.File;
import java.util.ArrayList;

public class Rec {

	public static void main(String args[]) {
		// Test recursive Max method
		int[] test = { 23, 4, 5, 1, 2, 10, 11 }; // sum should be 20
		System.out.println("Max(test) = " + Max(test));
		
		// Test recursive FileSize
		String rootDirectory = ".";
		System.out.println("FileSize() = " + FileSize(new File(rootDirectory)));
		
		// Test recursive JavaFiles
		System.out.println(JavaFiles(new File(rootDirectory)));
	}

	public static int Max(int[] arr) {
		return Max(arr, 0, arr.length - 1);
	}

	private static int Max(int[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		} else {
			int mid = (start + end) / 2;
			int leftMax = Max(arr, start, mid);
			int rightMax = Max(arr, mid + 1, end);
			return Math.max(leftMax, rightMax);
		}
	}

	public static long FileSize(File f){
		if (!f.isDirectory()){
			return f.length();
		}
		else {
			long sumOfDirectory = 0;
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++)
				sumOfDirectory += FileSize(files[i]);
			return sumOfDirectory;
			
		}
	}
	
	public static ArrayList<String> JavaFiles(File f){
		ArrayList<String> list = new ArrayList<String>();
		return JavaFiles(f, list);
	}
	
	private static ArrayList<String> JavaFiles(File f, ArrayList<String> l){
		if (!f.isDirectory()){
			if (f.getName().contains(".java"))
				l.add(f.getName());
			return l;
		}
		
		else {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++){
				l = JavaFiles(files[i], l);
			}
			return l;
		}
	}
	
}