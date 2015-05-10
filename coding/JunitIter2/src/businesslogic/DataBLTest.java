package businesslogic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public class DataBLTest {
	DataBL a;

	@Before
	public void setUp() throws Exception {
		a=new DataBL();
	}

	@After
	public void tearDown() throws Exception {
		a=null;
	}

	@Test
	public void testGetSinglePlayerInfo() {
		PlayerVO h=new PlayerVO();
		h=a.getSinglePlayerInfo("LeBron James");
		assertNotNull(h);
	}

	@Test
	public void testGetAllPlayerInfo() {
		ArrayList<PlayerVO> h=new ArrayList<PlayerVO>();
		h=a.getAllPlayerInfo();
		assertNotNull(h);
	}

	@Test
	public void testGetSingleMatchInfo() {
		MatchVO h=new MatchVO();
		h=a.getSingleMatchInfo("10-30", "MIA");
		assertNotNull(h);
	}

	@Test
	public void testFindMatchByPlayer() {
		 ArrayList<MatchVO> h=new ArrayList<MatchVO>();
		 h=a.findMatchByPlayer("LeBron James") ;
		 assertNotNull(h);
	}

	@Test
	public void testFindMatchByTeam() {
		ArrayList<MatchVO> h=new ArrayList<MatchVO>();
		h=a.findMatchByTeam("BOS");
		assertNotNull(h);
	}

	@Test
	public void testFindMatchByDate() {
		 ArrayList<MatchVO> h=new  ArrayList<MatchVO>();
		 h=a.findMatchByDate("01-01");
		 assertNotNull(h);
	}

	@Test
	public void testGetSingleTeamInfo() {
		TeamVO h=new TeamVO();
		h=a.getSingleTeamInfo("BOS");
		 assertNotNull(h);
	}

	@Test
	public void testGetAllTeamInfo() {
		ArrayList<TeamVO> h=new ArrayList<TeamVO> ();
		h= a.getAllTeamInfo();
		 assertNotNull(h);
	}

}
