package po;

/**����������Ա��������*/
public class MatchPlayer {
	private String playerName;
	private String position;
	private String matchTime;		//�ϳ�ʱ��
	private int fieldGoal;		//Ͷ��������
	private int fieldGoalAttempts;		//Ͷ��������
	private int threepointShot;			//����������
	private int threepointAttempts;	//���ֳ�����
	private int freeThrowGoal;			//����������
	private int freeThrowAttempts;		//���������
	private int offensiveRebound;		//����������
	private int defensiveRebound;		//����������
	private int rebound;		//������
	private int assist;			//������
	private int st;				//������
	private int blockShot;		//��ñ��
	private int error;			//ʧ����
	private int foul;			//������
	private int score;			//���˵÷�
	
	public void setPlayerName(String n){
		this.playerName = n;
	}
	public String getPlayerName(){
		return playerName;
	}
	public void setPosition(String p){
		this.position = p;
	}
	public String getPosition(){
		return position;
	}
	public void setMatchTime(String m){
		this.matchTime = m;
	}
	public String getMatchTime(){
		return matchTime;
	}
	public void setFieldGoal(int f){
		this.fieldGoal = f;
	}
	public int getFieldGoal(){
		return fieldGoal;
	}
	public void setFieldGoalAttempts(int f){
		this.fieldGoalAttempts = f;
	}
	public int getFieldGoalAttempts(){
		return fieldGoalAttempts;
	}
	public void setThreePointShot(int t){
		this.threepointShot = t;
	}
	public int getThreePointShot(){
		return threepointShot;
	}
	public void setThreePointAttempts(int t){
		this.threepointAttempts = t;
	}
	public int getThreePointAttempts(){
		return threepointAttempts;
	}
	public void setFreeThrowGoal(int t){
		this.freeThrowGoal = t;
	}
	public int getFreeThrowGoal(){
		return freeThrowGoal;
	}
	public void setFreeThrowAttempts(int t){
		this.freeThrowAttempts = t;
	}
	public int getFreeThrowAttempts(){
		return freeThrowAttempts;
	}
	public void setOffensiveRebound(int r){
		this.offensiveRebound = r;
	}
	public int getOffensiveRebound(){
		return offensiveRebound;
	}
	public void setDefensiveRebound(int r){
		this.defensiveRebound = r;
	}
	public int getDefensiveRebound(){
		return defensiveRebound;
	}
	public void setRebound(int r){
		this.rebound = r;
	}
	public int getRebound(){
		return rebound;
	}
	public void setAssist(int r){
		this.assist = r;
	}
	public int getAssist(){
		return assist;
	}
	public void setST(int r){
		this.st = r;
	}
	public int getST(){
		return st;
	}
	
	public void setBlockShot(int r){
		this.blockShot = r;
	}
	public int getBlockShot(){
		return blockShot;
	}
	public void setError(int r){
		this.error = r;
	}
	public int getError(){
		return error;
	}
	public void setFoul(int r){
		this.foul = r;
	}
	public int getFoul(){
		return foul;
	}
	public void setScore(int r){
		this.score = r;
	}
	public int getScore(){
		return score;
	}
}
