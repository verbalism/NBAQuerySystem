package data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import po.BasicPlayerPO;

public class BasicPlayerDataTest {
	BasicPlayerData bpd = null;
	@Before
	public void setUp() throws Exception {
		bpd=new BasicPlayerData();
	}

	@After
	public void tearDown() throws Exception {
		bpd=null;
	}

	@Test
	public void testGetPlayerOriginal() {
		ArrayList<BasicPlayerPO> bpp=bpd.getPlayerOriginal();
		assertNotNull(bpp);
	}

	@Test
	public void testGetSinglePlayerOriginal() {
		String playerName="Aaron Brooks";
		BasicPlayerPO bpp=bpd.getSinglePlayerOriginal(playerName);
		assertNotNull(bpp);
	}

}