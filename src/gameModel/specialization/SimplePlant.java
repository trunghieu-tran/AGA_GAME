/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import Utils.Constants;
import gameModel.events.GenerateGasEvent;

/**
 *
 * @author trung
 */
public abstract class SimplePlant extends Specialization {

    public SimplePlant(int weight) {
        super(weight);
        this.Type = Constants.PLANT;
        this.Name = Constants.PLANT;
    }

    @Override
    public String getType() {
        return this.Type;
    }

    @Override
    public void generateGas() {
        gasListener.generateGas(new GenerateGasEvent(new Object(), Constants.O2));
    }
}
