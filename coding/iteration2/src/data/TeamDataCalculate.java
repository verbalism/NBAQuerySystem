package data;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import po.BasicTeamPO;

public class TeamDataCalculate{
		public String[]m={"fieldGoalsMade","fieldGoalsAttempted","threePointFieldGoalsMade","threePointFieldGoalsAttempted"
			,"freeThrowsMade","freeThrowsAttempted","offensiveRebounds","defensiveRebounds","rebounds","assists","steals","blocks","turnovers","fouls","points"};
		public String[]oppm={"oppFieldGoalsMade","oppFieldGoalsAttempted","oppFreeThrowsAttempted","oppTurnovers","oppSteals","oppAssists","oppOffensiveRebounds","oppDefensiveRebounds","oppPoints"};
	 
	 public void BasicTeamOriginal() throws Exception{  
		 	//在数据库中读入球队基本信息
		 
		 	File f=new File("");
		 	String s=f.getCanonicalPath();
		 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	        Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	        ArrayList<BasicTeamPO> btp=new BasicTeamData().getTeamOriginal();
	        for(int i=0;i<btp.size();i++){
	        	 String sql = "insert into teamInfo (teamName,fullName,city,zone,subarea,homeCourt,createTime) values(?,?,?,?,?,?,?)";
	        	 PreparedStatement pstmt;
	        	 pstmt = (PreparedStatement) conn.prepareStatement(sql);
	             pstmt.setString(1, btp.get(i).getAbbreviation());
	             pstmt.setString(2, btp.get(i).getFullName());
	             pstmt.setString(3, btp.get(i).getCity());
	             pstmt.setString(4, btp.get(i).getZone());
	             pstmt.setString(5, btp.get(i).getSubarea());
	             pstmt.setString(6, btp.get(i).getHomeCourt());
	             pstmt.setString(7, btp.get(i).getCreateTime());
	             pstmt.executeUpdate();
	             pstmt.close();
	        } 
	        conn.close();  
	        System.out.println("球队基本信息已读入");
	 }
	 
	 
	 public void addSingleMatchTeam(int MatchID){
		 	//添加一场新的比赛信息
		 TeamDataCalculate tdc=new TeamDataCalculate();
		 
		 
		 try {
			 for(int i=0;i<m.length;i++){
				 tdc.updateKnown(MatchID,m[i]);
			 }
			 for(int j=0;j<oppm.length;j++){
				 tdc.updateOppKnown(MatchID,oppm[j]);
			 }
			 tdc.updateGamesPlayed(MatchID);
			 tdc.updateGamesPlayedWin(MatchID);
			 tdc.updateFGP(MatchID);
			 tdc.updateTFGP(MatchID);
			 tdc.updateFTP(MatchID);
			 tdc.updateWP(MatchID);
			 tdc.updatePossessions(MatchID);
			 tdc.updateRating(MatchID);
			 tdc.updateRP(MatchID);
			 tdc.updateSA(MatchID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//基本信息加入	 
		 
	 }
	 
	 public void deleteAllTeam()throws Exception{
		 File f=new File("");
		 	String s=f.getCanonicalPath();
		 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	        Connection conn = DriverManager.getConnection(dbur1, "username", "password"); 
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate("delete * from teamInfo");
			
			stmt.close();
			conn.close();
			
	 }
	 
	 public void updateAllTeam(){
		 //更新所有信息（从头遍历比赛）
		 TeamDataCalculate tdc=new TeamDataCalculate();
		 String teamName="";
		 
		 try {
			 File f=new File("");
			 String s=f.getCanonicalPath();
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
		     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
		     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
		     Statement stmt = conn.createStatement();  
		     
		     ResultSet rs = stmt.executeQuery("select * from teamInfo");
		     while(rs.next()){
		    	 teamName=rs.getString("teamName");
		    	 tdc.updateAllKnown(teamName);
		    	 tdc.updateGamesPlayed(teamName);
		    	 tdc.updateAllPercentage(teamName);
		     }
			 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 System.out.println("球队更新完成");
		 
	 }
	 
	 public void updateAllKnown(String teamName)throws Exception{
		 
		 //根据球队名称更新投篮数等已知信息
		 double fieldGoalsMade=0,fieldGoalsAttempted=0,threePointFieldGoalsMade=0,threePointFieldGoalsAttempted=0,freeThrowsMade=0,freeThrowsAttempted=0,offensiveRebounds=0,defensiveRebounds=0,rebounds=0,assists=0,steals=0,blocks=0,turnovers=0,fouls=0,points=0;
		 double oppFieldGoalsMade=0,oppFieldGoalsAttempted=0,oppFreeThrowsAttempted=0,oppTurnovers=0,oppSteals=0,oppAssists=0,oppOffensiveRebounds=0,oppDefensiveRebounds=0,oppPoints=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from playerMatchInfo where teamName='"+teamName+"'");
	     while(rs.next()){
	    	 fieldGoalsMade=fieldGoalsMade+rs.getDouble("fieldGoal");
	    	 fieldGoalsAttempted=fieldGoalsAttempted+rs.getDouble("fieldGoalAttempts");
	    	 threePointFieldGoalsMade=threePointFieldGoalsMade+rs.getDouble("threepointShot");
	    	 threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+rs.getDouble("threepointAttempts");
	    	 freeThrowsMade=freeThrowsMade+rs.getDouble("freeThrowGoal");
	    	 freeThrowsAttempted=freeThrowsAttempted+rs.getDouble("freeThrowAttempts");
	    	 offensiveRebounds=offensiveRebounds+rs.getDouble("offensiveRebound");
	    	 defensiveRebounds=defensiveRebounds+rs.getDouble("defensiveRebound");
	    	 rebounds=rebounds+rs.getDouble("rebound");
	    	 assists=assists+rs.getDouble("assist");
	    	 steals=steals+rs.getDouble("st");
	    	 blocks=blocks+rs.getDouble("blockShot");
	    	 turnovers=turnovers+rs.getDouble("error");
	    	 fouls=fouls+rs.getDouble("foul");
	    	 points=points+rs.getDouble("score");
	     }
	     rs = stmt.executeQuery("select * from playerMatchInfo where oppositeTeamName='"+teamName+"'");
	     while(rs.next()){
	    	 oppFieldGoalsMade=oppFieldGoalsMade+rs.getDouble("fieldGoal");
	    	 oppFieldGoalsAttempted=oppFieldGoalsAttempted+rs.getDouble("fieldGoalAttempts");
	    	 oppFreeThrowsAttempted=oppFreeThrowsAttempted+rs.getDouble("freeThrowAttempts");
	    	 oppTurnovers=oppTurnovers+rs.getDouble("error");
	    	 oppSteals=oppSteals+rs.getDouble("st");
	    	 oppAssists=oppAssists+rs.getDouble("assist");
	    	 oppOffensiveRebounds=oppOffensiveRebounds+rs.getDouble("offensiveRebound");
	    	 oppDefensiveRebounds=oppDefensiveRebounds+rs.getDouble("defensiveRebound");
	    	 oppPoints=oppPoints+rs.getDouble("score");
	     }
	     rs.close();
	     stmt.executeUpdate("update teamInfo set fieldGoalsMade="+fieldGoalsMade+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set fieldGoalsAttempted="+fieldGoalsAttempted+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set threePointFieldGoalsMade="+threePointFieldGoalsMade+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set threePointFieldGoalsAttempted="+threePointFieldGoalsAttempted+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set freeThrowsMade="+freeThrowsMade+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set freeThrowsAttempted="+freeThrowsAttempted+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set offensiveRebounds="+offensiveRebounds+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set defensiveRebounds="+defensiveRebounds+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set rebounds="+rebounds+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set assists="+assists+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set steals="+steals+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set blocks="+blocks+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set turnovers="+turnovers+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set fouls="+fouls+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set points="+points+" where teamName='"+teamName+"'");     
	     stmt.executeUpdate("update teamInfo set oppFieldGoalsMade="+oppFieldGoalsMade+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppFieldGoalsAttempted="+oppFieldGoalsAttempted+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppFreeThrowsAttempted="+oppFreeThrowsAttempted+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppTurnovers="+oppTurnovers+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppSteals="+oppSteals+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppAssists="+oppAssists+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppOffensiveRebounds="+oppOffensiveRebounds+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppDefensiveRebounds="+oppDefensiveRebounds+" where teamName='"+teamName+"'");	     
	     stmt.executeUpdate("update teamInfo set oppPoints="+oppPoints+" where teamName='"+teamName+"'");
	     
	     stmt.close();
	     conn.close();
	 }
	 
	 public int getMaxMatchID()throws Exception{
		 //获得最大的比赛ID
		 int result=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from generalMatchInfo");
	     while(rs.next()){
	    	 result++;
	     }
	     rs.close();
	     stmt.close();
	     conn.close();
	     return result;
	 }
	 
	 public void updateGamesPlayed(int MatchID)throws Exception{
		 //根据比赛ID修改参赛球队的gamesPlayed（比赛场数）
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");
	     int gp1=0,gp2=0;
	     while(rs.next()){
	    	 gp1=rs.getInt("gamesPlayed");
	     }
	     gp1=gp1+1;
	     rs=stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 gp2=rs.getInt("gamesPlayed");
	     }
	     gp2=gp2+1;
	     rs.close();
	     stmt.executeUpdate("update teamInfo set gamesPlayed="+gp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set gamesPlayed="+gp2+" where teamName='"+team2+"'");
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateGamesPlayedWin(int MatchID)throws Exception{
		 //添加胜场信息根据一场比赛的ID
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     double fgm1=0,fgm2=0;
	     String score="";
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 fgm1=rs.getInt("gamesPlayedWin");
	     }
	     rs=stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 fgm2=rs.getInt("gamesPlayedWin");
	     }
	     rs=stmt.executeQuery("select * from generalMatchInfo where ID="+MatchID);
	     while(rs.next()){
	    	 score=rs.getString("score");
	     }
	     String[] aaa=score.split("-");
	     if(Integer.parseInt(aaa[0])>Integer.parseInt(aaa[1])){
	    	 fgm1=fgm1+1;
	     }
	     else{
	    	 fgm2=fgm2+1;
	     }
	     
	     rs.close();
	     stmt.executeUpdate("update teamInfo set gamesPlayedWin="+fgm1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set gamesPlayedWin="+fgm2+" where teamName='"+team2+"'");
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateGamesPlayed(String teamName)throws Exception{
		 
		 //根据球队名称更新比赛场数和胜场数
		 int gpw=0,gp=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     String[] aaa;
	     String score="";
	     ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where teamName1='"+teamName+"'");  
	     while(rs.next()){
	    	 score=rs.getString("score");
	    	 gp=gp+1;
	    	 aaa=score.split("-");
	    	 if(Integer.parseInt(aaa[0])>Integer.parseInt(aaa[1])){
	    		gpw=gpw+1;
	    	 }
	     }
	     rs = stmt.executeQuery("select * from generalMatchInfo where teamName2='"+teamName+"'");  
	     while(rs.next()){
	    	 score=rs.getString("score");
	    	 gp=gp+1;
	    	 aaa=score.split("-");
	    	 if(Integer.parseInt(aaa[0])<Integer.parseInt(aaa[1])){
	    		 gpw=gpw+1;
	    	 }
	     }
	     rs.close();
	     stmt.executeUpdate("update teamInfo set gamesPlayed="+gp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set gamesPlayedWin="+gpw+" where teamName='"+teamName+"'");
	     stmt.close();
	     conn.close();
	 }
	 
	 
	 public void updateFGP(int MatchID)throws Exception{
		 //根据比赛ID更新投篮命中率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 double fgm1=0,fgm2=0,fga1=0,fga2=0,fgp1=0,fgp2=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 fgm1=rs.getDouble("fieldGoalsMade");
	    	 fga1=rs.getDouble("fieldGoalsAttempted");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 fgm2=rs.getDouble("fieldGoalsMade");
	    	 fga2=rs.getDouble("fieldGoalsAttempted");
	     }
	     rs.close();
	     fgp1=fgm1/fga1;
	     fgp2=fgm2/fga2;
	     stmt.executeUpdate("update teamInfo set fieldGoalPercentage="+fgp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set fieldGoalPercentage="+fgp2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateTFGP(int MatchID)throws Exception{
		 
		 //根据比赛ID计算三分命中率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 double tfgm1=0,tfgm2=0,tfga1=0,tfga2=0,tfgp1=0,tfgp2=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 tfgm1=rs.getDouble("threePointFieldGoalsMade");
	    	 tfga1=rs.getDouble("threePointFieldGoalsAttempted");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 tfgm2=rs.getDouble("threePointFieldGoalsMade");
	    	 tfga2=rs.getDouble("threePointFieldGoalsAttempted");
	     }
	     rs.close();
	     tfgp1=tfgm1/tfga1;
	     tfgp2=tfgm2/tfga2;
	     stmt.executeUpdate("update teamInfo set threePointFieldGoalPercentage="+tfgp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set threePointFieldGoalPercentage="+tfgp2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateFTP(int MatchID)throws Exception{
		 //根据比赛ID计算投篮命中率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 double ftm1=0,ftm2=0,fta1=0,fta2=0,ftp1=0,ftp2=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 ftm1=rs.getDouble("freeThrowsMade");
	    	 fta1=rs.getDouble("freeThrowsAttempted");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 ftm2=rs.getDouble("freeThrowsMade");
	    	 fta2=rs.getDouble("freeThrowsAttempted");
	     }
	     rs.close();
	     ftp1=ftm1/fta1;
	     ftp2=ftm2/fta2;
	     stmt.executeUpdate("update teamInfo set freeThrowPercentage="+ftp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set freeThrowPercentage="+ftp2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	 

	 
	 public void updateWP(int MatchID)throws Exception{
		 //根据比赛ID更新胜率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 double wgp1=0,gp1=0,wgp2=0,gp2=0,wp1=0,wp2=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 wgp1=rs.getDouble("gamesPlayedWin");
	    	 gp1=rs.getDouble("gamesPlayed");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 wgp2=rs.getDouble("gamesPlayedWin");
	    	 gp2=rs.getDouble("gamesPlayed");
	     }
	     rs.close();
	     wp1=wgp1/gp1;
	     wp2=wgp2/gp2;
	     stmt.executeUpdate("update teamInfo set winPercentage="+wp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set winPercentage="+wp2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	
	 public void updatePossessions(int MatchID)throws Exception{
		 //根据比赛ID更新双方进攻回合
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
		 double fga1=0,fta1=0,ofreb1=0,opdereb1=0,fgm1=0,turn1=0,fga2=0,fta2=0,ofreb2=0,opdereb2=0,fgm2=0,turn2=0;
		 double result1=0,result2=0,result3=0,result4=0;
		 ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 fga1=rs.getDouble("fieldGoalsAttempted");
	    	 fta1=rs.getDouble("freeThrowsAttempted");
	    	 ofreb1=rs.getDouble("offensiveRebounds");
	    	 fgm1=rs.getDouble("fieldGoalsMade");
	    	 turn1=rs.getDouble("turnovers");
	    	 opdereb2=rs.getDouble("defensiveRebounds");
	    	 result1=rs.getDouble("possessions");
	    	 result2=rs.getDouble("oppPossessions");
	    	 
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");
	     while(rs.next()){
	    	 fga2=rs.getDouble("fieldGoalsAttempted");
	    	 fta2=rs.getDouble("freeThrowsAttempted");
	    	 ofreb2=rs.getDouble("offensiveRebounds");
	    	 fgm2=rs.getDouble("fieldGoalsMade");
	    	 turn2=rs.getDouble("turnovers");
	    	 opdereb1=rs.getDouble("defensiveRebounds");
	    	 result3=rs.getDouble("possessions");
	    	 result4=rs.getDouble("oppPossessions");
	     }
	     rs.close();
	     result1=fga1+0.4*fta1-1.07*(ofreb1*(fga1-fgm1)/(ofreb1+opdereb1))+1.07*turn1+result1;
	     result2=fga2+0.4*fta2-1.07*(ofreb2*(fga2-fgm2)/(ofreb2+opdereb2))+1.07*turn2+result2;
	     result3=fga2+0.4*fta2-1.07*(ofreb2*(fga2-fgm2)/(ofreb2+opdereb2))+1.07*turn2+result3;
	     result4=fga1+0.4*fta1-1.07*(ofreb1*(fga1-fgm1)/(ofreb1+opdereb1))+1.07*turn1+result4;
	     
	     stmt.executeUpdate("update teamInfo set possessions="+result1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set oppPossessions="+result2+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set oppPossessions="+result3+" where teamName='"+team2+"'");	
	     stmt.executeUpdate("update teamInfo set possessions="+result4+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateRating(int MatchID)throws Exception{
		 //根据比赛ID更新进攻防守效率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     double points1=0,points2=0,possessions1=0,possessions2=0,result1=0,result2=0;
	     double oppoints1=0,oppoints2=0,oppossessions1=0,oppossessions2=0,result3=0,result4=0;
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 points1=rs.getDouble("points");
	    	 possessions1=rs.getDouble("possessions");
	    	 oppoints1=rs.getDouble("oppPoints");
	    	 oppossessions1=rs.getDouble("oppPossessions");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 points2=rs.getDouble("points");
	    	 possessions2=rs.getDouble("possessions");
	    	 oppoints2=rs.getDouble("oppPoints");
	    	 oppossessions2=rs.getDouble("oppPossessions");
	     }
	     rs.close();
	     result1=points1/possessions1*100;
	     result2=points2/possessions2*100;
	     result3=oppoints1/oppossessions1*100;
	     result4=oppoints2/oppossessions2*100;	     
	     stmt.executeUpdate("update teamInfo set offensiveRating="+result1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set offensiveRating="+result2+" where teamName='"+team2+"'");
	     stmt.executeUpdate("update teamInfo set defensiveRating="+result3+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set defensiveRating="+result4+" where teamName='"+team2+"'");
	     
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateRP(int MatchID)throws Exception{
		 //根据比赛ID更新篮板效率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();
	     
	     double oreb1=0,dreb1=0,oreb2=0,dreb2=0;
	     double result1=0,result2=0,result3=0,result4=0;
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 oreb1=rs.getDouble("offensiveRebounds");
	    	 dreb1=rs.getDouble("defensiveRebounds");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 oreb2=rs.getDouble("offensiveRebounds");
	    	 dreb2=rs.getDouble("defensiveRebounds");
	     }
	     rs.close();
	     result1=oreb1/(oreb1+dreb2);
	     result2=dreb1/(dreb1+oreb2);
	     result3=oreb2/(oreb2+dreb1);
	     result4=dreb2/(dreb2+oreb1);
	     
	     stmt.executeUpdate("update teamInfo set offensiveReboundPercentage="+result1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set offensiveReboundPercentage="+result3+" where teamName='"+team2+"'");
	     stmt.executeUpdate("update teamInfo set defensiveReboundPercentage="+result2+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set defensiveReboundPercentage="+result4+" where teamName='"+team2+"'");
	     
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateSA(int MatchID)throws Exception{
		 //根据比赛ID更新抢断助攻效率
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();
	     
	     double st1=0,as1=0,st2=0,as2=0,pos1=0,pos2=0,oppos1=0,oppos2=0;
	     double stp1=0,stp2=0,asp1=0,asp2=0;
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 st1=rs.getDouble("steals");
	    	 as1=rs.getDouble("assists");
	    	 pos1=rs.getDouble("possessions");
	    	 oppos1=rs.getDouble("oppPossessions");
	     }
	     rs = stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 st2=rs.getDouble("steals");
	    	 as2=rs.getDouble("assists");
	    	 pos2=rs.getDouble("possessions");
	    	 oppos2=rs.getDouble("oppPossessions");
	     }
	     rs.close();
	     stp1=st1/oppos1*100;
	     stp2=st2/oppos2*100;
	     asp1=as1/oppos1*100;
	     asp2=as2/pos2*100;
	     
	     stmt.executeUpdate("update teamInfo set stealPercentage="+stp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set stealPercentage="+stp2+" where teamName='"+team2+"'");
	     stmt.executeUpdate("update teamInfo set assistPercentage="+asp1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set assistPercentage="+asp2+" where teamName='"+team2+"'");
	     
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateAllPercentage(String teamName)throws Exception{
		 
		 //根据球队名称更新所有比率
		 double fieldGoalsMade=0,oppFieldGoalsMade=0,fieldGoalsAttempted=0,oppFieldGoalsAttempted=0,freeThrowsAttempted=0,freeThrowsMade=0,oppFreeThrowsAttempted=0,threePointFieldGoalsMade=0,threePointFieldGoalsAttempted=0,turnovers=0,oppTurnovers=0,gamesplayed=0,gamesplayedwin=0,ofreb=0,opdereb=0,point=0,oppoint=0,dereb=0,opofreb=0,steal=0,assist=0;
		 double fgp=0,tfgp=0,ftp=0,wp=0,offensiveRating=0,defensiveRating=0,orp=0,drp=0,sp=0,ap=0,possessions=0,oppPossessions=0;
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();
	     
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+teamName+"'");  
	     while(rs.next()){
	    	 fieldGoalsMade=rs.getDouble("fieldGoalsMade");
	    	 oppFieldGoalsMade=rs.getDouble("oppFieldGoalsMade");
	    	 fieldGoalsAttempted=rs.getDouble("fieldGoalsAttempted");
	    	 oppFieldGoalsAttempted=rs.getDouble("oppFieldGoalsAttempted");
	    	 freeThrowsAttempted=rs.getDouble("freeThrowsAttempted");
	    	 oppFreeThrowsAttempted=rs.getDouble("oppFreeThrowsAttempted");
	    	 threePointFieldGoalsMade=rs.getDouble("threePointFieldGoalsMade");
	    	 threePointFieldGoalsAttempted=rs.getDouble("threePointFieldGoalsAttempted");
	    	 freeThrowsMade=rs.getDouble("freeThrowsMade");
	    	 turnovers=rs.getDouble("turnovers");
	    	 oppTurnovers=rs.getDouble("oppTurnovers");
	    	 gamesplayed=rs.getDouble("gamesPlayed");
	    	 gamesplayedwin=rs.getDouble("gamesPlayedWin");
	    	 point=rs.getDouble("points");
	    	 oppoint=rs.getDouble("oppPoints");
	    	 ofreb=rs.getDouble("offensiveRebounds");
	    	 dereb=rs.getDouble("defensiveRebounds");
	    	 opofreb=rs.getDouble("oppOffensiveRebounds");
	    	 opdereb=rs.getDouble("oppDefensiveRebounds");
	    	 steal=rs.getDouble("steals");
	    	 assist=rs.getDouble("assists");
	     }
	     rs.close();
	     
	     fgp=fieldGoalsMade/fieldGoalsAttempted;
	     tfgp=threePointFieldGoalsMade/threePointFieldGoalsAttempted;
	     ftp=freeThrowsMade/freeThrowsAttempted;
	     possessions=fieldGoalsAttempted+0.4*freeThrowsAttempted-1.07*(ofreb*(fieldGoalsAttempted-fieldGoalsMade)/(ofreb+opdereb))+1.07*turnovers;
	     oppPossessions=oppFieldGoalsAttempted+0.4*oppFreeThrowsAttempted-1.07*(opofreb*(oppFieldGoalsAttempted-oppFieldGoalsMade)/(opofreb+dereb))+1.07*oppTurnovers;
	     wp=gamesplayedwin/gamesplayed;
	     offensiveRating=point/possessions*100;
	     defensiveRating=oppoint/oppPossessions*100;
	     orp=ofreb/(ofreb+opdereb);
	     drp=dereb/(dereb+opofreb);
	     sp=steal/oppPossessions*100;
	     ap=assist/possessions*100;	 
	     
	     stmt.executeUpdate("update teamInfo set fieldGoalPercentage="+fgp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set threePointFieldGoalPercentage="+tfgp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set freeThrowPercentage="+ftp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set possessions="+possessions+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set oppPossessions="+oppPossessions+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set winPercentage="+wp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set offensiveRating="+offensiveRating+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set defensiveRating="+defensiveRating+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set offensiveReboundPercentage="+orp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set defensiveReboundPercentage="+drp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set stealPercentage="+sp+" where teamName='"+teamName+"'");
	     stmt.executeUpdate("update teamInfo set assistPercentage="+ap+" where teamName='"+teamName+"'");
	     
	     stmt.close();
	     conn.close();
	 }
	 
	 public void updateKnown(int MatchID,String type)throws Exception{
		 
		 //根据比赛ID更新比赛中已知己方数据
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     
	     double fgm1=0,fgm2=0;
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 fgm1=rs.getDouble(type);
	     }
	     fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team1,type);
	     rs=stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 fgm2=rs.getDouble(type);
	     }
	     fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team2,type);
	     rs.close();
	     stmt.executeUpdate("update teamInfo set "+type+"="+fgm1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set "+type+"="+fgm2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	     
	 }
	 
	 public void updateOppKnown(int MatchID,String type)throws Exception{
		 //更新比赛中对知己方数据
		 String team1=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(0);
		 String team2=new TeamDataCalculate().SearchTeamNameByMatchID(MatchID).get(1);
		 
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement(); 
	     
	     double fgm1=0,fgm2=0;
	     ResultSet rs = stmt.executeQuery("select * from teamInfo where teamName='"+team1+"'");  
	     while(rs.next()){
	    	 fgm1=rs.getDouble(type);
	     }
	     rs=stmt.executeQuery("select * from teamInfo where teamName='"+team2+"'");  
	     while(rs.next()){
	    	 fgm2=rs.getDouble(type);
	     }
	     if(type.equals("oppFieldGoalsMade")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"fieldGoalsMade");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"fieldGoalsMade");
	     }
	     else if(type.equals("oppFieldGoalsAttempted")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"fieldGoalsAttempted");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"fieldGoalsAttempted");
	     }
	     else if(type.equals("oppFreeThrowsAttempted")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"freeThrowsAttempted");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"freeThrowsAttempted");
	     }
	     else if(type.equals("oppTurnovers")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"turnovers");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"turnovers");
	     }
	     else if(type.equals("oppSteals")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"steals");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"steals");
	     }
	     else if(type.equals("oppAssists")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"assists");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"assists");
	     }
	     else if(type.equals("oppOffensiveRebounds")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"offensiveRebounds");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"offensiveRebounds");
	     }
	     else if(type.equals("oppDefensiveRebounds")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"defensiveRebounds");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"defensiveRebounds");
	     }
	     else if(type.equals("oppPoints")){
	    	 fgm1=fgm1+new MatchDataCalculate().Cal_Known(MatchID,team2,"points");
	    	 fgm2=fgm2+new MatchDataCalculate().Cal_Known(MatchID,team1,"points");
	     }
	     rs.close();

	     stmt.executeUpdate("update teamInfo set "+type+"="+fgm1+" where teamName='"+team1+"'");
	     stmt.executeUpdate("update teamInfo set "+type+"="+fgm2+" where teamName='"+team2+"'");		 
	     stmt.close();
	     conn.close();
	 }
	 
	 public ArrayList<String> SearchTeamNameByMatchID(int MatchID)throws Exception{
		 
		//根据比赛ID得到球队名称缩写
		 String team1="";
		 String team2="";
		 ArrayList<String> result=new ArrayList<String>();
		 File f=new File("");
		 String s=f.getCanonicalPath();
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	     String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	     Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	     Statement stmt = conn.createStatement();  
	     ResultSet rs = stmt.executeQuery("select * from generalMatchInfo where ID="+MatchID); 
	     while(rs.next()){
	    	 team1=rs.getString("teamName1");
	    	 team2=rs.getString("teamName2");
	    	 result.add(team1);
	    	 result.add(team2);
	     }
	     rs.close();
	     stmt.close();
	     conn.close();
	     return result;
	   		 
	 }
	 
	 public int teamIDSearch(String tn)throws Exception{
		 	//根据简称查询球队ID
		 	
		 	File f=new File("");
		 	String s=f.getCanonicalPath();
		 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+s+"//NBAIteration2";  
	        Connection conn = DriverManager.getConnection(dbur1, "username", "password");  
	        Statement stmt = conn.createStatement();  
	        ResultSet rs = stmt.executeQuery("select ID from teamInfo where teamName='"+tn+"'");  
	        int result=0;
	        while(rs.next()){
	        	result= rs.getInt("ID");
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	        return result;
	 }
	
	 public static void main(String[]args){
		/*try {
			new TeamDataCalculate().BasicTeamOriginal();
			new MatchDataCalculate().BasicMatchOriginal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1;i<1230;i++){
		 
		 String[]m={"fieldGoalsMade","fieldGoalsAttempted","threePointFieldGoalsMade","threePointFieldGoalsAttempted"
				 ,"freeThrowsMade","freeThrowsAttempted","offensiveRebounds","defensiveRebounds","rebounds","assists","steals","blocks","turnovers","fouls","points"};
		 String[]oppm={"oppFieldGoalsMade","oppFieldGoalsAttempted","oppFreeThrowsAttempted","oppTurnovers","oppSteals","oppAssists","oppOffensiveRebounds","oppDefensiveRebounds","oppPoints"};
		 try {
			 for(int p=0;p<m.length;p++){
				 new TeamDataCalculate().updateKnown(i,m[p]);
			 }
			 for(int q=0;q<oppm.length;q++){
				 new TeamDataCalculate().updateOppKnown(i,oppm[q]);
			 }

				new TeamDataCalculate().updateGamesPlayed(i);
				new TeamDataCalculate().updateGamesPlayedWin(i);
				new TeamDataCalculate().updateFGP(i);
				new TeamDataCalculate().updateTFGP(i);
				new TeamDataCalculate().updateFTP(i);
				new TeamDataCalculate().updateWP(i);
				new TeamDataCalculate().updatePossessions(i);
				new TeamDataCalculate().updateRating(i);
				new TeamDataCalculate().updateRP(i);
				new TeamDataCalculate().updateSA(i);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 
		new TeamDataCalculate().updateAllTeam();*/
		 TeamDataCalculate tdc=new TeamDataCalculate();
		 tdc.addSingleMatchTeam(1);
		 System.out.println("添加成功");
		
	 }
}
