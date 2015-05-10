package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.PlayerPO;
import po.TodayPlayerPO;

public class PlayerDataTest {
	PlayerData pd=null;
	@Before
	public void setUp() throws Exception {
		pd=new PlayerData();
	}

	@After
	public void tearDown() throws Exception {
		pd=null;
	}

	@Test
	public void testGetSinglePlayerInfo() {
		PlayerPO pp=new PlayerPO();
		pp=pd.getSinglePlayerInfo("Aaron Brooks");
		assertNotNull(pp);
	}

	@Test
	public void testGetAllPlayerInfo() {
		ArrayList<PlayerPO> pp=new ArrayList<PlayerPO>();
		pp=pd.getAllPlayerInfo();
		assertNotNull(pp);
	}

	@Test
	public void testGetTodayPlayerInfo() {
		ArrayList<TodayPlayerPO> tpp=new ArrayList<TodayPlayerPO>();
		tpp=pd.getTodayPlayerInfo("01-01");
		assertNotNull(tpp);
	}

	@Test
	public void testUpdatePlayerInfo() {
		pd.updatePlayerInfo(1);
		assertNotNull(1);
	}


}