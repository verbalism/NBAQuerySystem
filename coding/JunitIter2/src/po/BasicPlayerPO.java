package po;

public class BasicPlayerPO {
	private String name;		//球员姓名
	private String number;		//球衣号码
	private String position;	//球队位置
	private String height;		//身高
	private String weight;		//体重
	private String birth;		//生日
	private String age;			//年龄
	private String exp;			//球龄
	private String school;		//毕业学校
	
	public BasicPlayerPO(){
		name="";		//球员姓名
		number="";		//球衣号码
		position="";	//球队位置
		height="";		//身高
		weight="";		//体重
		birth="";		//生日
		age="";			//年龄
		exp="";			//球龄
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
