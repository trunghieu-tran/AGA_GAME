/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

import Utils.Constants;
import com.golden.gamedev.object.Sprite;
import gameModel.specialization.Buffalo;
import gameModel.specialization.Moss;
import gameModel.specialization.Omnivorous;
import gameModel.specialization.Parasite;
import gameModel.specialization.Predator;
import gameModel.specialization.Specialization;
import gameModel.specialization.Tiger;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javafx.util.Pair;

/**
 *
 * @author trung
 */
public abstract class Bacterium extends Sprite {

    protected double speedX = Constants.SPEED_HERO;
    protected double speedY = Constants.SPEED_HERO;
    protected Specialization specialization;
    protected int score = 0;

    public String typeToString(){
        return (this.specialization.getType());
    }
    public double getSpeedX() {
        return speedX;
    }
    
    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double spX) {
        speedX = spX;
    }

    public void setSpeedY(double spY) {
        speedY = spY;
    }

    public void setSpeedXY(double spX, double spY) {
        this.speedX = spX;
        this.speedY = spY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
    public void updateSpeed() {
        speedX = speedX - speedX * Constants.PERCENT_SPEED;
        speedY = speedY - speedY * Constants.PERCENT_SPEED;
    }

    public abstract boolean isPlayer();

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization spez) {
        this.specialization = spez;
    }

    public abstract void updateSize();
    
    public void upgrade(){
        
        /*
        if (score >= 20) return ConstantsMOSS;
        if (score >= 40) return PARASITE;
        if (score >= 60) return PREDATOR;
        if (score >= 80) return OMNIVOROUS;
        if (score >= 100) return BUFFALO;
        if (score >= 120) return TIGER;
        return BASIC_BACTERIUM;
               */
        if (score >= 20)
            this.setSpecialization(new Moss(this.width));
        if (score >= 40)
            this.setSpecialization(new Parasite(this.width));
        if (score >= 60)
            this.setSpecialization(new Predator(this.width));
        if (score >= 80)
            this.setSpecialization(new Omnivorous(this.width));
        if (score >= 100)
            this.setSpecialization(new Buffalo(this.width));
        if (score >= 120)
            this.setSpecialization(new Tiger(this.width));
    }
}
