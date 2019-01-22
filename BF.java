package com.z;
/**
 * 
 * @author 张玉彬
 *BF算法，主串和子串匹配
 */
public class BF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdefghijk";//i
		String s2 = "cdefg";//j
		int i,j,k = 0;
		boolean flag = false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for(i=0,j=0;j<c2.length;)
		{
			if(c1[i]==c2[j])
			{
				if(!flag) {
					k = i;
					flag = true;
				}
				i++;
				j++;
			}else {
				i++;
			}
		}
		int s = k + j-1;
		System.out.println(k+"-->"+s);
	}

}
