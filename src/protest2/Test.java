package protest2;
import java.util.Scanner; 

class Exspression //存储输入的字符串
{		StringBuffer a;
		
	public StringBuffer in()
	{	Scanner input=new Scanner(System.in);
		StringBuffer a=new StringBuffer();
		a.append(input.nextLine());

		return a;
	}
	
}

class simplify//处理多项式进行代值，求导。
{		StringBuffer m;
	public	String out(StringBuffer str)
	{		
			
		
			//输入多项式
		if((str.indexOf("!simplify")==-1)&&(str.indexOf("!d/d")==-1))
			{
							//str.in(); 
							m = new StringBuffer(str);
							return str.toString();
			}
		
			//代值运算
		else if((str.indexOf("!simplify")!=-1)&&(str.indexOf("!d/d")==-1))
			{				String n=new String();
							n=m.toString().replace(str.toString().toCharArray()[10],
								str.toString().toCharArray()[12]);
							return n;
				
			}
			//求导运算
		else if((str.indexOf("!simplify")==-1)&&(str.indexOf("!d/d")!=-1))
			{ 				
							String o=new String();
							String fstr[]=new String[10];
							int q1=0;
							StringBuffer w=new StringBuffer();
							StringBuffer wout=new StringBuffer();
							o=m.toString();
							
					for(int i=0;i<=o.length();i++)
					{		
						if(i==o.length()){
							fstr[q1]=w.toString();
							w.setLength(0);
							q1++;
						}
						else if(o.toCharArray()[i]!='+')
						{
							w.append(o.toCharArray()[i]);
						}
						else
						{	
							fstr[q1]=w.toString();
							w.setLength(0);
							q1++;
						}
					}
					
					boolean flag=false;
					for(int j=0;j<q1;j++)
					{		
							int q2=0;
					
							for(int d=0;d<fstr[j].length();d++)
							{	
								if(fstr[j].toCharArray()[d]==str.toString().toCharArray()[4])
								{
									q2++;
								}
							}
							if(q2>0)
							{
								flag=true;
								for(int d=0;d<fstr[j].length();d++)
								{	
									if(fstr[j].toCharArray()[d]==str.toString().toCharArray()[4])
									{
										
													String s = (new Integer(q2)).toString();

										            for(int k=0;k<fstr[j].length();k++)
										            {
										            	if(k!=d){
										            	wout.append(fstr[j].toCharArray()[k]);
										            	}
										            	else{
										            		wout.append(s);
										            	}
										            }
										            
										            wout.append("+");
										            break;
										            
									}
								}
							}
							
					}
					if(!flag)
						//如果错误；
					{
						return "error,no variable!";
					}
					return wout.deleteCharAt(wout.length()-1).toString();
							
			
			}
		return null;
	}
}

public class Test {
	public static void main(String[] args)
	{		
			simplify result=new simplify();
			
			while(true)
			{	String outstr=new String();
				Exspression Form=new Exspression();
				
				outstr=result.out(Form.in());
				System.out.println(outstr);
			}
			
	
			
	
		
	}
}
