package com.example.demo.controller;

import com.example.demo.model.AppSession;
import com.example.demo.model.Game;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${home.url}")
    private String homeurl;

    @Autowired
    private AppSession appSession;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/creapartita")
    public String creaPartita(Model model, HttpServletResponse response){

        //creo una nuova partita, ci aggiungo il giocatore "red" e la aggiungo alla gamelist
        int id = appSession.getRandom().nextInt(100000);
        String nomeGiocatore = "red";
        Game game = new Game();
        game.addPlayer(nomeGiocatore);
        appSession.addGame(id, game);

        //setto i cookie per idpartita e nomegiocatore
        Cookie idcookie = new Cookie("id", String.valueOf(id));
        Cookie namecookie = new Cookie("nomeGiocatore", nomeGiocatore);
        response.addCookie(idcookie);
        response.addCookie(namecookie);

        //scrivo i campi per la pagina successiva
        model.addAttribute("idPartita", id);
        model.addAttribute("nomeGiocatore", nomeGiocatore);
        return "creapartita";
    }

    @GetMapping("/trovapartita")
    public String trovaPartita(Model model, HttpServletResponse response, @RequestParam String idpartita){
        Game game = appSession.getGame(idpartita);
        model.addAttribute("idPartita", idpartita);

        if(game != null){
            String nomeGiocatore = game.nextColor();
            if(game.addPlayer(nomeGiocatore)) {
                String giocatori = game.getPlayers().toString();

                //setto i cookie per idpartita e nomegiocatore
                Cookie idcookie = new Cookie("id", String.valueOf(idpartita));
                Cookie namecookie = new Cookie("nomeGiocatore", nomeGiocatore);
                response.addCookie(idcookie);
                response.addCookie(namecookie);

                model.addAttribute("giocatori", giocatori);
                return "trovapartita";
            }
            else{return "error";}
        }else{
            model.addAttribute("homeurl", homeurl);
            return "partitainesistente";}

    }

}
