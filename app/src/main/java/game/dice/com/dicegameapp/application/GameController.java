package game.dice.com.dicegameapp.application;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import game.dice.com.dicegameapp.domain.*;



public class GameController {

    private static Player player;


    public GameController() {

    }


    public void createPlayer(String name) {
        this.player = new Player(name);

    }

    public String getPlayerName() {
        return player.getName();
    }

    public GameDTO playGame() {
        Game game = new Game();
        GameDTO dto = new GameDTO();
        game.playGame();
        dto.setDices(game);
        player.addGame(game);
        return dto;
    }


    public List<String> getPlayerGamesToString() {
        List<String> text =new ArrayList<>();
        List<Game> games = player.getAllGames();

        for (Game game : games) {
            text.add(String.format("SCORE: %s  =>  %s",game.getSumDices(), game.hasWon() ?  "You won!" : "You lost!"));
        }
        return text;
    }

    public double getPlayerRanking() {
        List<Game> games = player.getAllGames();

        double wins = 0.0;
        for (Game game : games) {
            if (game.hasWon())
                wins++;
        }
        return wins / games.size();
    }

}

