package po;

public class PlayerPO {
	private String playerName;//��Ա����
	private String number;		//���º���
	private String position;	//���λ��
	private String height;		//���
	private String weight;		//����
	private String birth;		//����
	private String age;			//����
	private String exp;			//����
	private String school;		//��ҵѧУ
	private String teamName;//�������
	private int gamesPlayed;//��������
	private int gamesStarting;//�ȷ�����
	private double rebounds;//������
	private double offensiveRebounds;//����������
	private double defensiveRebounds;//����������
	private double assists;//������
	private double minutes;//�ڳ�ʱ��
	private double fieldGoalsAttempts;//Ͷ��������
	private double fieldGoalsMade;//Ͷ��������
	private double fieldGoalsPercentage;//Ͷ��������
	private double threePointFieldGoalsAttempts;//���ֳ�����
	private double threePointFieldGoalsMade;//����������
	private double threePointFieldGoalsPercentage;//����������
	private double freeThrowsAttempts;//���������
	private double freeThrowsMade;//����������
	private double freeThrowsPercentage;//����������
	private double steals;//������
	private double blocks;//��ñ��
	private double turnovers;//ʧ����
	private double fouls;//������
	private double points;//�÷�
	private double efficiency;//Ч��
	private double GmSc;//GmScЧ��ֵ
	private double trueShootingPercentage;//��ʵ������
	private double shootingEfficiency;//Ͷ��Ч��
	private double reboundRating;//������
	private double offensiveReboundRating;//����������
	private double defensiveReboundRating;//����������
	private double assisyRating;//������
	private double stealRating;//������
	private double blockRating;//��ñ��
	private double turnoverRating;//ʧ����
	private double utilizationRating;//ʹ����
	private double doubleDouble; //��˫
	private double increaseOfPoints;//���峡�÷�������
	private double increaseOfRebounds;//���峡����������
	private double increaseOfAssists;//���峡����������
	private String playerID;//��Աid
	
	public PlayerPO(){
		gamesPlayed=0;//��������
		gamesStarting=0;//�ȷ�����
		rebounds=0;//������
		minutes=0;//�ϳ�ʱ��
		assists=0;//������
		fieldGoalsAttempts=0;//Ͷ��������
		fieldGoalsMade=0;//Ͷ��������
		fieldGoalsPercentage=0;//Ͷ��������
		threePointFieldGoalsAttempts=0;//���ֳ�����
		threePointFieldGoalsMade=0;//����������
		threePointFieldGoalsPercentage=0;//����������
		freeThrowsAttempts=0;//���������
		freeThrowsMade=0;//����������
		freeThrowsPercentage=0;//����������
		offensiveRebounds=0;//����������
		defensiveRebounds=0;//����������
		steals=0;//������
		blocks=0;//��ñ��
		turnovers=0;//ʧ����
		fouls=0;//������
		points=0;//�÷�
		efficiency=0;//Ч��
		GmSc=0;//GmScЧ��ֵ
		trueShootingPercentage=0;//��ʵ������
		shootingEfficiency=0;//Ͷ��Ч��
		reboundRating=0;//������
		offensiveReboundRating=0;//����������
		defensiveReboundRating=0;//����������
		assisyRating=0;//������
		stealRating=0;//������
		blockRating=0;//��ñ��
		turnoverRating=0;//ʧ����
		utilizationRating=0;//ʹ����
		doubleDouble=0;//��˫
		setIncreaseOfPoints(0);//���峡�÷�������
		setIncreaseOfRebounds(0);//���峡����������
		setIncreaseOfAssists(0);//���峡����������
		playerID="";//��Աid
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesStarting() {
		return gamesStarting;
	}

	public void setGamesStarting(int gamesStarting) {
		this.gamesStarting = gamesStarting;
	}

	public double getRebounds() {
		return rebounds;
	}

	public void setRebounds(double rebounds) {
		this.rebounds = rebounds;
	}

	public double getAssists() {
		return assists;
	}

	public void setAssists(double assists) {
		this.assists = assists;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage;
	}

	public void setFieldGoalsPercentage(double fieldGoalsPercentage) {
		this.fieldGoalsPercentage = fieldGoalsPercentage;
	}

	public double getThreePointFieldGoalsPercentage() {
		return threePointFieldGoalsPercentage;
	}

	public void setThreePointFieldGoalsPercentage(double threePointFieldGoalsPercentage) {
		this.threePointFieldGoalsPercentage = threePointFieldGoalsPercentage;
	}

	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage;
	}

	public void setFreeThrowsPercentage(double freeThrowsPercentage) {
		this.freeThrowsPercentage = freeThrowsPercentage;
	}

	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public void setOffensiveRebounds(double offenses) {
		this.offensiveRebounds = offenses;
	}

	public double getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public void setDefensiveRebounds(double defenses) {
		this.defensiveRebounds = defenses;
	}

	public double getSteals() {
		return steals;
	}

	public void setSteals(double steals) {
		this.steals = steals;
	}

	public double getBlocks() {
		return blocks;
	}

	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}

	public double getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(double turnovers) {
		this.turnovers = turnovers;
	}

	public double getFouls() {
		return fouls;
	}

	public void setFouls(double fouls) {
		this.fouls = fouls;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	public double getGmSc() {
		return GmSc;
	}

	public void setGmSc(double gmSc) {
		GmSc = gmSc;
	}

	public double getTrueShootingPercentage() {
		return trueShootingPercentage;
	}

	public void setTrueShootingPercentage(double trueShootingPercentage) {
		this.trueShootingPercentage = trueShootingPercentage;
	}

	public double getShootingEfficiency() {
		return shootingEfficiency;
	}

	public void setShootingEfficiency(double shootingEfficiency) {
		this.shootingEfficiency = shootingEfficiency;
	}

	public double getReboundRating() {
		return reboundRating;
	}

	public void setReboundRating(double reboundRating) {
		this.reboundRating = reboundRating;
	}

	public double getOffensiveReboundRating() {
		return offensiveReboundRating;
	}

	public void setOffensiveReboundRating(double offensiveReboundRating) {
		this.offensiveReboundRating = offensiveReboundRating;
	}

	public double getDefensiveReboundRating() {
		return defensiveReboundRating;
	}

	public void setDefensiveReboundRating(double defensiveReboundRating) {
		this.defensiveReboundRating = defensiveReboundRating;
	}

	public double getAssisyRating() {
		return assisyRating;
	}

	public void setAssisyRating(double assisyRating) {
		this.assisyRating = assisyRating;
	}

	public double getStealRating() {
		return stealRating;
	}

	public void setStealRating(double stealRating) {
		this.stealRating = stealRating;
	}

	public double getBlockRating() {
		return blockRating;
	}

	public void setBlockRating(double blockRating) {
		this.blockRating = blockRating;
	}

	public double getTurnoverRating() {
		return turnoverRating;
	}

	public void setTurnoverRating(double turnoverRating) {
		this.turnoverRating = turnoverRating;
	}

	public double getUtilizationRating() {
		return utilizationRating;
	}

	public void setUtilizationRating(double utilizationRating) {
		this.utilizationRating = utilizationRating;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getDoubleDouble() {
		return doubleDouble;
	}

	public void setDoubleDouble(double doubleDouble) {
		this.doubleDouble = doubleDouble;
	}

	public double getFieldGoalsAttempts() {
		return fieldGoalsAttempts;
	}

	public void setFieldGoalsAttempts(double fieldGoalsAttempts) {
		this.fieldGoalsAttempts = fieldGoalsAttempts;
	}

	public double getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public void setFieldGoalsMade(double fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}

	public double getThreePointFieldGoalsAttempts() {
		return threePointFieldGoalsAttempts;
	}

	public void setThreePointFieldGoalsAttempts(double threePointFieldGoalsAttempts) {
		this.threePointFieldGoalsAttempts = threePointFieldGoalsAttempts;
	}

	public double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public void setThreePointFieldGoalsMade(double threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}

	public double getFreeThrowsAttempts() {
		return freeThrowsAttempts;
	}

	public void setFreeThrowsAttempts(double freeThrowsAttempts) {
		this.freeThrowsAttempts = freeThrowsAttempts;
	}

	public double getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public void setFreeThrowsMade(double freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}

	public double getIncreaseOfPoints() {
		return increaseOfPoints;
	}

	public void setIncreaseOfPoints(double increaseOfPoints) {
		this.increaseOfPoints = increaseOfPoints;
	}

	public double getIncreaseOfRebounds() {
		return increaseOfRebounds;
	}

	public void setIncreaseOfRebounds(double increaseOfRebounds) {
		this.increaseOfRebounds = increaseOfRebounds;
	}

	public double getIncreaseOfAssists() {
		return increaseOfAssists;
	}

	public void setIncreaseOfAssists(double increaseOfAssists) {
		this.increaseOfAssists = increaseOfAssists;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

}