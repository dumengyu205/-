
public class Example08 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("1�����---------------------");
		add();
		System.out.println("2�����---------------------");
		remove();
		System.out.println("3�����---------------------");
		alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		sb.append("��С��");
		System.out.println("append��ӽ��:"+sb);
		sb.insert(2,"һ");
		System.out.println("insert��ӽ��:"+sb);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("��С��");
		sb.delete(1, 1);
		System.out.println("ɾ��ָ��λ�ý����"+sb);
		sb.deleteCharAt(2);
		System.out.println("ɾ��ָ��λ�ý����"+sb);
		sb.delete(0,sb.length());
		System.out.println("��ջ����������"+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("��С��");
		sb.setCharAt(1, '��');
		System.out.println("�޸�ָ��λ�ý����"+sb);
		sb.replace(1, 2, "��");
		System.out.println("�滻ָ��λ���ַ������������"+sb);
		System.out.println("�ַ�����ת�����"+sb.reverse());
	}

}
