package protest2;
import java.util.Scanner; 

class Exspression {
	//存储输入的字符串
	//private StringBuffer thisExpression;
	public StringBuffer in() {
		Scanner input = new Scanner(System.in);
		StringBuffer thisExpression = new StringBuffer();
		thisExpression.append(input.nextLine());
		//input.close();
		return thisExpression;
	}
	
}

class Simplify {
	//处理多项式进行代值，求导。
	private StringBuffer thisExpression;
	public	String out(final StringBuffer  inputString) {
		final int ten = 10;
		final int twelve = 12;
		final int four = 4;
		//输入多项式
		int searchSimplify = inputString.indexOf("!simplify");
		int searchDx = inputString.indexOf("!d/d");
		if ((searchSimplify == -1) 
				&& (searchDx == -1)) {
			//inputString.in(); 
			thisExpression = new StringBuffer(inputString);
			return inputString.toString();
		} else if ((searchSimplify != -1) 
				&& (searchDx == -1)) {
			//代值运算
			String n;
			n = thisExpression.toString().replace(
					inputString.toString().toCharArray()[ten],
					inputString.toString().toCharArray()[twelve]
							);
			return n;
		} else if ((searchSimplify == -1) 
				&& (searchDx != -1)) { 
			//求导运算
			String nowExpression = null;
			String[] fstr = new String[ten];
			int numOfAdd = 0;
			StringBuffer tempString = new StringBuffer();
			StringBuffer resultExpression = new StringBuffer();
			nowExpression = thisExpression.toString();
			for (int i = 0; i <= nowExpression.length(); i++) {		
				if (i == nowExpression.length()) {
					fstr[numOfAdd] = tempString.toString();
					tempString.setLength(0);
					numOfAdd++;
				} else if (nowExpression.toCharArray()[i] != '+') {
					tempString.append(nowExpression.toCharArray()[i]);
				} else {	
					fstr[numOfAdd] = tempString.toString();
					tempString.setLength(0);
					numOfAdd++;
				}
			}
			boolean flag = false;
			for (int j = 0; j < numOfAdd; j++) {		
				int numOfVar = 0;
				for (int d = 0; d < fstr[j].length(); d++) {	
					if (fstr[j].toCharArray()[d] 
							== inputString.toString().toCharArray()[four]) {
						numOfVar++;
					}
				}
				if (numOfVar > 0) {
					flag = true;
					for (int d = 0; d < fstr[j].length(); d++) {	
						if (fstr[j].toCharArray()[d] 
								== inputString.toString().toCharArray()[four]) {
							String numOfPow = (
									Integer.valueOf(numOfVar)).toString();
				            for (int k = 0; k < fstr[j].length(); k++) {
				            	if (k != d) {
				            resultExpression.append(fstr[j].toCharArray()[k]);
				            	} else {
				            		resultExpression.append(numOfPow);
				            	}
				            }  
				            resultExpression.append('+');
				            break;            
						}
					}
				}	
			}
			if (!flag) {
				return "error,no variable!";
			}
			return resultExpression.deleteCharAt(
					resultExpression.length() - 1).toString();	
		}
		return null;
	}
}

public class Test {
	public static void main(final String[] args) {		
		Simplify result = new Simplify();
		
		while (System.in != null) {	
			String outstr;
			Exspression form = new Exspression();
			outstr = result.out(form.in());
			System.out.println(outstr); // NOPMD by DYN on 16-10-11 下午8:44
		}	
	}
}