package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * Emily Nitzberg
 * Danh Nguyen
 *
 */
public class SoccerDatabase implements SoccerDB {

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    Hashtable <String,SoccerPlayer> player = new Hashtable <String, SoccerPlayer>();

    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {

        SoccerPlayer pr = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);

        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            return false;
        }
        else
        {
            player.put(fullName, pr);
            return true;
        }
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName))
        {
            player.remove(fullName);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override

	public SoccerPlayer getPlayer(String firstName, String lastName) {

        String fullName = firstName + "##" + lastName;
        if(player.containsKey(fullName))
        {
            return player.get(fullName);
        }

        return null;
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpGoals();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpAssists();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpShots();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpSaves();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpFouls();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpYellowCards();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String fullName = firstName + "##" + lastName;
        if (player.containsKey(fullName)) {
            player.get(fullName).bumpRedCards();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {

        int i = 0;
        if(teamName == null)
        {
            return player.size();

        }
        for(String key: player.keySet())
        {
            if(player.get(key).getTeamName().equals(teamName))
                i++;
        }

            return i;

        }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName)
    {
        int i = 0;

        if(teamName == null)
        {
            for (SoccerPlayer pr: player.values())
            {
                if(i == idx)
                {
                    return pr;
                }

                i++;
            }
        }

        for(SoccerPlayer pr: player.values())
        {
            if(pr.getTeamName().equals(teamName))
            {
                if(i == idx)
                {
                    return pr;
                }
                i++;
            }
        }

        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {
        try
        {
            PrintWriter pw = new PrintWriter(file);

            for (SoccerPlayer pr: player.values())
            {
                pw.println(pr.getFirstName());
                pw.println(pr.getLastName());
                pw.println(pr.getUniform());
                pw.println(pr.getGoals());
                pw.println(pr.getAssists());
                pw.println(pr.getShots());
                pw.println(pr.getFouls());
                pw.println(pr.getSaves());
                pw.println(pr.getYellowCards());
                pw.println(pr.getRedCards());
                pw.println(pr.getTeamName());

                //pw.println(logString(pr.getFirstName()));
                logString(pr.getFirstName() + " " + pr.getLastName() + " has been saved");

            }
            pw.close();

            return true;
        }
        catch (FileNotFoundException fnfe)
        {
            return false;
        }
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
