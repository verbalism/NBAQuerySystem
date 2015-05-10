package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.MatchPO;

public class MatchDataTest {
	MatchData md=null;
	@Before
	public void setUp() throws Exception {
		md=new MatchData();
	}

	@After
	public void tearDown() throws Exception {
		md=null;
	}

	@Test
	public void testGetSingleMatchInfo() {
		MatchPO mp=new MatchPO();
		String teamName="CHA";
		String date="01-01";
		mp=md.getSingleMatchInfo(teamName,date);
		assertNotNull(mp);
	}

	@Test
	public void testGetAllMatchInfo() {
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		mp=md.getAllMatchInfo();
		assertNotNull(mp);
	}

	@Test
	public void testGetTeamRecentMatchInfo() {
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		mp=md.getTeamRecentMatchInfo(5,"CHA");
		assertNotNull(mp);
	}

	@Test
	public void testGetPlayerRecentMatchInfo() {
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		mp=md.getPlayerRecentMatchInfo(5,"Aaron Brooks");
		assertNotNull(mp);
	}

	@Test
	public void testGetDate() {
		String s=new String();
		s=md.getDate();
		assertNotNull(s);
	}

	@Test
	public void testGetTodayMatchInfo() {
		ArrayList<MatchPO> mp=new ArrayList<MatchPO>();
		mp=md.getTodayMatchInfo("01-01");
		assertNotNull(mp);
	}

}