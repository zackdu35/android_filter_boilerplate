package com.projet_times_up.zac.filter_boilerplate.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;


import com.projet_times_up.zac.filter_boilerplate.Activity.Adapter.ChampionAdapter;
import com.projet_times_up.zac.filter_boilerplate.Activity.Data.Champion;
import com.projet_times_up.zac.filter_boilerplate.R;

import java.util.ArrayList;

public class MainActivity extends Activity{


    private GridView gridView;
    private EditText search;
    private ArrayList<Champion> champions = new ArrayList<>();
    private ArrayList<Object> items = new ArrayList<>();
    private ChampionAdapter championAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridview);
        search = (EditText) findViewById(R.id.ed_search);

        this.fillChamps();
        this.fillItems();
        this.initEdListener();

        championAdapter = new ChampionAdapter(this, items);
        gridView.setTextFilterEnabled(true);
        gridView.setAdapter(championAdapter);




    }

    private void initEdListener() {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                championAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    private void fillItems() {
        String letter = "";
        for (Champion c : champions) {

            if (!(letter.toUpperCase()).equals(c.getName().substring(0, 1).toUpperCase())) {
                letter = c.getName().substring(0, 1).toUpperCase();
                items.add(letter);
            }
            items.add(c);
        }
    }




    private void fillChamps() {
        champions.add(new Champion("Aatrox",6300));
        champions.add(new Champion("Ahri",4800));
        champions.add(new Champion("Akali",3150));
        champions.add(new Champion("Alistar",1350));
        champions.add(new Champion("Amumu",450));
        champions.add(new Champion("Anivia",3150));
        champions.add(new Champion("Annie",450));
        champions.add(new Champion("Ashe",450));
        champions.add(new Champion("Aurelion Sol",6300));
        champions.add(new Champion("Azir",6300));
        champions.add(new Champion("Bard",6300));
        champions.add(new Champion("Blitzcrank",3150));
        champions.add(new Champion("Brand",4800));
        champions.add(new Champion("Braum",6300));
        champions.add(new Champion("Caitlyn",4800));
        champions.add(new Champion("Camille",6300));
        champions.add(new Champion("Cassiopeia",4800));
        champions.add(new Champion("Cho'gath",1350));
        champions.add(new Champion("Corki",3150));
        champions.add(new Champion("Darius",4800));
        champions.add(new Champion("Diana",4800));
        champions.add(new Champion("Dr. Mundo",1350));
        champions.add(new Champion("Draven",4800));
        champions.add(new Champion("Ekko",6300));
        champions.add(new Champion("Elise",6300));
        champions.add(new Champion("Evelynn",1350));
        champions.add(new Champion("Ezreal",4800));
        champions.add(new Champion("Fiddlesticks",1350));
        champions.add(new Champion("Fiora",4800));
        champions.add(new Champion("Fizz",4800));
        champions.add(new Champion("Galio",3150));
        champions.add(new Champion("Gangplank",3150));
        champions.add(new Champion("Garen",450));
        champions.add(new Champion("Gnar",6300));
        champions.add(new Champion("Gragas",3150));
        champions.add(new Champion("Graves",4800));
        champions.add(new Champion("Hecarim",4800));
        champions.add(new Champion("Heimerdinger",3150));
        champions.add(new Champion("Illaoi",6300));
        champions.add(new Champion("Irelia",4800));
        champions.add(new Champion("Ivern",6300));
        champions.add(new Champion("Janna",1350));
        champions.add(new Champion("Jarvan IV",4800));
        champions.add(new Champion("Jax",1350));
        champions.add(new Champion("Jayce",4800));
        champions.add(new Champion("Jhin",6300));
        champions.add(new Champion("Jinx",6300));
        champions.add(new Champion("Kalista",6300));
        champions.add(new Champion("Karma",3150));
        champions.add(new Champion("Karthus",3150));
        champions.add(new Champion("Kassadin",3150));
        champions.add(new Champion("Katarina",3150));
        champions.add(new Champion("Kayle",450));
        champions.add(new Champion("Kennen",4800));
        champions.add(new Champion("Kha'Zix",4800));
        champions.add(new Champion("Kindred",6300));
        champions.add(new Champion("Kled",6300));
        champions.add(new Champion("Kog'Maw",4800));
        champions.add(new Champion("LeBlanc",3150));
        champions.add(new Champion("Lee Sin",4800));
        champions.add(new Champion("Leona",4800));
        champions.add(new Champion("Lissandra",6300));
        champions.add(new Champion("Lucian",6300));
        champions.add(new Champion("Lulu",4800));
        champions.add(new Champion("Lux",3150));
        champions.add(new Champion("Malphite",1350));
        champions.add(new Champion("Malzahar",4800));
        champions.add(new Champion("Maokai",4800));
        champions.add(new Champion("Maître Yi",450));
        champions.add(new Champion("Miss Fortune",3150));
        champions.add(new Champion("Mordekaiser",3150));
        champions.add(new Champion("Morgana",1350));
        champions.add(new Champion("Nami",6300));
        champions.add(new Champion("Nasus",1350));
        champions.add(new Champion("Nautilus",4800));
        champions.add(new Champion("Nidalee",3150));
        champions.add(new Champion("Nocturne",4800));
        champions.add(new Champion("Nunu",450));
        champions.add(new Champion("Olaf",3150));
        champions.add(new Champion("Orianna",4800));
        champions.add(new Champion("Pantheon",3150));
        champions.add(new Champion("Poppy",450));
        champions.add(new Champion("Quinn",6300));
        champions.add(new Champion("Rakan",6300));
        champions.add(new Champion("Rammus",1350));
        champions.add(new Champion("Rek'Sai",6300));
        champions.add(new Champion("Renekton",4800));
        champions.add(new Champion("Rengar",4800));
        champions.add(new Champion("Riven",4800));
        champions.add(new Champion("Rumble",4800));
        champions.add(new Champion("Ryze",450));
        champions.add(new Champion("Sejuani",4800));
        champions.add(new Champion("Shaco",3150));
        champions.add(new Champion("Shen",3150));
        champions.add(new Champion("Shyvana",3150));
        champions.add(new Champion("Singed",450));
        champions.add(new Champion("Sion",1350));
        champions.add(new Champion("Sivir",450));
        champions.add(new Champion("Skarner",4800));
        champions.add(new Champion("Sona",3150));
        champions.add(new Champion("Soraka",450));
        champions.add(new Champion("Swain",4800));
        champions.add(new Champion("Syndra",4800));
        champions.add(new Champion("Tahm Kench",6300));
        champions.add(new Champion("Taliyah",6300));
        champions.add(new Champion("Talon",4800));
        champions.add(new Champion("Taric",1350));
        champions.add(new Champion("Teemo",1350));
        champions.add(new Champion("Thresh",6300));
        champions.add(new Champion("Tristana",1350));
        champions.add(new Champion("Trundle",4800));
        champions.add(new Champion("Tryndamere",1350));
        champions.add(new Champion("Twisted Fate",1350));
        champions.add(new Champion("Twitch",3150));
        champions.add(new Champion("Udyr",1350));
        champions.add(new Champion("Urgot",3150));
        champions.add(new Champion("Varus",4800));
        champions.add(new Champion("Vayne",4800));
        champions.add(new Champion("Veigar",1350));
        champions.add(new Champion("Vel'Koz",6300));
        champions.add(new Champion("Vi",6300));
        champions.add(new Champion("Viktor",4800));
        champions.add(new Champion("Vladimir",4800));
        champions.add(new Champion("Volibear",4800));
        champions.add(new Champion("Warwick",450));
        champions.add(new Champion("Wukong",4800));
        champions.add(new Champion("Xayah",6300));
        champions.add(new Champion("Xerath",4800));
        champions.add(new Champion("Xin Zhao",1350));
        champions.add(new Champion("Yasuo",6300));
        champions.add(new Champion("Yorick",4800));
        champions.add(new Champion("Zac",6300));
        champions.add(new Champion("Zed",6300));
        champions.add(new Champion("Ziggs",4800));
        champions.add(new Champion("Zilean",1350));
        champions.add(new Champion("Zyra",4800));
    }


}
