package po;

public class TeamInfoPO {
	private String fullName;		//球队全名
	private String abbreviation;	//缩写
	private String city;			//所在地
	private String zone;			//赛区
	private String subarea;			//分区
	private String homeCourt;		//主场
	private String createTime;		//创建时间

	public void setFullName(String n){
		this.fullName = n;
	}
	public String getFullName(){
		return fullName;
	}
	public void setAbbreviation(String a){
		this.abbreviation = a;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
	public void setCity(String c){
		this.city = c;
	}
	public String getCity(){
		return city;
	}
	public void setZone(String z){
		this.zone = z;
	}
	public String getZone(){
		return zone;
	}
	public void setSubarea(String s){
		this.subarea = s;
	}
	public String getSubarea(){
		return subarea;
	}
	public void setHomeCourt(String h){
		this.homeCourt = h;
	}
	public String getHomeCourt(){
		return homeCourt;
	}
	public void setCreateTime(String c){
		this.createTime = c;
	}
	public String getCreateTime(){
		return createTime;
	}
}


