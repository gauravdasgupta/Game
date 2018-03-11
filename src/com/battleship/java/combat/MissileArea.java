package com.battleship.java.combat;

import com.battleship.java.player.Player;
import com.battleship.java.shipcell.ShipCell;

public class MissileArea implements MissileFunctions {

    @Override
    public boolean hitTarget(Player attacker, Player target) {
        boolean status= false;

        if(!attacker.getSequenceOfMissiles().isEmpty()){
            if(this.fireMissile(attacker.getSequenceOfMissiles().get(0),target)){
                status=true;
            }
            else
                status=false;
            attacker.getSequenceOfMissiles().remove(attacker.getSequenceOfMissiles().get(0)); //removing the fired missile
        }


        return status;
    }

    @Override
    public boolean fireMissile(String missile,Player target) {
        Integer y_coordinate;
        Integer x_coordinate;
        boolean status=false;
        //System.out.println("Looking for ship cell at--"+missile);
        //y_coordinate=stringDecoder.getDecodeLibrary().get(String.valueOf(missile.charAt(0)));
        x_coordinate=((int)missile.charAt(0))-65;
        y_coordinate=Integer.parseInt(String.valueOf(missile.charAt(1)))-1;

        //System.out.println("finding at coordinates x,y "+x_coordinate+","+y_coordinate);
        ShipCell cell_b[][]=target.getBattlearea();
        ShipCell shipCell=null;
        if(cell_b[x_coordinate][y_coordinate]!=null){
            //System.out.println("Ship Exists");
            status= true;
            shipCell=cell_b[x_coordinate][y_coordinate];
            //System.out.println("check cell name--"+shipCell.getName());

            if(shipCell.getName().contains("_P")){
                //System.out.println("Ship Part is of Type P, so destroy this part");
                cell_b[x_coordinate][y_coordinate]=null;
            }
            else if(shipCell.getName().contains("_Q")){
                //System.out.println("Ship Part is of Type Q");
                if(shipCell.getHitCount()<2){
                    //System.out.println("Hit the Part of Q --"+shipCell.getHitCount());
                    shipCell.setHitCount(shipCell.getHitCount()+1);
                    cell_b[x_coordinate][y_coordinate]=shipCell;
                }
                else if(shipCell.getHitCount()==2)
                {
                    //System.out.println("This part of Q type being hit second time hence destroying this part");
                    cell_b[x_coordinate][y_coordinate]=null;
                }
            }
        }

        target.setBattlearea(cell_b);


        return status;
    }
}
