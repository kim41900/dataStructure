package Section3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Code22 {
	static String[] words = new String[100000];
	static int[] count = new int [100000];
	static int n=0;
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.print("$");
			String commend = kb.next();
			if(commend.equals("read")){
				String fileName = kb.next();
				makeIndex(fileName);
			}
			else if(commend.equals("find")){
				String str = kb.next();
				int index = findWord(str);
				if(index>-1) {
					System.out.println("The Word" + words[index] +"appears"+count[index]+"times");
				}
				else
					System.out.println("The Word" + str +"does not appear.");
					
			}
			else if(commend.equals("saveas")) {
				String fileName = kb.next();
				saveAs(fileName);
				
			}
			else if(commend.equals("exit")) {
				break;	
			}
			
		}
		kb.close();
		for(int i=0;i<n;i++) {
			System.out.println(words[i]+ " " +count[i]);
		}
	}
	
	static void saveAs(String fileName) {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
			for(int i=0; i<n;i++)
				outFile.println(words[i]+ " " +count[i]);
			outFile.close();
		} catch (IOException e) {
			System.out.println("save failed");
			return;
		} 
	}
	static void makeIndex(String fileName) {
		
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNext()) {
				String str = inFile.next();
				addWord(str);
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
			return;
		}
		
	}
	static void addWord(String str) {//���� �ܾ��� �� 
		int index = findWord(str);//��ã���� -1����
		if(index != -1) {//ã�� word[index] ==str�̴�. 
			count[index]++;//�Ȱ��� �ܾ �����Ƿ� ��Ͽ� �߰��� �ʿ䰡 ����. 
		}//�ܾ��� ���� Ƚ���� 1���� �Ѵ�.
		else {//��ã��
			words[n] = str;
			count[n] = 1;
			n++;
		}
		
	}

	static int findWord(String str) {
		for(int i=0; i<n; i++) //i��° �ε����� ���� ã�� �ִ� �ܾ�� ���ٸ� 
			if(words[i].equals(str)) 
				return i;//i�� �����ϰ� �Լ��� ������ �����Ѵ�. 
		return -1; //���� �ܾ ã�� ���ߴ�.
			
		}
}
