package po;

public class BasicPlayerPO {
	private String name;		//��Ա����
	private String number;		//���º���
	private String position;	//���λ��
	private String height;		//���
	private String weight;		//����
	private String birth;		//����
	private String age;			//����
	private String exp;			//����
	private String school;		//��ҵѧУ
	
	public BasicPlayerPO(){
		name="";		//��Ա����
		number="";		//���º���
		position="";	//���λ��
		height="";		//���
		weight="";		//����
		birth="";		//����
		age="";			//����
		exp="";			//����
		school="";
	}
	public void setName(String n){
		this.name=n;
	}
	public String getName(){
		return name;
	}
	public void setNumber(String n){
		this.number = n;
	}
	public String getNumber(){
		return number;
	}
	public void setPosition(String p){
		this.position = p;
	}
	public String getPosition(){
		return position;
	}
	public void setHeight(String h){
		this.height = h;
	}
	public String getHeight(){
		return height;
	}
	public void setWeight(String w){
		this.weight = w;
	}
	public String getWeight(){
		return weight;
	}
	public void setBirth(String b){
		this.birth = b;
	}
	public String getBirth(){
		return birth;
	}
	public void setAge(String a){
		this.age = a;
	}
	public String getAge(){
		return age;
	}
	public void setExp(String e){
		this.exp = e;
	}
	public String getExp(){
		return exp;
	}
	public void setSchool(String s){
		this.school = s;
	}
	public String getSchool(){
		return school;
	}
}
