package cn.zhang.sort.innerType;

public class StringCompare implements java.util.Comparator<String>{
	/**
	 * �����ȱȽ�
	 * ����>
	 * ����<
	 * 0==
	 */
	@Override
	public int compare(String o1, String o2) {
		int len1 = o1.length();
		int len2 = o2.length();
		return len1-len2;
	}
	
}
