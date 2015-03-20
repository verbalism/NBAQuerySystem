package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import po.PlayerInfoPO;
import dataservice.PlayerDataService;

public class PlayerData implements PlayerDataService{
	public ArrayList<PlayerInfoPO> getPlayerOriginal()  {
		ArrayList<PlayerInfoPO> allPlayers = new ArrayList<PlayerInfoPO>();
		String Dpath="Data\\players\\info";
		File f = new File(Dpath);
		String[] filelist = f.list();
		for(int i=0; i<filelist.length; i++){
			File readfile = new File(Dpath+"\\"+filelist[i]);
			try {
				ArrayList<String> wtf = new ArrayList<String>();
				InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
				BufferedReader br = new BufferedReader( read);
				for(String s = br.readLine();s != null; s = br.readLine()){
					wtf.add(s);
				}
				br.close();
				PlayerInfoPO player = new PlayerInfoPO();
				player.setName(filelist[i]);
				player.setNumber(wtf.get(3).split("©¦")[1].split("¨U")[0].trim());
				player.setPosition(wtf.get(5).split("©¦")[1].split("¨U")[0].trim());
				player.setHeight(wtf.get(7).split("©¦")[1].split("¨U")[0].trim());
				player.setWeight(wtf.get(9).split("©¦")[1].split("¨U")[0].trim());
				player.setBirth(wtf.get(11).split("©¦")[1].split("¨U")[0]);
				player.setAge(wtf.get(13).split("©¦")[1].split("¨U")[0].trim());
				player.setExp(wtf.get(15).split("©¦")[1].split("¨U")[0].trim());
				player.setSchool(wtf.get(17).split("©¦")[1].split("¨U")[0]);
				allPlayers.add(player);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allPlayers;
	}

	public PlayerInfoPO getSinglePlayerOriginal(String playerName) {
		File readfile = new File("Data\\players\\info\\"+playerName);
		PlayerInfoPO player = new PlayerInfoPO();
		try {
			ArrayList<String> wtf = new ArrayList<String>();
			InputStreamReader read = new InputStreamReader(new FileInputStream(readfile),"UTF-8");
			BufferedReader br = new BufferedReader( read);
			for(String s = br.readLine();s != null; s = br.readLine()){
				wtf.add(s);
			}
			br.close();
			player.setName(playerName);
			player.setNumber(wtf.get(3).split("©¦")[1].split("¨U")[0]);
			player.setPosition(wtf.get(5).split("©¦")[1].split("¨U")[0]);
			player.setHeight(wtf.get(7).split("©¦")[1].split("¨U")[0]);
			player.setWeight(wtf.get(9).split("©¦")[1].split("¨U")[0]);
			player.setBirth(wtf.get(11).split("©¦")[1].split("¨U")[0]);
			player.setAge(wtf.get(13).split("©¦")[1].split("¨U")[0]);
			player.setExp(wtf.get(15).split("©¦")[1].split("¨U")[0]);
			player.setSchool(wtf.get(17).split("©¦")[1].split("¨U")[0]);
		} catch (FileNotFoundException e) {
			return null;//Î´ÕÒµ½ÎÄ¼þ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
	}
	
}
