package data;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.MatchPO;
import po.MatchPlayer;
import po.MatchTeam;

public class BasicMatchDataTest {

	BasicMatchData bmd = null;
	@Before
	public void setUp() throws Exception {
		bmd = new BasicMatchData();
	}

	@After
	public void tearDown() throws Exception {
		bmd = null;
	}

	@Test
	public void testGetMatchOriginal() {
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		mp=bmd.getMatchOriginal();
		assertNotNull(mp);
	}

	@Test
	public void testGetOneMatchOriginal() {
		String path="13-14_01-01_CHA-LAC";
		MatchPO mp=bmd.getOneMatchOriginal(path);
		assertNotNull(mp);
	}

	@Test
	public void testCheckTime() {
		MatchTeam team=new MatchTeam();
		team.setTeamName("ATL");
		int extraTimes=1;
		bmd.checkTime(team, extraTimes);
		assertNotNull(1);
	}

	@Test
	public void testSetTime() {
		MatchTeam team=new MatchTeam();
		ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer>();
		MatchPlayer mp=new 	MatchPlayer();
		MP.add(mp);
		team.setPlayers(MP);
		int extraTimes=1;
		int n=0;
		bmd.setTime(team, extraTimes, n);
		assertNotNull(1);
	}

	@Test
	public void testCheckScore() {
		MatchTeam team=new MatchTeam();
		ArrayList<MatchPlayer> MP=new ArrayList<MatchPlayer>();
		MatchPlayer mp=new 	MatchPlayer();
		MP.add(mp);
		team.setPlayers(MP);
		int score=1;
		bmd.checkScore(team, score);
		assertNotNull(1);
	}

	@Test
	public void testGetTeamInfo() {
		ArrayList<String> wtf=new ArrayList<String>();
		String path=bmd.getPath();
		String Dpath=path;
		File f = new File(Dpath);
		String[] filelist = f.list();
		int index=3;
		try {
			File readfile = new File(Dpath+"\\"+filelist[0]);
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			while(wtf.get(index).split(";").length>1)
				index++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MatchTeam mt=bmd.getTeamInfo(wtf, 2, index-1);
		assertNotNull(mt);
	}

	@Test
	public void testGetPath() {
		String s=bmd.getPath();
		assertNotNull(s);
	}

}
